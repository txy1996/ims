package com.pydyun.ims.service.wxservice;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxUserCart;
import com.pydyun.ims.model.WxUserCartResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FileName: WxUserCartService
 * Author:   tangxiaoyu
 * Date:     2018/8/27 9:29
 * Description: TODO(微信:购物车)
 *
 * @since 1.0.0
 */
public interface WxUserCartService
{

    WxUserCart saveWxUserCart(WxUserCart wxUserCart)throws  Exception;

    Integer updateWxUserCart(WxUserCart wxUserCart);

    Integer updateWxUserCartByUidAllStatus(Integer uid, Integer status);

    Integer deleteWxUserCart(List<Integer> ids);

    PageInfo<WxUserCartResponse> findWxUserCart(Integer pageNum, Integer pageSize, WxUserCart wxUserCart);


}
