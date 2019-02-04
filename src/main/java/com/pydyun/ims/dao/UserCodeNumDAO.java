package com.pydyun.ims.dao;


import com.pydyun.ims.model.UserCodeNum;

public interface UserCodeNumDAO {
	void insertUserCodeNum(UserCodeNum userCodeNum);
	UserCodeNum selectCode();
}
