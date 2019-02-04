package com.pydyun.ims.service.wxservice;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxIntentorder;

/**
 * wx意向订单service
 * @author fy
 *
 */
public interface WxIntentorderService {
	
	//新增意向订单
	boolean insertIntentionOrder(WxIntentorder wxIntentorder);

	//查询当前用户定制的方案
	PageInfo<WxIntentorder> queryCustomization(Integer urid, Integer pageNum, Integer pageSize);

}
