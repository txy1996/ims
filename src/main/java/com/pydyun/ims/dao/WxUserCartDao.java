package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxUserCart;
import com.pydyun.ims.model.WxUserCartResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FileName: WxUserCartDao
 * Author:   tangxiaoyu
 * Date:     2018/8/27 9:24
 * Description: TODO(微信:购物车)
 *
 * @since 1.0.0
 */
public interface WxUserCartDao
{

    Integer saveWxUserCart(WxUserCart wxUserCart);

    Integer updateWxUserCart(WxUserCart wxUserCart);

    Integer updateWxUserCartByUidAllStatus(@Param("uid") Integer uid, @Param("status") Integer status);

    Integer deleteWxUserCart(@Param("list") List<Integer> ids);


    List<WxUserCartResponse> findWxUserCartVoucher(WxUserCart wxUserCart);

    List<WxUserCartResponse> findWxUserCartProduct(WxUserCart wxUserCart);

    WxUserCart getWxUserCart(WxUserCart wxUserCart);


}
