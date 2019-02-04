package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxShopclass;

public interface WxShopclassDao {
	List<WxShopclass> restaurant(Integer id);

	List<WxShopclass> listsang(Integer id1);

	List<WxShopclass> listtravel(Integer id2);

}
