package com.pydyun.ims.service.impl.wximpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.WxProductRequestDao;
import com.pydyun.ims.dao.WxPromotionDao;
import com.pydyun.ims.dao.WxSchemeDao;
import com.pydyun.ims.dao.WxShopDao;
import com.pydyun.ims.dao.WxShopRequestDao;
import com.pydyun.ims.dao.WxShopclassDao;
import com.pydyun.ims.dao.WxUser_assessDao;
import com.pydyun.ims.model.WxProductRequest;
import com.pydyun.ims.model.WxPromotion;
import com.pydyun.ims.model.WxScheme;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.service.wxservice.WxPromotionService;


@Service
public class WxPromotionServiceImpl implements WxPromotionService{

	@Resource
	private WxPromotionDao pdao;
	@Resource
	private WxShopDao wxdao;
	@Resource
    private WxShopclassDao wsl;
	@Resource
	private WxShopRequestDao wdao;
	@Resource 
	private WxProductRequestDao wpdao;
	@Resource
	private WxSchemeDao wsdao;
	@Resource
	private WxUser_assessDao wadao;
	@Resource
	private WxSchemeDao wo;
	@Override
	public WxPromotion Central() {
		return pdao.Central();
	}

	@Override
	public WxPromotion bottom() {
		return pdao.bottom();
	}

	@Override
	public List<WxProductRequest> restaurant(Integer id) {
		return wpdao.restaurant(id);
	}

	@Override
	public List<WxProductRequest> listsang(Integer id1) {
		return wpdao.listsang(id1);
	}

	@Override
	public List<WxProductRequest> listtravel(Integer id2) {
		return wpdao.listtravel(id2);
	}

	//,String timechoise,String naturechoise
	@Override
	public PageInfo<WxProductRequest> shoplist(Integer id,String ptitle1,String ptitle2,String ptitle3,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> shoplist = wpdao.shoplist(id,ptitle1,ptitle2,ptitle3);
		List<WxProductRequest> shoplist1 = new ArrayList<>();
		if(ptitle1!=null && ptitle2!=null){
		for(int i =0;i<shoplist.size();i++){
			if(shoplist.get(i).getPtitle() !=null){
				if(Integer.parseInt(shoplist.get(i).getPtitle())>=Integer.parseInt(ptitle2)){
					shoplist1.add(shoplist.get(i));
				}
			}
		}
		}else{
			return new PageInfo<>(shoplist);
		}
		return new PageInfo<>(shoplist1);
	}

	@Override
	public WxProductRequest adviser(Integer id) {
		return wpdao.adviser(id);
	}

	@Override
	public List<WxProductRequest> adviserId(Integer ig,Integer id) {
		return wpdao.adviserId(ig,id);
	}

	@Override
	public List<WxUser_assess> comment(Integer id) {
		return wadao.comment(id);
	}

	@Override
	public List<WxProductRequest> Besimilar(Integer id) {
		return wpdao.Besimilar(id);
	}
	
	//,String timechoise,String naturechoise
	@Override
	public PageInfo<WxProductRequest> morelecturer(Integer id,String ptitle1,String ptitle2,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> morelecturer = wpdao.morelecturer(id,ptitle1,ptitle2);
		return new PageInfo<>(morelecturer);
	}

	@Override
	public PageInfo<WxProductRequest> morecourse(Integer id,String ptitle1,String ptitle2,String ptitle3,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> morecourse = wpdao.morecourse(id,ptitle1,ptitle2,ptitle3);
		for(int i =0;i<morecourse.size();i++){
			if(ptitle1!=null && ptitle2!=null && morecourse.get(i).getPtitle()!=null){
				if(Integer.parseInt(morecourse.get(i).getPtitle())<Integer.parseInt(ptitle2)){
					morecourse.remove(i);
				}
			}
		}
		return new PageInfo<>(morecourse);
	}

	@Override
	public List<WxProductRequest> specificourse(Integer id) {
		return wpdao.specificourse(id);
	}

	@Override
	public List<WxProductRequest> details(Integer id) {
		return wpdao.details(id);
	}

	@Override
	public PageInfo<WxProductRequest> Moresites(Integer id,String ptitle1,String ptitle2,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> Moresites = wpdao.Moresites(id,ptitle1,ptitle2);
		return new PageInfo<>(Moresites);
	}


	@Override
	public List<WxPromotion> findculture() {
		return pdao.findculture();
	}

	@Override
	public PageInfo<WxProductRequest> Travel(Integer id, String ptitle1,
			String ptitle2,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> Travel = wpdao.Travel(id,ptitle1,ptitle2);
		for(int i =0;i<Travel.size();i++){
			if(ptitle1!=null && ptitle2!=null && Travel.get(i).getPtitle() !=null){
				if(Integer.parseInt(Travel.get(i).getPtitle())<Integer.parseInt(ptitle2)){
					Travel.remove(i);
				}
			}
		}
		return new PageInfo<>(Travel);
	}
	@Override
	public List<WxProductRequest> Traveldetails(Integer id) {
		return wpdao.Traveldetails(id);
	}
	@Override
	public PageInfo<WxProductRequest> shoplisth(String classs,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> shoplisth = wpdao.shoplisth(classs);
		return new PageInfo<>(shoplisth);
	}
	@Override
	public List<WxProductRequest> forward(Integer id) {
		return wpdao.forward(id);
	}
	@Override
	public List<WxProductRequest> teacher(Integer id) {
		return wpdao.teacher(id);
	}
	@Override
	public List<WxProductRequest> productclass(Integer id) {
		return wpdao.productclass(id);
	}
	@Override
	public List<WxProductRequest> XqMatching(Integer id) {
		return wpdao.XqMatching(id);
	}
	@Override
	public List<WxUser_assess> productcomment(Integer id) {
		return wadao.productcomment(id);
	}
	@Override
	public List<WxUser_assess> shopcomment(Integer id) {
		return wadao.shopcomment(id);
	}
	@Override
	public PageInfo<WxProductRequest> schema(Integer id, String ptitle1, String ptitle2,Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> schema = wpdao.schema(id,ptitle1,ptitle2);
		return new PageInfo<>(schema);
	}
	@Override
	public List<WxProductRequest> lbshop(String string) {
		return wpdao.lbshop(string);
	}
	@Override
	public WxPromotion training() {
		return pdao.training();
	}
	@Override
	public WxProductRequest productfid(Integer id) {
		return wpdao.productfid(id);
	}

	@Override
	public WxPromotion Top() {
		return pdao.Top();
	}

	@Override
	public WxPromotion yshop() {
		return pdao.yshop();
	}

	@Override
	public List<WxShop> shopy(String str) {
		return wxdao.shopy(str);
	}

	@Override
	public List<WxProductRequest> wshop(String string) {
		return wpdao.wshop(string);
	}

	@Override
	public WxPromotion rschema() {
		return pdao.rschema();
	}

	@Override
	public List<WxScheme> fscheme(String str) {
		return wo.fscheme(str);
	}

	@Override
	public WxPromotion Labour() {
		return pdao.Labour();
	}

	@Override
	public PageInfo<WxProductRequest> Matching(Integer id, String ptitle1,
			String ptitle2, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<WxProductRequest> Matching = wpdao.Matching(id,ptitle1,ptitle2);
		return new PageInfo<>(Matching);
	}

	@Override
	public Integer total(Integer id) {
		return wadao.total(id);
	}

	@Override
	public Integer commentsum(Integer id) {
		return wadao.commentsum(id);
	}

}