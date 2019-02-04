package com.pydyun.ims.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.CompanyDAO;
import com.pydyun.ims.dao.ZoneDao;
import com.pydyun.ims.model.Company;
import com.pydyun.ims.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService{
	@Resource
	private CompanyDAO companyDao;
	
	@Resource ZoneDao  zd;
	@Override
	public PageInfo<Company> queryAll(Integer pageNum, Integer pageSize, Map<String, Object> map) {
		PageHelper.startPage(pageNum,pageSize);
		List<Company> com = companyDao.queryAll(map);
		return new PageInfo<>(com);
	}
	@Override
	public Integer addCompany(Company company) {
		companyDao.addCompany(company);
		return company.getCid();
	}
	@Override
	public void deleteCompany(int id) {
		// TODO Auto-generated method stub
		companyDao.deleteCompany(id);
		
	}
	@Override
	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		companyDao.updateCompany(company);
	}
	@Override
	public Company queryById(int id) {
		// TODO Auto-generated method stub
		return companyDao.findById(id);
	}
	@Override
	public List<Company> selectAllZName() {
		// TODO Auto-generated method stub
		return companyDao.selectAllZName();
	}
	@Override
	public List<String> querzone() {
		// TODO Auto-generated method stub
		return zd.querzone();
	}

	
	
	
}
