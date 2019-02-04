package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxUserAddress;

/**
 * @ClassName: WxUserAddressDao
 * @Description: TODO(微信:地址管理)
 * @author tangxiaoyu
 * @date 2018年8月10日 上午11:45:20
 *
 */
public interface WxUserAddressDao
{

    /**
     * @Title: saveWxUserAddress
     * @Description: TODO(新增用户地址)
     * @param address
     * @return
     */
    Integer saveWxUserAddress(WxUserAddress address);

    /**
     * @Title: updateWxUserAddress
     * @Description: TODO(修改用户地址)
     * @param address
     * @return
     */
    Integer updateWxUserAddress(WxUserAddress address);

    /**
     * @Title: deleteWxUserAddress
     * @Description: TODO(删除用户地址)
     * @param uaid
     * @return
     */
    Integer deleteWxUserAddress(Integer uaid);

    /**
     * @Title: findWxUserAddress
     * @Description: TODO(查询用户地址)
     * @param address
     * @return
     */
    List<WxUserAddress> findWxUserAddress(WxUserAddress address);

    WxUserAddress getWxUserDefaultAddress(WxUserAddress address);

	void updateuaone(@Param("uauid")Integer uauid);
}
