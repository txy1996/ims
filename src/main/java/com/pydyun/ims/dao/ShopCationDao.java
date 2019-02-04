package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.ShopCation;

public interface ShopCationDao {

	List<ShopCation> findAllSett();

	ShopCation getshop(Integer scid);

	void delete(Integer scid);

	void add(ShopCation shop);

	void updateshop(ShopCation shop);

	List<String> listname();

	List<String> listid();

	List<ShopCation> findscscid(Integer scscid);

	String findscscname(Integer scid);


}
