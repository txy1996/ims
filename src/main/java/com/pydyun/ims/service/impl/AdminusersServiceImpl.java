package com.pydyun.ims.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.AdminusersDao;
import com.pydyun.ims.model.Adminusers;
import com.pydyun.ims.service.AdminusersService;

@Service
public class AdminusersServiceImpl implements AdminusersService{
	@Resource
	private AdminusersDao adminDao;
	@Override
	public Adminusers getOne(int id) {
		// TODO Auto-generated method stub
		return adminDao.getOne(id);
	}
	@Override
	public Adminusers getAll() {
		// TODO Auto-generated method stub
		return adminDao.getAll();
	}
	
}
