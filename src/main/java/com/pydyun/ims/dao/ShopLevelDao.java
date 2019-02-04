package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.ShopLevel;

public interface ShopLevelDao {

	List<ShopLevel> selectshop();

	void add(ShopLevel shoplevel);

	void update(ShopLevel shoplevel);

	ShopLevel getLevel(Integer slid);

	void delete(Integer slid);

}
