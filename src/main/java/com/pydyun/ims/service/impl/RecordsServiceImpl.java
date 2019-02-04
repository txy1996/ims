package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.RecordsDao;
import com.pydyun.ims.model.Records;
import com.pydyun.ims.service.RecordsService;

@Service
public class RecordsServiceImpl implements RecordsService{

	@Resource
	private RecordsDao recordsDao;
	
	@Override
	public Integer findnumber(String vrange) {
		// TODO Auto-generated method stub
		return recordsDao.findnumber(vrange);
	}

	@Override
	public Integer findnumber1(String vrange) {
		// TODO Auto-generated method stub
		return recordsDao.findnumber1(vrange);
	}

	@Override
	public void addReVoucher(Records records) {
		// TODO Auto-generated method stub
		recordsDao.addReVoucher(records);
	}

	@Override
	public Integer findid() {
		// TODO Auto-generated method stub
		return recordsDao.findid();
	}

}
