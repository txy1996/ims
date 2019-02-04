package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ShopBrandDao;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.service.ShopBrandService;

@Service
public class ShopBrandServiceImpl implements ShopBrandService {
	@Resource
	private ShopBrandDao ShopBrandDao;

	@Override
	public PageInfo<ShopBrand> selectshopcation(Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<ShopBrand> list = ShopBrandDao.selectshop();
		return new PageInfo<>(list);
	}

	@Override
	public void deleteshop(Integer bid) {
		ShopBrandDao.delete(bid);
		
	}

	@Override
	public Integer addshop(ShopBrand shop) {
		ShopBrandDao.add(shop);
		return shop.getBid();
	}

	@Override
	public ShopBrand getshop(Integer bid) {
		return ShopBrandDao.getshop(bid);
	}

	@Override
	public void updateshop(ShopBrand shop) {
		ShopBrandDao.updateshop(shop);
		
	}

	@Override
	public List<String> findname() {
		// TODO Auto-generated method stub
		return ShopBrandDao.findname();
	}

	@Override
	public List<ShopBrand> selectall() {
		// TODO Auto-generated method stub
		return ShopBrandDao.selectshop();
	}

	@Override
	public List<ShopBrand> selectshop1(Integer bid) {
		// TODO Auto-generated method stub
		return ShopBrandDao.selectshop1(bid);
	}

	@Override
	public ShopBrand selectshop2(Integer bid) {
		// TODO Auto-generated method stub
		return ShopBrandDao.selectshop2(bid);
	}

}
