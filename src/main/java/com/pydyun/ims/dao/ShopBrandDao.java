package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.ShopBrand;

public interface ShopBrandDao {

	List<ShopBrand> selectshop();

	void delete(Integer bid);

	void add(ShopBrand shop);

	ShopBrand getshop(Integer bid);

	void updateshop(ShopBrand shop);
	
	List<String> findname();
	
	List<ShopBrand> selectshop1(Integer bid);
	
	ShopBrand selectshop2(Integer bid);

}
