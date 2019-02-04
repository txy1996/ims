package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.CouponclassDao;
import com.pydyun.ims.model.Couponclass;
import com.pydyun.ims.service.CouponclassService;

@Service
public class CouponclassServiceImpl implements CouponclassService{
	
	@Resource 
	private CouponclassDao CouponclassDao;

	@Override
	public PageInfo<Couponclass> select(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Couponclass> list = CouponclassDao.select();
		return new PageInfo<>(list);
	}

	@Override
	public void delete(Integer ccid) {
		CouponclassDao.delete(ccid);
	}

	@Override
	public Integer add(Couponclass couponclass) {
		CouponclassDao.add(couponclass);
		return couponclass.getCcid();
	}

	@Override
	public Couponclass getcoupon(Integer ccid) {
		return CouponclassDao.getcoupon(ccid);
	}

	@Override
	public void update(Couponclass couponclass) {
		CouponclassDao.update(couponclass);
	}

	@Override
	public List<String> getName() {
		// TODO Auto-generated method stub
		return CouponclassDao.getName();
	}

	@Override
	public List<Couponclass> getccname() {
		// TODO Auto-generated method stub
		return CouponclassDao.getccname();
	}
	
}
