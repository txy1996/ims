package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.DemoDAO;
import com.pydyun.ims.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
	@Resource
	private DemoDAO demo;
	@Override
	public boolean insertDemo(String code,String mobile,String password) {
		code = (code == null || "".equals(code))?null:code;
		mobile = (mobile == null || "".equals(mobile))?null:code;
		password = (password == null || "".equals(password))?null:code;
		demo.insetDemo(mobile, code, password);
		return true;
	}

}
