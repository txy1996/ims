package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Couponclass;

public interface CouponclassService {

	PageInfo<Couponclass> select(Integer pageNum, Integer pageSize);

	void delete(Integer ccid);

	Integer add(Couponclass couponclass);

	Couponclass getcoupon(Integer ccid);

	void update(Couponclass couponclass);
	
	List<String> getName();
	
	List<Couponclass> getccname();
}
