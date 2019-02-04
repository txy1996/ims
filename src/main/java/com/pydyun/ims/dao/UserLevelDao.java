package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.UserLevel;

public interface UserLevelDao {
	/**
	 * 通过id查询相关等级信息
	 * @param ulid
	 * @return
	 */
	UserLevel inquiry(int ulid);
	/**
	 * 更新等级信息
	 * @param userLevel
	 */
	void updateLevel(UserLevel userLevel);
	/**
	 * 通过id删除对应的等级信息
	 * @param ulid
	 */
	void deleteLevel(int ulid);
	/**
	 * 添加等级信息
	 * @param userLevel
	 */
	void addLevel(UserLevel userLevel);
	/**
	 * 查询全部等级信息
	 * @return
	 */
	List<UserLevel> pollingMessage();
}
