package com.pydyun.ims.controller.wxcontroller;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pydyun.ims.model.WxImagesPl;
import com.pydyun.ims.model.WxProductClass;
import com.pydyun.ims.model.WxProductRequest;
import com.pydyun.ims.model.WxPromotion;
import com.pydyun.ims.model.WxPromotionRequest;
import com.pydyun.ims.model.WxScheme;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxSys_user;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.service.wxservice.WxProductClassService;
import com.pydyun.ims.service.wxservice.WxPromotionService;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;
import com.pydyun.ims.util.Analysis2;
import com.pydyun.ims.util.Splice;
import com.pydyun.ims.util.WxProgram;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/wxpromotion")
public class WxPromotionController {
	
	@Resource
	private WxPromotionService wps;
	@Resource
	private  WxProductClassService wpc;
	@Resource
	WxUserCollectionService wxUserCollectionService;
	@Resource
	WxUserAssessService wxUserAssessService;
	//一级页面
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	public void promotion(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxProgram.main(request, response);
		ArrayList arr = new ArrayList();
		WxPromotion Top = wps.Top();//index页顶部广告
		String psurce = Top.getPsource();
		Map<String, List<String>> ma = Analysis2.find(psurce);
		for(List<String> li:ma.values()){
			String st = li.get(1); String[] sr = st.split(":");
			WxPromotionRequest request1 = new WxPromotionRequest();
			request1.setImgurl(li.get(0));
			request1.setInfo(null);
			request1.setJumpurl(sr[1]);
			WxProductRequest productfid = wps.productfid(Integer.parseInt(sr[1]));//查询分类id
			request1.setFid(productfid.getCid());
			arr.add(request1);
		}
		WxPromotion rschema  = wps.rschema();//index页中部广告(热门方案)
		String psorce = rschema.getPsource();
		String[] strf = psorce.split(":");
		List<WxScheme> fscheme = wps.fscheme(strf[1]);
		WxPromotion Central  = wps.Central();//index页中部广告(超值分享)
		String psour = Central.getPsource();
		String[] strc = psour.split(":");
		List<WxProductRequest> lbshop = wps.lbshop(strc[1]);
		WxPromotion yshop = wps.yshop();//index页底部广告(优质商家)
		String psource = yshop.getPsource();
		String[] strs = psource.split(":");
		List<WxShop> shopy = wps.shopy(strs[1]);
		WxPromotion bottom = wps.bottom();//index页底部广告(为你推荐)
		String psourc = bottom.getPsource();
		String[] strb = psourc.split(":");
		List<WxProductRequest> wshop = wps.wshop(strb[1]);
	    Map<String, Object> map = new HashMap<>();
        map.put("wshop", wshop);
        map.put("lbshop", lbshop);
        map.put("shopy", shopy);
        map.put("fscheme", fscheme);
        map.put("arr", arr);
	    JSONArray json = JSONArray.fromObject(map);
	    String jsonlist = json.toString();
		Writer wt = response.getWriter();
        wt.write(jsonlist);
        wt.flush();
	}
	
	//商品分类查询
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/industrial")
   public void industrial(HttpServletRequest request,HttpServletResponse response,String ids) throws Exception{
		WxProgram.main(request, response);
		String[] str = ids.split(",");
		List<WxProductRequest> listrestaurant = wps.restaurant(Integer.parseInt(str[0]));//id=1为聚餐轰趴推荐
		List<WxProductRequest> listsang  = wps.listsang(Integer.parseInt(str[1]));//id=14为拓展培训推荐
		List<WxProductRequest> listtravel = wps.listtravel(Integer.parseInt(str[2]));////id=27为出游推荐
		ArrayList arr = new ArrayList();
		WxPromotion Labour = wps.Labour();//团建工会页顶部广告
		String strq = Labour.getPsource();
		Map<String, List<String>> ma = Analysis2.find(strq);
		for(List<String> li:ma.values()){
			String st = li.get(1); String[] sr = st.split(":");
			WxPromotionRequest request1 = new WxPromotionRequest();
				request1.setImgurl(li.get(0));
				request1.setInfo(null);
				request1.setJumpurl(sr[1]);
				WxProductRequest productfid = wps.productfid(Integer.parseInt(sr[1]));//查询分类id
				request1.setFid(productfid.getCid());
				arr.add(request1);
		}
		List<WxProductRequest> huoguo = new ArrayList<>();
		List<WxProductRequest> zhongcan = new ArrayList<>();
		List<WxProductRequest> xishi = new ArrayList<>();
		List<WxProductRequest> hongpa = new ArrayList<>();
		List<WxProductRequest> tzchangdi = new ArrayList<>();
		List<WxProductRequest> tzguwen = new ArrayList<>();
		List<WxProductRequest> tzchanpin = new ArrayList<>();
		List<WxProductRequest> pxchangdi = new ArrayList<>();
		List<WxProductRequest> pxkecheng = new ArrayList<>();
		List<WxProductRequest> pxjiangshi = new ArrayList<>();
		List<WxProductRequest> pxpeitao = new ArrayList<>();
		List<WxProductRequest> pxfangan = new ArrayList<>();
		List<WxProductRequest> dangji = new ArrayList<>();
		List<WxProductRequest> jinjiao = new ArrayList<>();
		List<WxProductRequest> zhuti = new ArrayList<>();
		if(listrestaurant.size()!=0 && listrestaurant!=null){
			for(WxProductRequest wx : listrestaurant){
				if(wx.getCid().equals("2")||wx.getCid()==2){
					huoguo.add(wx);
				}else if(wx.getCid().equals("3")||wx.getCid()==3){
					zhongcan.add(wx);
				}else if(wx.getCid().equals("4")||wx.getCid()==4){
					xishi.add(wx);
				}else if(wx.getCid().equals("5")||wx.getCid()==5){
					hongpa.add(wx);
				}
			}
		}
		if(listsang.size()!=0 && listsang!=null){
			for(WxProductRequest wx : listsang){
				if(wx.getCid().equals("15")||wx.getCid()==15){
					tzchanpin.add(wx);
				}else if(wx.getCid().equals("16")||wx.getCid()==16){
					tzchangdi.add(wx);
				}else if(wx.getCid().equals("17")||wx.getCid()==17){
					tzguwen.add(wx);
				}else if(wx.getCid().equals("18")||wx.getCid()==18){
					pxfangan.add(wx);
				}else if(wx.getCid().equals("19")||wx.getCid()==19){
					pxkecheng.add(wx);
				}else if(wx.getCid().equals("20")||wx.getCid()==20){
					pxjiangshi.add(wx);
				}else if(wx.getCid().equals("21")||wx.getCid()==21){
					pxchangdi.add(wx);
				}else if(wx.getCid().equals("22")||wx.getCid()==22){
					pxpeitao.add(wx);
				}
			}
		}
		if(listtravel.size()!=0 && listtravel!=null){
			for(WxProductRequest wx : listtravel){
				if(wx.getCid().equals("28")||wx.getCid()==28){
					zhuti.add(wx);
				}else if(wx.getCid().equals("29")||wx.getCid()==29){
					dangji.add(wx);
				}else if(wx.getCid().equals("31")||wx.getCid()==31){
					jinjiao.add(wx);
				}
			}
		}
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("huoguo",huoguo );
		map.put("zhongcan",zhongcan );
		map.put("xishi",xishi);
		map.put("hongpa",hongpa);
		
		map.put("tzchangdi",tzchangdi);
		map.put("tzguwen",tzguwen );
		map.put("tzchanpin",tzchanpin );
		
		map.put("pxchangdi",pxchangdi);
		map.put("pxkecheng",pxkecheng);
		map.put("pxjiangshi",pxjiangshi);
		map.put("pxpeitao",pxpeitao );
		map.put("pxfangan",pxfangan );
		
		map.put("zhuti",zhuti);
		map.put("dangji",dangji);
		map.put("jinjiao",jinjiao);
		map.put("arr",arr);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
   }

	//商品列表(如：全身火锅或者中餐)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/shoplist")
	public void shoplist(HttpServletRequest request,HttpServletResponse response,Integer id,String choise,String classs,
			Integer pageNum, Integer pageSize)throws Exception{
		ArrayList shopli = new ArrayList();
		WxProgram.main(request, response);
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 5 : pageSize;
		String str = "";String big = "";String small = "";
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		String ptitle3 = null;
		if(choise.equals("")||choise.equals("请选择")){
			ptitle1 = null;
			ptitle2 = null;
		}else{
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		if(id == 56789){
			str = String.valueOf(id);
			String s = "";
			for (int i = 0; i < str.length(); i++) {
				if(i==str.length()-1){
					s+=str.substring(i,i+1);
					break;
					}else{
					s+=str.substring(i,i+1);
					s+=",";
					}
			}
			PageInfo<WxProductRequest> shoplist = wps.shoplisth(s,pageNum,pageSize);
			big="聚餐轰趴";small="餐后活动";
			shopli.add(shoplist);
		}else{
			
			PageInfo<WxProductRequest> shoplist = wps.shoplist(id, ptitle1,ptitle2,ptitle3,pageNum,pageSize);
			shopli.add(shoplist);
			WxProductClass wxclass = wpc.selectclass(id);
			String bi = wxclass.getCcname();
			String smal = wxclass.getCname();
			big=bi;small=smal;
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("shoplist", shopli);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	
	
	//查询出游列表(如:当季IDEA,近郊短游,出去浪)
	@RequestMapping("/Travel")
	public void Travel(HttpServletRequest request,HttpServletResponse response,Integer id,String choise,
			Integer pageNum, Integer pageSize)throws Exception{
		WxProgram.main(request, response);
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 5 : pageSize;
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if(choise.equals("")||choise.equals("请选择")){
			ptitle1 = null;
			ptitle2 = null;
		}else{
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> Travel = wps.Travel(id,ptitle1,ptitle2,pageNum,pageSize);
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Travel", Travel);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	
	//旅游详情页面
	@RequestMapping("/Traveldetails")
	public void Traveldetails(HttpServletRequest request,HttpServletResponse response,Integer id,Integer uid)throws Exception{
		WxProgram.main(request, response);
		List<String> ls = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxProductRequest> Traveldetails = wps.Traveldetails(id);
		if (wxUserCollectionService.findshou(uid.toString(),id.toString())!= null) {
			Traveldetails.get(0).setCollection(true);
		} else {
			Traveldetails.get(0).setCollection(false);
		}
		List<WxProductRequest> forward = wps.forward(id);  //推荐理由
		if (wxUserAssessService.selectassess(id) != null && wxUserAssessService.selectassess(id).size() != 0) {
			List<WxUser_assess> selectassess = wxUserAssessService.selectassess(id);
			for (WxUser_assess ss : selectassess) {
				WxImagesPl wx = new WxImagesPl();
				// 查找评论的图片，一条评论对应数据库图片表多张图片
				for (int j = 0; j < selectassess.size(); j++) {
					if (selectassess.get(j).getUaid() == ss.getUaid()) {
						List<String> selectassessimg = wxUserAssessService
								.selectassessimg(selectassess.get(j).getUaid());
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < selectassessimg.size(); i++) {
							if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
								sb.append(",");
							}
							sb.append(selectassessimg.get(i));
						}
						wx.setIurl(sb.toString());
						String a = wx.getIurl();
						String[] split = a.split(",");
						ls = Arrays.asList(split);
						for (String LS : ls) {
							LS.replace("http://", "https://");
						}
						ss.setList(ls);
						ss.setWximages_pl(wx);
					}
				}
				if (ss.getUaisanonymous().equals(0) || ss.getUaisanonymous() == 0) {
					WxSys_user us = new WxSys_user();
					us.setUsername("匿名用户");
					us.setHead(ss.getWxsys_user().getHead());
					ss.setWxsys_user(us);
					String ualabels = ss.getUalabels();
					if (ualabels != null) {
						String[] split = ualabels.split(",");
						List<String> asList = Arrays.asList(split);
						set.addAll(asList);
						for (String str : set) {
							lis.add(str);
						} 
					} 
				}
				hashset.add(ss);
			}
		} else {
			WxUser_assess wxa = new WxUser_assess();
			wxa.setUainfo("暂无评论");
			hashset.add(wxa);
		}
		Integer total = wps.total(id);// 查询商品评论总条数
		Integer commentsum = wps.commentsum(id);// 查询评论总分值
		Object sting =  null;
		if(total != 0 && commentsum !=0){
			double result = new BigDecimal((float)commentsum / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			sting = result;
		}else{
			double str = 0;sting = str;
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Traveldetails", Traveldetails);
		map.put("total", total);
		map.put("sting", sting);
		map.put("forward", forward);
		map.put("hashset", hashset);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	
	
	//顾问详情页面
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/adviser")
	public void adviser(HttpServletRequest request,HttpServletResponse response,Integer id,Integer cid,Integer uid)throws Exception{
		WxProgram.main(request, response);
		ArrayList arr = new ArrayList();
		List<String> ls = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		Set<WxUser_assess> hashset = new HashSet<>();
		WxProductRequest adviser = wps.adviser(id);
		List<WxProductRequest> forward = wps.forward(id);  //推荐理由
		// 查询此商品是否被收藏
		if (wxUserCollectionService.findshou(Integer.toString(uid), Integer.toString(id)) != null) {
			 adviser.setCollection(true);
		} else {
			 adviser.setCollection(false);
		}
		Integer ig = adviser.getSid();
		String s = null; 
			String str = adviser.getProperty();
			String st = str.replaceAll("[\\[\\]]", "");
			String[] sto = st.split(":");
			s = sto[1]; 
			arr.add(adviser);
		List<WxProductRequest> adviserId = wps.adviserId(ig,id);//查询此商户对应其他产品
		if (wxUserAssessService.selectassess(id) != null && wxUserAssessService.selectassess(id).size() != 0) {
			List<WxUser_assess> selectassess = wxUserAssessService.selectassess(id);
			for (WxUser_assess ss : selectassess) {
				WxImagesPl wx = new WxImagesPl();
				// 查找评论的图片，一条评论对应数据库图片表多张图片
				for (int j = 0; j < selectassess.size(); j++) {
					if (selectassess.get(j).getUaid() == ss.getUaid()) {
						List<String> selectassessimg = wxUserAssessService
								.selectassessimg(selectassess.get(j).getUaid());
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < selectassessimg.size(); i++) {
							if (sb.length() > 0) {// 该步即不会第一位有逗号，也防止最后一位拼接逗号！
								sb.append(",");
							}
							sb.append(selectassessimg.get(i));
						}
						wx.setIurl(sb.toString());
						String a = wx.getIurl();
						String[] split = a.split(",");
						ls = Arrays.asList(split);
						for (String LS : ls) {
							LS.replace("http://", "https://");
						}
						ss.setList(ls);
						ss.setWximages_pl(wx);
					}
				}
				if (ss.getUaisanonymous().equals(0) || ss.getUaisanonymous() == 0) {
					WxSys_user us = new WxSys_user();
					us.setUsername("匿名用户");
					us.setHead(ss.getWxsys_user().getHead());
					ss.setWxsys_user(us);
					String ualabels = ss.getUalabels();
					if (ualabels != null) {
						String[] split = ualabels.split(",");
						List<String> asList = Arrays.asList(split);
						set.addAll(asList);
						for (String stro : set) {
							lis.add(stro);
						} 
					} 
				}
				hashset.add(ss);
			}
		} else {
			WxUser_assess wxa = new WxUser_assess();
			wxa.setUainfo("暂无评论");
			hashset.add(wxa);
		}
		Integer total = wps.total(id);// 查询商品评论总条数
		Integer commentsum = wps.commentsum(id);// 查询评论总分值
		Object sting =  null;
		if(total != 0 && commentsum !=0){
			double result = new BigDecimal((float)commentsum / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			sting = result;
		}else{
			double stri = 0;sting = stri;
		}
		Map<String,Object> map = new HashMap<String, Object>();
		List<WxProductRequest> Besimilar = wps.Besimilar(id);//查询相似推荐
		map.put("Besimilar", Besimilar);
		map.put("total", total);
		map.put("sting", sting);
		map.put("arr", arr);
		map.put("hashset", hashset);
		map.put("adviserId", adviserId);
		map.put("forward", forward);
		map.put("s", s);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	
	
	@RequestMapping("/returnpath")
	public void returnpath(HttpServletRequest req, HttpServletResponse res, Integer cid,Integer id)
			throws IOException {
		WxProgram.main(req, res);
		String returnPath = Splice.ReturnPath(1, cid, null, id);
//		int indexOf = returnPath.indexOf("?");
//		String substring = returnPath.substring(0, indexOf);
//		returnPath = substring+"?id="+sid;
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(returnPath));
		wt.flush();
	}
}
