package com.pydyun.ims.dao;

import com.pydyun.ims.model.UserScheme;

/**
 * @ClassName: UserSchemeDao
 * @Description: TODO(用户自定义方案)
 * @author tangxiaoyu
 * @date 2018年8月10日 上午9:45:06
 *
 */
public interface UserSchemeDao
{

    /**
     * @Title: saveUserScheme
     * @Description: TODO(新增用户自定义方案)
     * @param userScheme
     * @return
     */
    Integer saveUserScheme(UserScheme userScheme);
}
