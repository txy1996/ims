package com.pydyun.ims.dao;


import com.pydyun.ims.model.Adminusers;

public interface AdminusersDao {
	Adminusers getOne(int id);
	Adminusers getAll();
}
