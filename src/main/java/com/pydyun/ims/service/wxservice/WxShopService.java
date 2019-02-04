package com.pydyun.ims.service.wxservice;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;

import java.util.List;

public interface WxShopService {

	WxShop selectshop(Integer sid);

	List<WxVoucher> selectv(String vrange);

	List<WxCoupon> selectc(String crange);

	List<WxUser_assess> selectu(Integer sid);

	List<WxShop> selectf(Object[] values);

	List<WxShop> selectype(Double minlat,Double maxlat,Double minlng,Double maxlng,Double Longitude1,Double Latitude1,Integer scid,Integer id);

	List<WxShop> selectype1(Double minlat,Double maxlat,Double minlng,Double maxlng,Double Longitude1,Double Latitude1,Integer scid,Integer sid);
	
	List<WxShopImages> type(Integer sid);

	List<WxPromotion> activity();

	PageInfo<WxShop> findshopproduct(Integer cid,Integer sid, String ptitle1,String ptitle2,Integer pageNum,Integer pageSize);

	List<WxShop> findshopproductbyid(String id);

	List<WxShop> findproduct(String id);
	
	List<WxShop> findproductlist(String spnum,String sduration,String srange,String demand);
	
	WxShop findWxShopBySid(Integer sid);

	List<Label_shop_sum> selectlabel(Integer sid);

	WxShop shoppro(Integer id);
}
