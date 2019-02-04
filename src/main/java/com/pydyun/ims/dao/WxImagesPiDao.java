package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxImagesPi;

/**
 * FileName: WxImagesPiDao
 * Author:   tangxiaoyu
 * Date:     2018/8/31 18:04
 * Description: TODO(微信:评论图片表)
 *
 * @since 1.0.0
 */
public interface WxImagesPiDao
{
     /**
       * @Description: TODO(新增用户评论图片)
       * @param:
       * @return:
       * @Date: 2018/8/31 18:10
      */

    Integer saveWxImagesPi(WxImagesPi wxImagesPi);
}
