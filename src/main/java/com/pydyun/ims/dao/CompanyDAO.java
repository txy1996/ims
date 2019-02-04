package com.pydyun.ims.dao;

import java.util.List;
import java.util.Map;

import com.pydyun.ims.model.Company;

public interface CompanyDAO {
	List<Company> queryAll(Map<String, Object> map);
	void addCompany(Company company);
	void deleteCompany(int id);
	Company findById(int id);
	void updateCompany(Company company);
	List<Company> selectAllZName();
	
	List<String> getName();
}