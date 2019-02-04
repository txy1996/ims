package com.pydyun.ims.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Company;

public interface CompanyService {
	PageInfo<Company> queryAll(Integer pageNum, Integer pageSize,Map<String,Object> map);
	Integer addCompany(Company company);
	void deleteCompany(int id);
	void updateCompany(Company company);
	Company queryById(int id);
	List<Company> selectAllZName();
	List<String> querzone();
}
