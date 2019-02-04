package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.PointsGoldCoinsRequest;
import com.pydyun.ims.model.Slintegration;

public interface SlintegrationService {

    /**
     * @Title: select 
     * @Description: TODO(商户积分条件分页查询) 
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
	PageInfo<Slintegration> selectSlintegration(Integer pageNum, Integer pageSize,PointsGoldCoinsRequest request);

	
	/**
	 * @Title: addSlintegration 
	 * @Description: TODO(新增商户积分记录) 
	 * @param slintegration
	 */
	void addSlintegration(Slintegration slintegration);
	
	
	/**
     * @Title: seleteNum 
     * @Description: TODO(根据商户id查询商户当前积分) 
     * @param sid
     * @return
     */
    Integer seleteNum(Integer sid);
	
	void delete(Integer slid);
	
	void addshop(Slintegration slintegration);
	
	Integer seleteNumA(Integer sid);

}
