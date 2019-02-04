package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Couponclass;

public interface CouponclassDao {

	List<Couponclass> select();

	void delete(Integer ccid);

	void add(Couponclass couponclass);

	Couponclass getcoupon(Integer ccid);

	void update(Couponclass couponclass);
	
	List<String> getName();
	
	List<Couponclass> getccname();
}
