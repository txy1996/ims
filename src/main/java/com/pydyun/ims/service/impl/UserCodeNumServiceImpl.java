package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.UserCodeNumDAO;
import com.pydyun.ims.model.UserCodeNum;
import com.pydyun.ims.service.UserCodeNumService;
@Service
public class UserCodeNumServiceImpl implements UserCodeNumService{
	@Resource
	private UserCodeNumDAO userCodeNumDAO;
	@Override
	public void insertUserCodeNum(UserCodeNum userCodeNum) {
		// TODO Auto-generated method stub
		userCodeNumDAO.insertUserCodeNum(userCodeNum);
	}
	@Override
	public UserCodeNum select() {
		// TODO Auto-generated method stub
		return userCodeNumDAO.selectCode();
	}

}
