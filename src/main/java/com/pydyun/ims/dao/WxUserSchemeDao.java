package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxUserScheme;
import com.pydyun.ims.model.WxUserSchemerListResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: WxUserSchemeDao
 * @Description: TODO(微信:用户个人方案)
 * @author tangxiaoyu
 * @date 2018年8月17日 上午10:06:55
 *
 */
public interface WxUserSchemeDao
{

    /**
     * @Title: saveWxUserScheme
     * @Description: TODO(新增用户个人方案)
     * @param userScheme
     * @return
     */
    Integer saveWxUserScheme(WxUserScheme userScheme);

    /**
     * @Title: updateWxUserScheme
     * @Description: TODO(修改用户个人方案)
     * @param userScheme
     * @return
     */
    Integer updateWxUserScheme(WxUserScheme userScheme);

    Integer deleteWxUserScheme(@Param("usuid") Integer usuid, @Param("ussid") Integer ussid);

    List<WxUserSchemerListResponse> findWxUserScheme(WxUserScheme userScheme);

    WxUserScheme getWxUserScheme(Integer usid);

    Integer getWxUserSchemePresence(@Param("usuid") Integer usuid,@Param("ussid")Integer ussid);
}
