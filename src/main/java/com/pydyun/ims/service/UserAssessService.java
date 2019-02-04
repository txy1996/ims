package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.UserAssessPageResponse;

/**
 * @ClassName: UserAssessService 
 * @Description: TODO(用户评论表service接口) 
 * @author tangxiaoyu 
 * @date 2018年7月11日 上午11:24:24 
 *
 */
public interface UserAssessService
{

    /**
     * @Title: select 
     * @Description: TODO(条件分页查询) 
     * @param pageNum
     * @param pageSize
     * @param response
     * @return
     */
    PageInfo<UserAssessPageResponse> select(Integer pageNum, Integer pageSize,UserAssessPageResponse response);
}
