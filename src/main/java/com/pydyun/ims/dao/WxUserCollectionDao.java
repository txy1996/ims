package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxUserCollection;
import com.pydyun.ims.model.WxUserCollectionProductResponse;
import com.pydyun.ims.model.WxUserCollectionShopResponse;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserCollectionDao
 * @Description: TODO(微信 : 个人中心 - 我的收藏)
 * @date 2018年8月9日 上午10:29:47
 */
public interface WxUserCollectionDao
{

    /**
     * @param urid
     * @return
     * @Title: findUserCollectionByShop
     * @Description: TODO(查询收藏的商户)
     */
    List<WxUserCollectionShopResponse> findUserCollectionByShop(Integer urid);


    List<WxUserCollectionProductResponse> findUserCollectionByProduct(@Param("urid") Integer urid);

    WxUserCollection findshou(@Param("urid")String urid,@Param("oid")String oid);


	Integer insert(WxUserCollection WxUserCollection);


	Integer delete(@Param("ucid")Integer ucid);


	WxUserCollection scshop(@Param("sid")Integer sid, @Param("uid")Integer uid);


	Integer Scshop(WxUserCollection wx);


	Integer Qxshop(Integer ucid);
    
}
