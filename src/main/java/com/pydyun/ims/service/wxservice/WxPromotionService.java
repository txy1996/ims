package com.pydyun.ims.service.wxservice;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.*;

import java.util.List;

public interface WxPromotionService {

	WxPromotion Top();

	List<WxProductRequest> restaurant(Integer id);

	List<WxProductRequest> listsang(Integer id1);

	List<WxProductRequest> listtravel(Integer id2);

	PageInfo<WxProductRequest> shoplist(Integer id,String ptitle1,String ptitle2,String ptitle3,Integer pageNum, Integer pageSize);

	WxProductRequest adviser(Integer id);

	List<WxProductRequest> adviserId(Integer ig,Integer id);

	List<WxUser_assess> comment(Integer id);

	List<WxProductRequest> Besimilar(Integer id);

	PageInfo<WxProductRequest> morelecturer(Integer id, String ptitle1,String ptitle2,Integer pageNum, Integer pageSize);

	PageInfo<WxProductRequest> morecourse(Integer id, String ptitle1,String ptitle2,String ptitle3,Integer pageNum, Integer pageSize);

	List<WxProductRequest> specificourse(Integer id);

	List<WxProductRequest> details(Integer id);

	PageInfo<WxProductRequest> Moresites(Integer id, String ptitle1,String ptitle2,Integer pageNum,Integer pageSize);

	List<WxPromotion> findculture();

	WxPromotion Central();

	WxPromotion bottom();

	List<WxProductRequest> Traveldetails(Integer id);

	PageInfo<WxProductRequest> shoplisth(String classs,Integer pageNum, Integer pageSize);

	List<WxProductRequest> forward(Integer id);

	List<WxProductRequest> teacher(Integer id);

	PageInfo<WxProductRequest> Travel(Integer id, String ptitle1, String ptitle2,Integer pageNum, Integer pageSize);

	List<WxProductRequest> productclass(Integer id);

	List<WxProductRequest> XqMatching(Integer id);

	List<WxUser_assess> productcomment(Integer id);

	List<WxUser_assess> shopcomment(Integer id);

	PageInfo<WxProductRequest> schema(Integer id, String ptitle1, String ptitle2,Integer pageNum, Integer pageSize);

	List<WxProductRequest> lbshop(String string);

	WxPromotion training();

	WxProductRequest productfid(Integer id);

	WxPromotion yshop();

	List<WxShop> shopy(String str);

	List<WxProductRequest> wshop(String string);

	WxPromotion rschema();

	List<WxScheme> fscheme(String str);

	WxPromotion Labour();

	PageInfo<WxProductRequest> Matching(Integer id, String ptitle1,
			String ptitle2, Integer pageNum, Integer pageSize);

	Integer total(Integer id);

	Integer commentsum(Integer id);




}
