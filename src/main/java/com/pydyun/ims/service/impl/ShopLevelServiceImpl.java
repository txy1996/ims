package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ShopLevelDao;
import com.pydyun.ims.model.ShopLevel;
import com.pydyun.ims.service.ShopLevelService;
@Service
public class ShopLevelServiceImpl implements ShopLevelService{

	@Resource
	private ShopLevelDao ShopLevelDao;
	
	@Override
	public PageInfo<ShopLevel> selectshop(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<ShopLevel> list = ShopLevelDao.selectshop();
		return new PageInfo<>(list);
	}

	@Override
	public void delete(Integer slid) {
		ShopLevelDao.delete(slid);
	}

	@Override
	public ShopLevel getLevel(Integer slid) {
		return ShopLevelDao.getLevel(slid);
	}

	@Override
	public void update(ShopLevel shoplevel) {
		ShopLevelDao.update(shoplevel);
	}

	@Override
	public Integer add(ShopLevel shoplevel) {
		ShopLevelDao.add(shoplevel);
		return shoplevel.getSlid();
	}

}
