package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxShopRequest;

public interface WxShopRequestDao {

	List<WxShopRequest> hotpot();

	List<WxShopRequest> Chinesefood();

	List<WxShopRequest> Westernstyle();

	List<WxShopRequest> activity();

	List<WxShopRequest> shoplist(Integer id);

}
