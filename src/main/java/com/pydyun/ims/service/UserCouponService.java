package com.pydyun.ims.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.U_c_log;

public interface UserCouponService {
	PageInfo<U_c_log> findall(Integer pageNum, Integer pageSize,Integer urid,String starttime,String endtime,Integer ucstate);
	List<U_c_log> select();
	void update(Integer uclid, String ucinfo,Date date);
	void update1(Integer uclid, String ucinfo);
}
