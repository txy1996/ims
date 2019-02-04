package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.UserLevel;

public interface UserLevelService {
	/**
	 * 添加等级信息
	 * @param userLevel
	 * @return
	 */
	int addLevel(UserLevel userLevel);
	/**
	 * 删除对应等级信息
	 * @param ulid
	 */
	void deleteLevel(int ulid);
	/**
	 *更改 
	 * @param userLevel
	 */
	void updateLevel(UserLevel userLevel);
	/**
	 * 通过ulid查询对应信息
	 * @param ulid
	 * @return
	 */
	
	UserLevel polling(int ulid);
	/**
	 * 分页回显等级信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<UserLevel> pollingList(Integer pageNum, Integer pageSize);
	
}
