package com.pydyun.ims.service;

import com.pydyun.ims.model.UserCodeNum;

public interface UserCodeNumService {
	void insertUserCodeNum(UserCodeNum userCodeNum);
	UserCodeNum select();
}
