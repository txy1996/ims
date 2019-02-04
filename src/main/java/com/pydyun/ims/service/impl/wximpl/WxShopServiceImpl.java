package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.WxCouponDao;
import com.pydyun.ims.dao.WxLabel_shop_sumDao;
import com.pydyun.ims.dao.WxPromotionDao;
import com.pydyun.ims.dao.WxShopDao;
import com.pydyun.ims.dao.WxShopImagesDao;
import com.pydyun.ims.dao.WxUser_assessDao;
import com.pydyun.ims.dao.WxVoucherDao;
import com.pydyun.ims.model.Label_shop_sum;
import com.pydyun.ims.model.WxCoupon;
import com.pydyun.ims.model.WxPromotion;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxShopImages;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.model.WxVoucher;
import com.pydyun.ims.service.wxservice.WxShopService;
@Service
public class WxShopServiceImpl implements WxShopService{

	@Resource
	private WxShopDao wxdao;
	@Resource
	private WxVoucherDao vdao;
	@Resource
	private WxCouponDao cdao;
	@Resource
	private WxUser_assessDao udao;
	@Resource
	private WxShopImagesDao idao;
	@Resource
	private WxPromotionDao pdao;
	@Resource
	private WxLabel_shop_sumDao lsdao;
	@Override
	public WxShop selectshop(Integer sid) {
		WxShop list = wxdao.selectshop(sid);
		return list;
	}

	public List<WxVoucher> selectv(String vrange) {
		return vdao.selectv(vrange);
	}

	public List<WxCoupon> selectc(String crange) {
		return cdao.selectcc(crange);
	}

	@Override
	public List<WxUser_assess> selectu(Integer sid) {
		return udao.selectu(sid);
	}

	@Override
	public List<WxShop> selectf(Object[] values) {
		return wxdao.selectf(values);
	}

	@Override
	public List<WxShop> selectype(Double minlat,Double maxlat,Double minlng,Double maxlng,Double Longitude1,Double Latitude1,Integer scid,Integer id) {
		return wxdao.selectype(minlat,maxlat,minlng,maxlng,Longitude1,Latitude1,scid,id);
	}
	
	@Override
	public List<WxShop> selectype1(Double minlat,Double maxlat,Double minlng,Double maxlng,Double Longitude1,Double Latitude1,Integer scid,Integer sid) {
		return wxdao.selectype(minlat,maxlat,minlng,maxlng,Longitude1,Latitude1,scid,sid);
	}
	/*@Override
	public List<WxShop> selectmore() {
		return wxdao.selectmore();
	}*/

	@Override
	public List<WxShopImages> type(Integer sid) {
//		return wxdao.type(sid);
		return idao.type(sid);
	}

	@Override
	public List<WxPromotion> activity() {
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String time = sdf.format(date);
//		System.out.println(time);
//		List<WxPromotion> list = pdao.activity(time);
		return pdao.activity();	
	}

	@Override
	public PageInfo<WxShop> findshopproduct(Integer cid,Integer sid,String ptitle1,String ptitle2,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<WxShop> findshopproduct = wxdao.findshopproduct(cid,sid,ptitle1,ptitle2);
		return new PageInfo<>(findshopproduct);
	}

	@Override
	public List<WxShop> findshopproductbyid(String id) {
		// TODO Auto-generated method stub
		return wxdao.findshopproductbyid(id);
	}

	@Override
	public List<WxShop> findproduct(String id) {
		// TODO Auto-generated method stub
		return wxdao.findproduct(id);
	}

	@Override
	public List<WxShop> findproductlist(String spnum, String sduration, String srange, String demand) {
		// TODO Auto-generated method stub
		return wxdao.findproductlist(spnum, sduration, srange, demand);
	}

	@Override
	public WxShop findWxShopBySid(Integer sid) {
		// TODO Auto-generated method stub
		return wxdao.findWxShopBySid(sid);
	}

	@Override
	public List<Label_shop_sum> selectlabel(Integer sid) {
		return lsdao.selectlabel(sid);
	}

	@Override
	public WxShop shoppro(Integer id) {
		return wxdao.shoppro(id);
	}

	


}
