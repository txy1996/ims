package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Coupon;
import com.pydyun.ims.model.Voucher;

public interface CouponDao {

	List<Coupon> select();
	void delete(Integer cid);
	void add(Coupon coupon);
	void update(Coupon coupon);
	Coupon getcoupon(int cid);
	List<Coupon> getMessage(int id);
	List<Coupon> findbys(@Param("crange")String crange);
	void addMessage1(Coupon coupon);
	void addcou(Coupon cp);
	void update1(@Param("cid")Integer cid,@Param("codate") Integer codate);
	
	
	List<Coupon> findall1(@Param("crange")String crange,@Param("csdate")String csdate,@Param("codate")String codate,@Param("cstore")Integer cstore,@Param("cstore2")Integer cstore2);
	
	Coupon getmessage1(Integer cid);
	void update2(Coupon co);
	void deleteshopcoupon(Integer cid);
	
	Coupon findbyid(Integer vid);
	void updatecstore(@Param("cid")Integer cid,@Param("cstore")Integer cstore);
	String selectimg(Integer cid);
}
