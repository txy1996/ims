package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxUser_level;

public interface WxUserDao {

	List<WxUser_level> level(Integer id);

}
