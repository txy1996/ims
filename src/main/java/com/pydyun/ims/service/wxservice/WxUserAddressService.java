package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxUserAddress;

/**
 * @ClassName: WxUserAddressService
 * @Description: TODO(微信:用户地址管理)
 * @author tangxiaoyu
 * @date 2018年8月10日 下午3:13:46
 *
 */
public interface WxUserAddressService
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

	void updateuaone(Integer uauid);
}
