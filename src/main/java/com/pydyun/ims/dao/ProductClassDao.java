package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.ProductClass;

public interface ProductClassDao {
	
	List<ProductClass> getProductClass();

	void addClass(ProductClass productClass);

	String selectbyid(Integer id);

	void deleteByid(Integer id);

	List<ProductClass> findcid(Integer cid);
	
	ProductClass findproclass(Integer id);
	
	List<ProductClass> finds();

	String findccname(Integer id);

	Integer findmodel(Integer id);
	
	ProductClass finds1();
	
	List<ProductClass> findtemplet();
}
