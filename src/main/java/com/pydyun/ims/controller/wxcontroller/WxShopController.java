package com.pydyun.ims.controller.wxcontroller;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pydyun.ims.model.Label_shop_sum;
import com.pydyun.ims.model.WxCoupon;
import com.pydyun.ims.model.WxProduct;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxSys_user;
import com.pydyun.ims.model.WxUserCollection;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.model.WxVoucher;
import com.pydyun.ims.service.wxservice.WxAlbumService;
import com.pydyun.ims.service.wxservice.WxImagesService;
import com.pydyun.ims.service.wxservice.WxProductService;
import com.pydyun.ims.service.wxservice.WxShopService;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;
import com.pydyun.ims.util.WxProgram;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/wxshop")
public class WxShopController {

	@Resource
	private WxShopService wxshop;
	@Resource
	private WxAlbumService wxablum;
	@Resource
	private WxImagesService wxImagesService;
	@Resource
	private WxProductService wxpro;
	@Resource
	private WxUserCollectionService wxUserCollectionService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/shop")
	public void WxShop(HttpServletRequest request, HttpServletResponse response, Integer sid,Integer uid) throws Exception {
		WxShopController.main(request, response);
		WxShop list = wxshop.selectshop(sid); // 查询商户信息
		//收藏商户
		if (wxUserCollectionService.scshop(sid,uid)!= null) {
			list.setCollection(true);
		} else {
			list.setCollection(false);
		}
		List<Label_shop_sum> label = wxshop.selectlabel(sid); // 查询商户标签
		List<WxProduct> product = wxpro.selectproduct(sid); // 查询本商户的其他商品
		ArrayList a = new ArrayList();
		String scoordinate = list.getScoordinate();
		String styleimg = list.getStyleimg();
		// getfjshop(Double.parseDouble(Longitude),Double.parseDouble(Latitude));
		if(styleimg != null){
			styleimg = list.getStyleimg();
			String[] split = styleimg.split(",");
//			List<String> ids = Arrays.asList(split);
//			list.setImages(wxImagesService.findimg(ids)); //商户前台展示图片
			list.setImages(wxImagesService.findimg(Integer.parseInt(split[0]))); //商户前台展示背景图片
		} 
//		List<WxShop> listf = new ArrayList<>(); // 推荐周边1公里的特色餐饮
		List<WxShop> listtype = new ArrayList<>(); // 附近1公里同类型商户推荐
		if(!scoordinate.equals("")){
			Integer scid = list.getScid();
			String[] temp;
			temp = scoordinate.split(",");
			String Longitude = temp[0];// 经度
			String Latitude = temp[1];// 伟度
			a.add(Double.parseDouble(Longitude));
			a.add(Double.parseDouble(Latitude));
			// 推荐周边1公里的特色餐饮 和 附近1公里同类型商户推荐
			Double Longitude1 = (Double) a.get(0);
			Double Latitude1 = (Double) a.get(1);
			double r = 6371;// 地球半径千米
			double dis = 1;// 1千米距离
			Double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(Latitude1 * Math.PI / 180));
			dlng = dlng * 180 / Math.PI;// 角度转为弧度
			Double dlat = dis / r;
			dlat = dlat * 180 / Math.PI;
			Double minlat = Latitude1 - dlat; // 最小纬度
			Double maxlat = Latitude1 + dlat; // 最大纬度
			Double minlng = Longitude1 - dlng; // 最大经度
			Double maxlng = Longitude1 + dlng; // 最小经度
//			Object[] values = { minlng, maxlng, minlat, maxlat, Longitude1, Latitude };
//			listf = wxshop.selectf(values);
			listtype = wxshop.selectype(minlat,maxlat,minlng,maxlng,Longitude1,Latitude1,scid,sid);
		}
		String vrange = "s:" + sid;
		List<WxVoucher> listv = wxshop.selectv(vrange); // 查询代金券
		for (WxVoucher wx : listv) {
			String data = wx.getVodate();
			String data1 = wx.getVsdate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String newdata = sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data));// 你要转化的日期
			String newdata1 = sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data1));// 你要转化的日期
			wx.setVodate(newdata);
			wx.setVsdate(newdata1);
		}
		String crange = "s:" + sid;
		List<WxCoupon> listc = wxshop.selectc(crange); // 查询优惠券
		for (WxCoupon wc : listc) {
			String data = wc.getCodate();
			String data1 = wc.getCsdate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			String newdata = sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data));// 你要转化的日期
			String newdata1 = sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data1));// 你要转化的日期
			wc.setCodate(newdata);
			wc.setCsdate(newdata1);
			wc.setListv(listv);
		}
		List<WxUser_assess> listu = wxshop.selectu(sid); // 查询用户评论
		if(listu.size()!=0 && listu!=null){
			for (WxUser_assess wx : listu) {
				if(wx.getUaisanonymous() == 0){
					WxSys_user sys = wx.getWxsys_user();
					sys.setUsername("匿名用户");
				}
			}
		}else{
			WxUser_assess wxa = new WxUser_assess();
			wxa.setUainfo("暂无评论");
			listu.add(wxa);
		}		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("label", label);
		map.put("listc", listc);
		map.put("listu", listu);
		map.put("product", product);
//		map.put("listf", listf);
		map.put("listtype", listtype);
		JSONArray jsonlist = JSONArray.fromObject(map);
		String json = jsonlist.toString();
		Writer wt = response.getWriter();
		wt.write(json);
		wt.flush();
	}
    //商品类型的商户
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/shoppro")
	public void shoppro(HttpServletRequest request,HttpServletResponse response,Integer id,Integer uid)throws Exception{
		WxProgram.main(request, response);
		WxShop shoppro = wxshop.shoppro(id);
		Integer sid = shoppro.getSid();
		String scoordinate = shoppro.getScoordinate();
		List<Label_shop_sum> label = wxshop.selectlabel(sid); // 查询商户标签
		List<WxShop> listtype = new ArrayList<>(); // 附近1公里同类型商户推荐
		ArrayList a = new ArrayList();
		if(!scoordinate.equals("")){
			Integer scid = shoppro.getScid();
			String[] temp;
			temp = scoordinate.split(",");
			String Longitude = temp[0];// 经度
			String Latitude = temp[1];// 伟度
			a.add(Double.parseDouble(Longitude));
			a.add(Double.parseDouble(Latitude));
			// 推荐周边1公里的特色餐饮 和 附近1公里同类型商户推荐
			Double Longitude1 = (Double) a.get(0);
			Double Latitude1 = (Double) a.get(1);
			double r = 6371;// 地球半径千米
			double dis = 1;// 1千米距离
			Double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(Latitude1 * Math.PI / 180));
			dlng = dlng * 180 / Math.PI;// 角度转为弧度
			Double dlat = dis / r;
			dlat = dlat * 180 / Math.PI;
			Double minlat = Latitude1 - dlat; // 最小纬度
			Double maxlat = Latitude1 + dlat; // 最大纬度
			Double minlng = Longitude1 - dlng; // 最小经度
			Double maxlng = Longitude1 + dlng; // 最大经度
//			Object[] values = { minlng, maxlng, minlat, maxlat, Longitude1, Latitude };
			listtype = wxshop.selectype1(minlat,maxlat,minlng,maxlng,Longitude1, Latitude1,scid,sid);
		}
		if(shoppro.getStyleimg() != null){
			String styleim = shoppro.getStyleimg();
			String[] split = styleim.split(",");
			shoppro.setImages(wxImagesService.findimg(Integer.parseInt(split[0]))); //商户前台展示背景图片
		}
		WxUserCollection uc = wxUserCollectionService.scshop(sid,uid);
		if (uc != null) {
			shoppro.setCollection(true);
		} else {
			shoppro.setCollection(false);
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("shoppro", shoppro);
		map.put("label", label);
		map.put("listtype", listtype);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	// 推荐周边1公里的特色餐饮 和 附近1公里同类型商户推荐
	public Map<String, Object> getfjshop(double longitude, double latitude) {
		// 先计算查询点的经纬度范围
		double r = 6371;// 地球半径千米
		double dis = 1;// 1千米距离
		Double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(latitude * Math.PI / 180));
		dlng = dlng * 180 / Math.PI;// 角度转为弧度
		Double dlat = dis / r;
		dlat = dlat * 180 / Math.PI;
		Double minlat = latitude - dlat; // 最小纬度
		Double maxlat = latitude + dlat; // 最大纬度
		Double minlng = longitude - dlng; // 最小经度
		Double maxlng = longitude + dlng; // 最大经度
		Object[] values = { minlng, maxlng, minlat, maxlat, longitude, latitude };
		List<WxShop> listf = wxshop.selectf(values); // 推荐周边1公里的特色餐饮
//		List<WxShop> listtype = wxshop.selectype(values); // 附近1公里同类型商户推荐
		Map<String, Object> map = new HashMap<>();
		map.put("listf", listf);
//		map.put("listtype", listtype);
		return map;
	}

	public static void main(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		// 设置响应头允许ajax跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		// 星号表示所有的异域请求都可以接受，
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}
}
