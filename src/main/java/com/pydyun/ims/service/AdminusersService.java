package com.pydyun.ims.service;


import com.pydyun.ims.model.Adminusers;

public interface AdminusersService {
	Adminusers getOne(int id);
	Adminusers getAll();	
}
