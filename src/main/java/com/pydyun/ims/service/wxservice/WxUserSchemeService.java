package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxUserScheme;
import com.pydyun.ims.model.WxUserSchemerListResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserSchemeService
 * @Description: TODO(微信 : 个人中心 - 用户个人方案)
 * @date 2018年8月17日 上午10:24:26
 */
public interface WxUserSchemeService
{

    Integer saveWxUserScheme(WxUserScheme userScheme)throws Exception;

    Integer updateWxUserScheme(WxUserScheme userScheme);

    Integer deleteWxUserScheme(Integer usuid, Integer ussid);

    PageInfo<WxUserSchemerListResponse> findWxUserScheme(Integer pageNum, Integer pageSize, WxUserScheme userScheme);

    WxUserScheme getWxUserScheme(Integer usid);

    Integer getWxUserSchemePresence(Integer usuid, Integer ussid);
}
