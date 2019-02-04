package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.CouponDao;
import com.pydyun.ims.model.Coupon;
import com.pydyun.ims.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{

	@Resource
	private CouponDao CouponDao;

	@Override
	public PageInfo<Coupon> selectcoupon(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Coupon> list = CouponDao.select();
		return new PageInfo<>(list);
	}

	@Override
	public int add(Coupon coupon) {
		CouponDao.add(coupon);
		return coupon.getCid();
	}

	@Override
	public void delete(Integer cid) {
		CouponDao.delete(cid);
	}

	@Override
	public Coupon getcoupon(Integer cid) {
		return CouponDao.getcoupon(cid);
	}

	@Override
	public void update(Coupon coupon) {
			CouponDao.update(coupon);
	}

	@Override
	public List<Coupon> getMessage(int id) {
		// TODO Auto-generated method stub
		return CouponDao.getMessage(id);
	}

	@Override
	public List<Coupon> findbys(String crange) {
		// TODO Auto-generated method stub
		return CouponDao.findbys(crange);
	}

	@Override
	public void addMessage1(Coupon coupon) {
		// TODO Auto-generated method stub
		CouponDao.addMessage1(coupon);
	}

	@Override
	public void addcou(Coupon cp) {
		// TODO Auto-generated method stub
		CouponDao.addcou(cp);
		
	}

	@Override
	public void update1(Integer cid, Integer time) {
		// TODO Auto-generated method stub
		CouponDao.update1(cid, time);
	}
	
	@Override
	public PageInfo<Coupon> findall1(Integer pageNum, Integer pageSize,String crange,String starttime,String endtime,Integer cstore1,Integer cstore2) {
		// TODO Auto-generated method stub
		 List<Coupon> list = CouponDao.findall1(crange,starttime,endtime,cstore1,cstore2);
		 return new PageInfo<>(list);
	}

	@Override
	public Coupon getmessage1(Integer cid) {
		// TODO Auto-generated method stub
		return CouponDao.getmessage1(cid);
	}

	@Override
	public void update2(Coupon co) {
		// TODO Auto-generated method stub
		CouponDao.update2(co);
	}

	@Override
	public void deleteshopcoupon(Integer cid) {
		// TODO Auto-generated method stub
		CouponDao.deleteshopcoupon(cid);
	}	
}
