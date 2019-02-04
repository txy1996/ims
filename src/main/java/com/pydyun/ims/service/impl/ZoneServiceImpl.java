package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.ZoneDao;
import com.pydyun.ims.model.Zone;
import com.pydyun.ims.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService{
	@Resource
	private ZoneDao zDao;

	@Override
	public List<Zone> selectzid() {
		List<Zone> list = zDao.selectzid();
		return list;
	}

}
