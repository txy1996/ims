package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Settings;

public interface SettDAO {
	List<Settings> findAllSett(@Param("systitle")String systitle);
	void updateSettings(Settings settings);
	void deleteSett(int id);
	Settings getSettByTitle(String systitle);
	Settings findById(int id);
	boolean addSettMsg(Settings settings);
}
