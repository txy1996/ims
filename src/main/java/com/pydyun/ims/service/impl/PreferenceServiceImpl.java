package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.PreferenceDao;
import com.pydyun.ims.service.PreferenceService;

@Service
public class PreferenceServiceImpl implements PreferenceService{

	@Resource
	PreferenceDao Preferencedao;
	   
	@Override
	public Integer findyhbyid(Integer lid) {
		// TODO Auto-generated method stub
		return Preferencedao.findyhbyid(lid);
	}

	@Override
	public String findname(Integer lid) {
		// TODO Auto-generated method stub
		return Preferencedao.findname(lid);
	}


}
