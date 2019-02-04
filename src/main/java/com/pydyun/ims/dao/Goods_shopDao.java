package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Goods_shop;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

public interface Goods_shopDao {

	List<Goods_shop> select(PointsGoldCoinsRequest request);

	void delete(Integer gid);

	void addshop(Goods_shop goods_shop);

	List<String> shop();
	
	Integer seleteNum(Integer sid);

}
