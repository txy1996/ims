package com.pydyun.ims.service.wxservice;


import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxUserCollection;
import com.pydyun.ims.model.WxUserCollectionProductResponse;
import com.pydyun.ims.model.WxUserCollectionShopResponse;

/**
 * @ClassName: WxUserCollectionService 
 * @Description: TODO(微信:个人中心-我的收藏) 
 * @author tangxiaoyu 
 * @date 2018年8月9日 下午2:06:43 
 *
 */
public interface WxUserCollectionService
{

    /**
     * @Title: findUserCollectionByShop 
     * @Description: TODO(查询收藏的商户) 
     * @param urid
     * @return
     */
    PageInfo<WxUserCollectionShopResponse> findUserCollectionByShop(Integer pageNum, Integer pageSize,Integer urid);

    /**
     * @Title: findUserCollectionByProduct 
     * @Description: TODO(查询收藏的商品) 
     * @param urid
     * @return
     */
    PageInfo<WxUserCollectionProductResponse> findUserCollectionByProduct(Integer pageNum, Integer pageSize,Integer urid);
    
    WxUserCollection findshou(String uid,String pid);

	Integer insert(WxUserCollection wx);

	Integer delete(Integer ucid);

	WxUserCollection scshop(Integer sid, Integer uid);

	Integer Scshop(WxUserCollection wx);

	Integer Qxshop(Integer ucid); 
}
