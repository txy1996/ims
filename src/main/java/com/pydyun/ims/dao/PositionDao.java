package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.User_position;

public interface PositionDao {
	List<User_position> queryAll();
	void deletePositon(int id);
	User_position selPositionById(int id);
	void updatePosition(User_position position);
	void addPosition(User_position position);
	/**
	 * 查询职位名
	 * @return
	 */
	List<String> getMessage();
}
