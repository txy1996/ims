package com.pydyun.ims.service.impl.wximpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.dao.WxAssessImageDao;
import com.pydyun.ims.dao.WxOrderGoodsDao;
import com.pydyun.ims.dao.WxOrdersDao;
import com.pydyun.ims.dao.WxUser_assessDao;
import com.pydyun.ims.model.*;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.util.FileUploadUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WxUserAssessServiceImpl implements WxUserAssessService
{

    @Resource
    private WxUser_assessDao wadao;

    @Resource
    private WxOrderGoodsDao wxOrderGoodsDao;
    @Resource
    private WxAssessImageDao wxAssessImageDao;

    @Resource
    private WxOrdersDao wxOrdersDao;

    @Override
    public List<WxUser_assess> selectassess(Integer uaoid) {
        // TODO Auto-generated method stub
        return wadao.selectassess(uaoid);
    }

    @Override
    public List<String> selectassessimg(Integer uaid) {
        // TODO Auto-generated method stub
        return wadao.selectassessimg(uaid);
    }

    /**
     * @param request
     * @Description: TODO(新增用户评论)
     * @param: wxUserAssess
     * @return:Integer
     * @Date: 2018/8/31 17:51
     */
    @Transactional
    @Override
    public WxUserAssess saveWxUserAssess(WxUserAssessRequest request) {
        Gson gson = new Gson();
        List<String> list = gson.fromJson(request.getUrlJson(), new TypeToken<List<String>>()
        {
        }.getType());
        request.setUrl(list);
        WxUserAssess wxUserAssess = new WxUserAssess();
        try {
            BeanUtils.copyProperties(wxUserAssess, request);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /*评论商品*/
        wxUserAssess.setUaotype(3);
        wadao.saveWxUserAssess(wxUserAssess);
        Integer plid = wxUserAssess.getUaid();

        WxOrderGoods wxOrderGoods = new WxOrderGoods();
        /*修改商品评论状态*/
        wxOrderGoods.setIsrm(1);
        wxOrderGoods.setOid(request.getOid());
        wxOrderGoods.setVid(request.getUaoid());
        wxOrderGoods.setVtype(0);
        wxOrderGoodsDao.updateWxOrderGoods(wxOrderGoods);

        /*查询所属批次得订单id*/
        List<Integer> oids = wxOrdersDao.findWxOrdersOid(request.getOnoun());
        /*查询统计未评论得商品数量*/
        Integer num = wxOrderGoodsDao.findWxOrderGoodsByIds(oids);
        /*修改订单状态*/
        if (num == 0) {
            wxOrdersDao.updateWxOrders(oids, 1);
        }
        List<WxAssessImage> wxAssessImages = new ArrayList<>();
        WxAssessImage wxAssessImage;
        String url;
        if (request.getFiles() != null && request.getFiles().size() > 0) {
            for (MultipartFile file : request.getFiles()) {
                wxAssessImage = new WxAssessImage();
                url = FileUploadUtil.ImageUpload(file);
                wxAssessImage.setPlid(plid);
                wxAssessImage.setIurl(url);
                wxAssessImage.setTfimg(0);
                wxAssessImages.add(wxAssessImage);
            }
            wxAssessImageDao.saveWxAssessImage(wxAssessImages);
        }


        return wxUserAssess;
    }

    @Override
    public List<WxUserAssess> findWxUserAssessByUaoid(Integer uaoid, Integer uaotype, boolean flag) {

        List<WxUserAssess> wxUserAssesses = wadao.findWxUserAssessByUaoid(uaoid, uaotype);
        List<Integer> ids = new ArrayList<>();
        /*方案详情界面取前三条*/
        if (flag) {
            if (wxUserAssesses.size() > 3) {
                wxUserAssesses = wxUserAssesses.subList(0, 3);
            }
        }
        for (WxUserAssess wxUserAssess : wxUserAssesses) {
            ids.add(wxUserAssess.getUaid());
        }
        /*循环放入评论图片,效率太低,需要改进*/
        if (ids.size() > 0) {
            List<WxAssessImage> wxAssessImages = wxAssessImageDao.findWxAssessImages(ids);
            if (!wxAssessImages.isEmpty()) {
                List<String> strings;
                for (WxAssessImage wxAssessImage : wxAssessImages) {
                    for (WxUserAssess wxUserAssess : wxUserAssesses) {
                        if (wxAssessImage.getPlid().equals(wxUserAssess.getUaid())) {
                            if (!wxAssessImage.getIurl().isEmpty()) {
                                strings = new ArrayList<>();
                                strings.add(wxAssessImage.getIurl());
                                if (wxUserAssess.getUrl() != null) {
                                    strings.addAll(wxUserAssess.getUrl());
                                }
                                wxUserAssess.setUrl(strings);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return wxUserAssesses;
    }

	@Override
	public PageInfo<WxUser_assess> selectassess1(Integer uaoid, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxUser_assess> selectassess = new ArrayList<>();
		List<String> ls = new ArrayList<>();
//		if (wadao.selectassess1(uaoid) != null && wadao.selectassess1(uaoid).size() != 0) {
			selectassess = wadao.selectassess1(uaoid);
			for (WxUser_assess ss : selectassess) {
				WxImagesPl wx = new WxImagesPl();
				// 查找评论的图片，一条评论对应数据库图片表多张图片
				for (int j = 0; j < selectassess.size(); j++) {
					if (selectassess.get(j).getUaid() == ss.getUaid()) {
						List<String> selectassessimg = wadao
								.selectassessimg(selectassess.get(j).getUaid());
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < selectassessimg.size(); i++) {
							if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
								sb.append(",");
							}
							sb.append(selectassessimg.get(i));
						}
						wx.setIurl(sb.toString());
						String a = wx.getIurl();
						String[] split = a.split(",");
						ls = Arrays.asList(split);
						for (String LS : ls) {
							LS.replace("http://", "https://");
						}
						ss.setList(ls);
						ss.setWximages_pl(wx);
					}
				}
				if (ss.getUaisanonymous().equals(0) || ss.getUaisanonymous() == 0) {
					WxSys_user us = new WxSys_user();
					us.setUsername("匿名用户");
					us.setHead(ss.getWxsys_user().getHead());
					ss.setWxsys_user(us);
				}
			}
//		} else {
//			WxUser_assess wxa = new WxUser_assess();
//			wxa.setUainfo("暂无评论");
//			hashset.add(wxa);
//		}
		return new PageInfo<>(selectassess);
	}


}
