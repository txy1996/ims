package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxShop;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxShopDao {

    WxShop selectshop(Integer sid);

    List<WxShop> selectf(Object[] values);

    List<WxShop> selectype(@Param("minlat")Double minlat,@Param("maxlat")Double maxlat,@Param("minlng")Double minlng,
    		@Param("maxlng")Double maxlng,@Param("Longitude1")Double Longitude1,@Param("Latitude1")Double Latitude1,@Param("scid")Integer scid,@Param("id")Integer id);

    List<WxShop> selectype1(@Param("minlat")Double minlat,@Param("maxlat")Double maxlat,@Param("minlng")Double minlng,
    		@Param("maxlng")Double maxlng,@Param("Longitude1")Double Longitude1,@Param("Latitude1")Double Latitude1,@Param("scid")Integer scid,@Param("sid")Integer sid);
   
    List<WxShop> findshopproduct(@Param("cid") Integer cid, @Param("sid") Integer sid, @Param("ptitle1") String ptitle1,@Param("ptitle2") String ptitle2);

    List<WxShop> findshopproductbyid(@Param("id") String id);

    List<WxShop> findproduct(@Param("id") String id);

    List<WxShop> findproductlist(@Param("spnum") String spnum, @Param("sduration") String sduration,
                                 @Param("srange") String srange, @Param("cid") String cid);

    WxShop findWxShopBySid(@Param("sid") Integer sid);

	List<WxShop> shopy(String str);

	WxShop shoppro(Integer id);


}
