package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Promotion;

public interface PromotionService {

	Integer add(Promotion promotion);

	PageInfo<Promotion> selectlist(Integer pageNum, Integer pageSize);

	List<Promotion> modify();

	void updateshop(Promotion promotion);

	Promotion getPromotion(Integer id);

	List<Promotion> edit(Integer id);

	PageInfo<Promotion> polling(Integer pageNum, Integer pageSize,String stadate,String enddate,Integer ptype,String bt);

	void updatepro(Promotion pt);

	void delete(Promotion promotion);
	
	List<Promotion> findShopRecommend(Integer ptype);
	
	Promotion edit1(Integer id);

	List<Promotion> Recommend(Integer id);

	void upRecommend(Promotion pr);

	List<Promotion> inquire(Integer id);

    List<Promotion> findPromotionByPtype(Integer ptype);

	List<Promotion> findpromlist(String psource);


}
