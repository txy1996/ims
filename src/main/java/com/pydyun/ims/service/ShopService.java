package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopResponse;
import com.pydyun.ims.model.ShopSpare;
import com.pydyun.ims.model.Zone;

public interface ShopService {

	PageInfo<Shop> selectshop(Integer pageNum, Integer pageSize,Integer scid1,Integer bid1,String sname,String scommerce);

	ShopSpare getshop(Integer sid);

	void deleteshop(Integer sid);

	Integer addshop(Shop shop);

	void updateshop(Shop shop);      

	List<String> selectbid();

//	List<String> selectlevel();

	List<Zone> selectzid();

	PageInfo<Shop> getshop(Integer pageNum, Integer pageSize, Integer id);

	List<Shop> findshop();
	
	PageInfo<Shop> selectby(Integer pageNum, Integer pageSize,Integer scid1,Integer bid1,String sname,String stel);
	
	List<Shop> findshop1(Integer sid);
	
	Integer getbid(Integer scid);
	
	Integer getscid(Integer bid);

	Integer getbid1(Integer sid);
	
	String getsname(Integer sid);
	
	   /**
     * @Title: getByShopName 
     * @Description: TODO(方案阶段所需的模糊查询) 
     * @param shop
     * @return
     */
    List<ShopResponse> getByShopName(ShopResponse response);
    
    /**
     * @Title: getByShopId 
     * @Description: TODO(根据id查询商户信息) 
     * @param sid
     * @return
     */
    Shop getByShopId(Integer sid);

	void picture(Shop shop);

	List<Shop> Styleimg(Integer sid);

	List<Shop> shops(String string);

	void deletesp(Integer id);
}
