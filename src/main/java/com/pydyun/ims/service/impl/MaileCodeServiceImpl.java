package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.MaileCodeDao;
import com.pydyun.ims.service.MaileCodeService;
@Service
public class MaileCodeServiceImpl implements MaileCodeService {
	@Resource
	private MaileCodeDao maileCode;

	@Override
	public boolean creEmailCode(String phone, String password, String code) {
		phone = (phone == null || "".equals(phone))?null:phone;
		password = (password == null || "".equals(password))?null:password;
		code = (code == null || "".equals(code))?null:code;
		boolean b = maileCode.creEmaileCode(password, phone, code);
		if(b) {
			return true;
		}
		return false;
	}
	

}
