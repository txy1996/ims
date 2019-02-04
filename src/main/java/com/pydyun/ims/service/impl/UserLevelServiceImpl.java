package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.UserLevelDao;
import com.pydyun.ims.model.UserLevel;
import com.pydyun.ims.service.UserLevelService;
@Service
public class UserLevelServiceImpl implements UserLevelService {
	@Resource
	private UserLevelDao ud;
	@Override
	public int addLevel(UserLevel userLevel) {
		ud.addLevel(userLevel);
		return userLevel.getUlid();
	}

	@Override
	public void deleteLevel(int ulid) {
		ud.deleteLevel(ulid);
	}

	@Override
	public void updateLevel(UserLevel userLevel) {
		ud.updateLevel(userLevel);
	}

	@Override
	public UserLevel polling(int ulid) {
		return ud.inquiry(ulid);
	}

	@Override
	public PageInfo<UserLevel> pollingList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<UserLevel> uList = ud.pollingMessage();
		return new PageInfo<>(uList);
	}

	
	
}
