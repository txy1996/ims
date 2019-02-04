package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ProductClass;

public interface ProductClassService {
	
	PageInfo<ProductClass> getProductClass(Integer pageNum, Integer pageSize);

	void addClass(ProductClass productClass);

	String selectbyid(Integer id);

	void deleteByid(Integer id);

	List<ProductClass> findcid(Integer cid);
	
	List<ProductClass> selectAll();
	
	ProductClass findproclass(Integer id);
	
	List<ProductClass> finds();

	String findccname(Integer cid);

	Integer findmodel(Integer pcid);

	List<ProductClass> findtemplet();
}
