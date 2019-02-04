package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopBrand;

public interface ShopBrandService {

	PageInfo<ShopBrand> selectshopcation(Integer pageNum, Integer pageSize);

	void deleteshop(Integer bid);

	Integer addshop(ShopBrand shop);

	ShopBrand getshop(Integer bid);

	void updateshop(ShopBrand shop);

	List<String> findname();
	
	List<ShopBrand> selectall();
	
	List<ShopBrand> selectshop1(Integer bid);
	ShopBrand selectshop2(Integer bid);
}
