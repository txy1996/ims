package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxPromotion;

public interface WxPromotionDao {

	List<WxPromotion> activity();

	WxPromotion Top();

	List<WxPromotion> findculture();

	WxPromotion Central();

	WxPromotion bottom();

	WxPromotion training();

	WxPromotion yshop();

	WxPromotion rschema();

	WxPromotion Labour();

}
