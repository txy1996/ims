package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopCation;

public interface ShopCationService {

	PageInfo<ShopCation> selectshopcation(Integer pageNum, Integer pageSize);

	ShopCation getshop(Integer scid);

	void deleteshop(Integer scid);

	Integer addshop(ShopCation shop);

	void updateshop(ShopCation shop);

	List<String> listname();

	List<String> selectid();

	List<ShopCation> findAllSett();

	List<ShopCation> findscscid(Integer scid);

	String findscscname(Integer scid);
}
