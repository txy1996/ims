package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxIntentorder;

/**
 * wx意向订单dao
 * @author fy
 *
 */
public interface WxIntentorderDao {

	//新增意向订单
	boolean insertIntentionOrder(WxIntentorder wxIntentorder);

	//查询定制方案
	List<WxIntentorder> queryCustomization(Integer urid);

}
