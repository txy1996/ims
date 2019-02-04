package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxSettingsDao;
import com.pydyun.ims.model.WxSettings;
import com.pydyun.ims.service.wxservice.WxSettingsService;

@Service
public class WxSettingsServiceImpl implements WxSettingsService{

	@Resource
	private WxSettingsDao wto;

	@Override
	public List<WxSettings> sysreadme() {
		return wto.sysreadme();
	}
}
