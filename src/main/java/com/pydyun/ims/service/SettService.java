package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Settings;

public interface SettService {

	PageInfo<Settings> getAllMessage(Integer pageNum,Integer pageSize,String systitle);
	void updateSettings(Settings settings);
	void delteSett(int id);//删除
	Settings GetMsgByTitle(String systitle);
	Settings findById(int id);
	boolean addSett(Settings settings);//添加信息
	
}
	