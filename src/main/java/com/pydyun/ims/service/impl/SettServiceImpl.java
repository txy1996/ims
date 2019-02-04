package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.SettDAO;
import com.pydyun.ims.model.Settings;
import com.pydyun.ims.service.SettService;

@Service
public class SettServiceImpl implements SettService{
	@Resource
	private SettDAO settDao;

	@Override
	public PageInfo<Settings> getAllMessage(Integer pageNum, Integer pageSize,String systitle) {
		PageHelper.startPage(pageNum,pageSize);
		List<Settings> sett = settDao.findAllSett(systitle);
		return new PageInfo<>(sett);
	}

	

	@Override
	public void delteSett(int id) {
		settDao.deleteSett(id);
	}

	@Override
	public Settings GetMsgByTitle(String systitle) {
		// TODO Auto-generated method stub
		return settDao.getSettByTitle(systitle);
	}

	@Override
	public Settings findById(int id) {
		// TODO Auto-generated method stub
		return settDao.findById(id);
	}

	@Override
	public boolean addSett(Settings settings) {
		boolean flag = settDao.addSettMsg(settings);
		if(flag) {
			return true;
		}
		return false;
	}



	@Override
	public void updateSettings(Settings settings) {
		settDao.updateSettings(settings);
		
	}



}
