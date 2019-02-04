package com.pydyun.ims.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.UserCouponDao;
import com.pydyun.ims.model.U_c_log;
import com.pydyun.ims.service.UserCouponService;

@Service
public class UserCouponServiceImpl implements UserCouponService{

	@Resource
	UserCouponDao dao;

	@Override
	public PageInfo<U_c_log> findall(Integer pageNum, Integer pageSize, Integer urid, String starttime, String endtime,
			Integer ucstate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<U_c_log> list = dao.findall(urid,starttime,endtime,ucstate);
		return new PageInfo<>(list);
	}

	@Override
	public List<U_c_log> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public void update(Integer uclid, String ucinfo,Date date) {
		// TODO Auto-generated method stub
		dao.update(uclid, ucinfo,date);
	}

	@Override
	public void update1(Integer uclid, String ucinfo) {
		// TODO Auto-generated method stub
		dao.update1(uclid, ucinfo);
	}
	

}
