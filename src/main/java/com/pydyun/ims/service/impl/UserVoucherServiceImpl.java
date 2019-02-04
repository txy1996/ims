package com.pydyun.ims.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.UserVoucherDao;
import com.pydyun.ims.model.U_v_log;
import com.pydyun.ims.service.UserVoucherService;

@Service
public class UserVoucherServiceImpl implements UserVoucherService{

	@Resource
	UserVoucherDao dao;
	@Override
	public PageInfo<U_v_log> findall(Integer pageNum, Integer pageSize,Integer urid,String starttime,String endtime,Integer uvlstate) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<U_v_log> list = dao.findall(urid,starttime,endtime,uvlstate);
		return new PageInfo<>(list);
	}
	@Override
	public List<U_v_log> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}
	@Override
	public void update(Integer uvlid, String uvinfo,Date date) {
		// TODO Auto-generated method stub
		dao.update(uvlid,uvinfo,date);
	}
	@Override
	public void update1(Integer uvlid, String uvinfo) {
		// TODO Auto-generated method stub
		dao.update1(uvlid,uvinfo);
	}
	@Override
	public List<Integer> findvid(Integer urid) {
		// TODO Auto-generated method stub
		return dao.findvid(urid);
	}

}
