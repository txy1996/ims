package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxUserDao;
import com.pydyun.ims.model.WxUser_level;
import com.pydyun.ims.service.wxservice.WxUserService;

@Service
public class WxUserServiceImpl implements WxUserService{
	@Resource
	private WxUserDao udao;

	@Override
	public List<WxUser_level> level(Integer id)  {
		return udao.level(id);
	}

}
