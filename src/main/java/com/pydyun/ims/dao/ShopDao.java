package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopResponse;
import com.pydyun.ims.model.ShopSpare;
import com.pydyun.ims.model.Zone;

public interface ShopDao {

	List<Shop> selectshop(@Param("scid")Integer scid,@Param("bid")Integer bid,@Param("sname")String sname,@Param("scommerce")String scommerce);

	ShopSpare getshop(Integer sid);

	void add(Shop shop);

	void updateshop(Shop shop);

	void delete(Integer sid);

	List<String> selectbid();

//	List<String> selectlevel();
	
	List<String> getSname();

	List<Zone> selectzid();

	List<Shop> getshopsta(Integer id);
	
	List<Shop> findshop();
	
	List<Shop> selectby(@Param("scid")Integer scid,@Param("bid")Integer bid,@Param("sname")String sname,@Param("stel")String stel);
	
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
