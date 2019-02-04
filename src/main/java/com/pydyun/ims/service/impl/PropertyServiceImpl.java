package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.PropertyDao;
import com.pydyun.ims.model.Property;
import com.pydyun.ims.service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService{

	@Resource
	PropertyDao propertyDao;
	@Override
	public List<Property> selectBypcid(Integer pcid) {
		// TODO Auto-generated method stub
		return propertyDao.selectBypcid(pcid);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		propertyDao.delete(id);
	}
	@Override
	public List<Property> selectall() {
		// TODO Auto-generated method stub
		return propertyDao.selectall();
	}
	@Override
	public void insert(Property pro) {
		// TODO Auto-generated method stub
		propertyDao.insert(pro);
	}
	@Override
	public void deletproperty(Integer id) {
		// TODO Auto-generated method stub
		propertyDao.deleteproperty(id);
	}

}
