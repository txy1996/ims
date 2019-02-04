package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserCollectionDao;
import com.pydyun.ims.model.WxUserCollection;
import com.pydyun.ims.model.WxUserCollectionProductResponse;
import com.pydyun.ims.model.WxUserCollectionShopResponse;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserCollectionServiceImpl
 * @Description: TODO(微信 : 个人中心 - 我的收藏)
 * @date 2018年8月9日 下午2:07:24
 */
@Service
public class WxUserCollectionServiceImpl implements WxUserCollectionService
{

    @Resource
    private WxUserCollectionDao wxUserCollectionDao;

    @Override
    public PageInfo<WxUserCollectionShopResponse> findUserCollectionByShop(Integer pageNum, Integer pageSize,Integer urid) {
        // TODO Auto-generated method stub
        PageHelper.startPage(pageNum,pageSize);
        List<WxUserCollectionShopResponse> list=wxUserCollectionDao.findUserCollectionByShop(urid);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<WxUserCollectionProductResponse> findUserCollectionByProduct(Integer pageNum, Integer pageSize,Integer urid) {
        PageHelper.startPage(pageNum,pageSize);
        List<WxUserCollectionProductResponse> list=wxUserCollectionDao.findUserCollectionByProduct(urid);
        return new PageInfo<>(list);
    }

	@Override
	public WxUserCollection findshou(String uid, String pid) {
		// TODO Auto-generated method stub
		return wxUserCollectionDao.findshou(uid, pid);
	}

	@Override
	public Integer insert(WxUserCollection wx) {
		// TODO Auto-generated method stub
		return wxUserCollectionDao.insert(wx);
	}

	@Override
	public Integer delete(Integer ucid) {
		// TODO Auto-generated method stub
        return wxUserCollectionDao.delete(ucid);
	}

	@Override
	public WxUserCollection scshop(Integer sid, Integer uid) {
		// TODO Auto-generated method stub
		return wxUserCollectionDao.scshop(sid, uid);
	}

	@Override
	public Integer Scshop(WxUserCollection wx) {
		// TODO Auto-generated method stub
		return wxUserCollectionDao.Scshop(wx);
	}

	@Override
	public Integer Qxshop(Integer ucid) {
		// TODO Auto-generated method stub
		return wxUserCollectionDao.Qxshop(ucid);
	}

}
