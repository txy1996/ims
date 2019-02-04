package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.ShopCationDao;
import com.pydyun.ims.model.ShopCation;
import com.pydyun.ims.service.ShopCationService;

@Service
public class ShopCationServiceImpl implements ShopCationService {
	@Resource
	private ShopCationDao ShopCationDao;

	@Override
	public PageInfo<ShopCation> selectshopcation(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<ShopCation> list = ShopCationDao.findAllSett();
		for(ShopCation sc:list){
			if(sc.getScscid()==null||sc.getScscid().equals("")){
				sc.setScscid(0);
			}
			sc.setScscname(ShopCationDao.findscscname(sc.getScscid()));
		}
		return new PageInfo<>(list);
	}

	@Override
	public ShopCation getshop(Integer scid) {
		return ShopCationDao.getshop(scid);
	}

	@Override
	public void deleteshop(Integer scid) {
		ShopCationDao.delete(scid);
		
	}

	@Override
	public Integer addshop(ShopCation shop) {
		ShopCationDao.add(shop);
		return shop.getScid();
		
	}

	@Override
	public void updateshop(ShopCation shop) {
		ShopCationDao.updateshop(shop);
		
	}

	@Override
	public List<String> listname() {
		return ShopCationDao.listname();
	}

	@Override
	public List<String> selectid() {
		return ShopCationDao.listid();
	}

	@Override
	public List<ShopCation> findAllSett() {
		// TODO Auto-generated method stub
		return ShopCationDao.findAllSett();
	}

	@Override
	public List<ShopCation> findscscid(Integer scid) {
		// TODO Auto-generated method stub
		return ShopCationDao.findscscid(scid);
	}

	@Override
	public String findscscname(Integer scid) {
		// TODO Auto-generated method stub
		return ShopCationDao.findscscname(scid);
	}
	
}
