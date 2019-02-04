package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxCoupon;
import com.pydyun.ims.model.WxCouponResponse;

public interface WxCouponDao
{

    List<WxCoupon> selectcc(String crange);

    /**
     * @Title: findCouponByUrid 
     * @Description: TODO(根据用户id查询优惠券,有效) 
     * @param urid
     * @return
     */
    List<WxCouponResponse> findCouponByUrid(Integer urid);

    /**
     * @Title: findCouponInvalidByUrid 
     * @Description: TODO(根据用户id查询优惠券,无效) 
     * @param urid
     * @return
     */
    List<WxCouponResponse> findCouponInvalidByUrid(Integer urid);

    /*统计有效优惠券*/
    Integer getCouponCountByUrid(Integer urid);

}
