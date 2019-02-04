package com.pydyun.ims.service.wxservice;

/**
 * @ClassName: WxUserLevelService 
 * @Description: TODO(积分等级) 
 * @author tangxiaoyu 
 * @date 2018年8月9日 上午9:17:18 
 *
 */
public interface WxUserLevelService
{
    /**
     * @Title: findUserLevelByIntegrals 
     * @Description: TODO(根据积分查询用户等级) 
     * @param integrals
     * @return
     */
    String findUserLevelByIntegrals(Integer integrals);

}
