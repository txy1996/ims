package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopLevel;

public interface ShopLevelService {

	PageInfo<ShopLevel> selectshop(Integer pageNum, Integer pageSize);

	void delete(Integer slid);

	ShopLevel getLevel(Integer slid);

	void update(ShopLevel shoplevel);

	Integer add(ShopLevel shoplevel);

}
