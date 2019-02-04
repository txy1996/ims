package com.pydyun.ims.service;

import java.util.List;

import com.pydyun.ims.model.Property;

public interface PropertyService {
	List<Property> selectBypcid(Integer pcid);

	void delete(Integer id);

	List<Property> selectall();

	void insert(Property pro);

	void deletproperty(Integer id);
}
