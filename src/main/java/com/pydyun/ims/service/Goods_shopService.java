package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Goods_shop;
import com.pydyun.ims.model.PointsGoldCoinsRequest;

public interface Goods_shopService {

	PageInfo<Goods_shop> shopmoney(Integer pageNum, Integer pageSize,PointsGoldCoinsRequest request);

	void delete(Integer gid);

	Integer addshop(Goods_shop goods_shop);

	List<String> shop();

	Integer seleteNum(Integer sid);
}
