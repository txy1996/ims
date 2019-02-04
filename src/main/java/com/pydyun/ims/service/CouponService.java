package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Coupon;

public interface CouponService {

	PageInfo<Coupon> selectcoupon(Integer pageNum, Integer pageSize);

	void delete(Integer cid);

	int add(Coupon coupon);
	
	void update(Coupon coupon);
	
	Coupon getcoupon(Integer cid);
	
	List<Coupon> getMessage(int id);
	
	List<Coupon> findbys(String crange);
	
	void addMessage1(Coupon coupon);
	
	void update1(Integer cid, Integer time);

	void addcou(Coupon cp);
	
	PageInfo<Coupon> findall1(Integer pageNum, Integer pageSize,String crange,String starttime,String endtime,Integer cstore1,Integer cstore2);
	Coupon getmessage1(Integer cid);
	void update2(Coupon co);
	void deleteshopcoupon(Integer vid);

}
