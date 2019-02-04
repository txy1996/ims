package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Property;

public interface PropertyDao {
	List<Property> selectBypcid(Integer pcid);

	void delete(Integer id);

	List<Property> selectall();

	void insert(Property pro);

	void deleteproperty(Integer pcid);
}
