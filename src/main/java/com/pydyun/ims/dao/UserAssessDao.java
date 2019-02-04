package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.UserAssessPageResponse;

/**
 * @ClassName: UserAssessDao 
 * @Description: TODO(用户评论表dao层接口) 
 * @author tangxiaoyu 
 * @date 2018年7月11日 上午9:43:59 
 *
 */
public interface UserAssessDao
{

    /**
     * @Title: select 
     * @Description: TODO(条件分页查询) 
     * @param response
     * @return
     */
    List<UserAssessPageResponse> select(UserAssessPageResponse response);
}
