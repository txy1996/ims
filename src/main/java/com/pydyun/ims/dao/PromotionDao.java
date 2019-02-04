package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Promotion;

public interface PromotionDao {

	void add(Promotion promotion);

	List<Promotion> select();

	List<Promotion> modify();

	void update(Promotion promotion);

	Promotion getPromotion(Integer id);

	List<Promotion> edit(Integer id);

	List<Promotion> polling(@Param("stadate")String stadate,@Param("enddate")String enddate,@Param("ptype")Integer ptype,@Param("bt")String bt);

	void updatepro(Promotion pt);

	void delete(Promotion promotion);

	List<Promotion> Recommend(Integer id);

	void upRecommend(Promotion pr);

	List<Promotion> inquire(Integer id);
	
	List<Promotion> findShopRecommend(Integer ptype);
	
	Promotion edit1(Integer id);


    List<Promotion> findPromotionByPtype(Integer ptype);


	List<Promotion> findpromlist(String psource);

}
