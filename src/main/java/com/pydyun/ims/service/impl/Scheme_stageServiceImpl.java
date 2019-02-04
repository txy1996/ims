package com.pydyun.ims.service.impl;

import com.pydyun.ims.dao.Scheme_stageDao;
import com.pydyun.ims.model.*;
import com.pydyun.ims.service.SchemeAndStageAndShopService;
import com.pydyun.ims.service.Scheme_stageService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangxiaoyu
 * @ClassName: Scheme_stageServiceImpl
 * @Description: TODO(方案阶段)
 * @date 2018年7月16日 下午5:08:06
 */
@Service
public class Scheme_stageServiceImpl implements Scheme_stageService
{

    @Resource
    private Scheme_stageDao scheme_stageDao;

    @Resource
    private SchemeAndStageAndShopService stageAndShopService;

    @Override
    public List<SchemeAlternativeShop> foundAlternateMerchant(List<Integer> ssids) throws Exception {
        if (ssids == null) {
            throw new InvalidParameterException("备选商家不能为空");
        }

        return scheme_stageDao.foundAlternateMerchant(ssids);
    }

    @Override
    public List<SchemeAndStageResponse> foundSchemeAndStage(Integer sid) {
        // TODO Auto-generated method stub
        return scheme_stageDao.foundSchemeAndStage(sid);
    }

    @Override
    @Transactional
    public Scheme_stage addStage(Scheme_stage scheme_stage) {

        scheme_stageDao.addStage(scheme_stage);
        return scheme_stage;

    }

    @Override
    public Integer updateStage(Scheme_stage scheme_stage) {

        return scheme_stageDao.updateStage(scheme_stage);
    }

    @Override
    public Integer findSchemeStageBySid(Integer sid) {
        // TODO Auto-generated method stub
        return scheme_stageDao.findSchemeStageBySid(sid);
    }

    @Override
    public Integer deleteStage(Integer ssid) {
        // TODO Auto-generated method stub
        return scheme_stageDao.deleteStage(ssid);
    }

    @Override
    public SchemeAndStageAndShop foundProductBySsid(List<Integer> ssids) {
        List<SchemeAndStageAndShop> shop = dataProcessing(stageAndShopService.foundProductBySsid(ssids));

        return shop.get(0);
    }

    @Override
    public List<StageShopGoodsResponse> foundProductInformation(List<Integer> ssids) {
        List<SchemeAndStageAndShop> shop = dataProcessing(stageAndShopService.foundProductBySsid(ssids));

        List<StageGoodsResponse> responses;
        List<List<StageGoodsResponse>> newResponses = new ArrayList<>();
        /*分阶段查询然后封装*/
        for (SchemeAndStageAndShop schemeAndStageAndShop : shop) {
            responses = scheme_stageDao.foundProductInformation(schemeAndStageAndShop.getPid());
            for (int i = 0; i < responses.size(); i++) {
                for (int x = 0; x < schemeAndStageAndShop.getPid().size(); x++) {
                    if (schemeAndStageAndShop.getPid().get(x).equals(responses.get(i).getId())) {
                        responses.get(i).setNum(schemeAndStageAndShop.getNum().get(x));
                        responses.get(i).setSsid(schemeAndStageAndShop.getSsid());
                        break;
                    }
                }
            }
            newResponses.add(responses);
        }
        /*分阶段封装*/
        List<StageShopGoodsResponse> responses1 = new ArrayList<>();
        for (List<StageGoodsResponse> newRespons : newResponses) {
            responses1.addAll(ProductGrouping(newRespons));
        }
        return responses1;
    }

    /*根据商户给商品分组*/
    private List<StageShopGoodsResponse> ProductGrouping(List<StageGoodsResponse> responses) {

        Map<Integer, List<StageGoodsResponse>> map = new HashMap<>();
        for (StageGoodsResponse response : responses) {
            List<StageGoodsResponse> list = map.get(response.getSid());
            /* 如果取不到数据,那么直接new一个空的ArrayList **/
            if (list == null) {
                list = new ArrayList<>();
                list.add(response);
                map.put(response.getSid(), list);
            } else {
                /* 某个对象之前已经存放过了,则直接追加数据到原来的List里 **/
                list.add(response);
            }
        }
        /*分组后的数组,进行最后的封装*/
        List<StageShopGoodsResponse> stageShopGoodsResponses = new ArrayList<>();
        for (List<StageGoodsResponse> goodsResponses : map.values()) {
            StageShopGoodsResponse stageShopGoodsResponse = new StageShopGoodsResponse();
            try {
                BeanUtils.copyProperties(stageShopGoodsResponse, goodsResponses.get(0));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            stageShopGoodsResponse.setStageGoodsResponses(goodsResponses);
            stageShopGoodsResponses.add(stageShopGoodsResponse);
        }
        return stageShopGoodsResponses;
    }

    /*商品数据处理*/
    private List<SchemeAndStageAndShop> dataProcessing(List<SchemeAndStageAndShop> shop) {
        ArrayList<Integer> pid;
        ArrayList<Integer> num;
        if (shop != null) {
            for (SchemeAndStageAndShop stageAndShop : shop) {
                pid = new ArrayList<>();
                num = new ArrayList<>();
                String[] arr = stageAndShop.getSreplace().split(",");
                for (String s : arr) {
                    String[] newarr = s.split(":");
                    pid.add(Integer.valueOf(newarr[0]));
                    num.add(Integer.valueOf(newarr[1]));
                }
                stageAndShop.setNum(num);
                stageAndShop.setPid(pid);
            }

        }
        return shop;
    }


}
