package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.User_position;

public interface UserPositionService {
	PageInfo<User_position> queryAll(Integer pageNum, Integer pageSize);
	void deletePositon(int id);
	User_position queryById(int id);
	int addPosition(User_position position);
	void updatePosition(User_position position);
	/**
	 * 头衔
	 * @return
	 */
	List<String> getMessage();
	/**
	 * 公司
	 * @return
	 */
	List<String> getCompanyMsg();
	/**
	 * 用户
	 * @return
	 */
	List<String> getUsername();
}
