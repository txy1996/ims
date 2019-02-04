package com.pydyun.ims.controller.wxcontroller;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.model.WxImagesPl;
import com.pydyun.ims.model.WxLabel;
import com.pydyun.ims.model.WxProduct;
import com.pydyun.ims.model.WxProductClass;
import com.pydyun.ims.model.WxProductimg;
import com.pydyun.ims.model.WxPromotion;
import com.pydyun.ims.model.WxPromotionRequest;
import com.pydyun.ims.model.WxShop;
import com.pydyun.ims.model.WxSys_user;
import com.pydyun.ims.model.WxUserCollection;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.service.Scheme_classService;
import com.pydyun.ims.service.wxservice.WxLabelService;
import com.pydyun.ims.service.wxservice.WxProductClassService;
import com.pydyun.ims.service.wxservice.WxProductService;
import com.pydyun.ims.service.wxservice.WxProductimgService;
import com.pydyun.ims.service.wxservice.WxPromotionService;
import com.pydyun.ims.service.wxservice.WxSchemeService;
import com.pydyun.ims.service.wxservice.WxShopService;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;
import com.pydyun.ims.util.Analysis2;
import com.pydyun.ims.util.Splice;
import com.pydyun.ims.util.WxProgram;

/**
 * 此类是文化福利这一大模块的所有方法
 *
 * @author fy
 */
@Controller
@RequestMapping("/wxproduct")
public class WxProductController {

	@Resource
	private WxPromotionService wps;
	@Resource
	WxProductService wxProductService;
	@Resource
	WxProductClassService wxProductClassService;
	@Resource
	WxProductimgService wxProductimgService;
	@Resource
	WxShopService wxShopService;
	@Resource
	WxUserAssessService wxUserAssessService;
	@Resource
	WxLabelService wxLabelService;
	@Resource
	WxSchemeService wxSchemeService;
	@Resource
	Scheme_classService scheme_classService;
	@Resource
	WxPromotionService wxPromotionService;
	@Resource
	WxUserCollectionService wxUserCollectionService;

	/**
	 * 填充广告位 顶部广告可能是商品详情，商户详情，方案详情，方案列表 其余广告位只能是商品详情或者商品列表
	 * 
	 * @param req
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping("/findpromotion")
	public void findpromotion(HttpServletRequest req, HttpServletResponse res) throws IOException {
		WxProgram.main(req, res);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		List<WxPromotion> list = wxPromotionService.findculture();
		List<WxPromotionRequest> list1 = new ArrayList<>();
		List<WxPromotionRequest> list2 = new ArrayList<>();
		List<WxPromotionRequest> list3 = new ArrayList<>();
		List<WxPromotionRequest> list4 = new ArrayList<>();
		List<WxPromotionRequest> list6 = new ArrayList<>();
		List<WxPromotionRequest> list7 = new ArrayList<>();
		List<WxPromotionRequest> list8 = new ArrayList<>();
		List<WxPromotionRequest> list9 = new ArrayList<>();// 第二栏节日特约
		List<WxPromotionRequest> list10 = new ArrayList<>();// 第三栏工作日常
		List<WxPromotionRequest> list11 = new ArrayList<>();// 第四栏人文关怀
		List<WxPromotionRequest> list12 = new ArrayList<>();// 文字1工作日常（茶点）
		List<WxPromotionRequest> list13 = new ArrayList<>();// 文字2人文关怀（暂无null）
		List<WxPromotionRequest> list14 = new ArrayList<>();// 文字3节日福利
		Map<String, Object> map = new HashMap<>();
		for (WxPromotion li : list) {
			Map<String, List<String>> find = Analysis2.find(li.getPsource());
			if (find.size() > 1) {
				for (List<String> lis : find.values()) {
					if (lis.size() == 2) {
						WxPromotionRequest request1 = new WxPromotionRequest();
						request1.setImgurl(lis.get(0));
						request1.setInfo(null);
						request1.setJumpurl(lis.get(1));
						list1.add(request1);
					} else if (lis.size() == 3) {
						WxPromotionRequest request3 = new WxPromotionRequest();
						request3.setImgurl(lis.get(0));
						request3.setInfo(lis.get(1));
						request3.setJumpurl(lis.get(2));
						list1.add(request3);
					}
				}
			} else {
				List<String> list5 = find.get("list0");
				if (list5.size() == 1) {
					WxPromotionRequest request4 = new WxPromotionRequest();
					request4.setImgurl(null);
					request4.setInfo(null);
					request4.setJumpurl(list5.get(0));
					list1.add(request4);
				} else if (list5.size() == 2) {
					WxPromotionRequest request5 = new WxPromotionRequest();
					request5.setImgurl(null);
					request5.setInfo(list5.get(0));
					request5.setJumpurl(list5.get(1));
					list1.add(request5);
				}
			}
		}
		list2.add(list1.get(0));
		list2.add(list1.get(1));
		list2.add(list1.get(2));
		// 遍历顶部广告
		for (WxPromotionRequest wx : list2) {
			String[] split = wx.getJumpurl().split(":");
			if (split[0] == "LP" || split[0].equals("LP")) {
				String returnPath = Splice.ReturnPath(0, Integer.parseInt(split[1]), null, null);
				wx.setJumpurl(returnPath);
			} else if (split[0] == "P" || split[0].equals("P")) {
				Integer findproid = wxProductService.findproid(Integer.parseInt(split[1]));
				String returnPath = Splice.ReturnPath(1, findproid, null, Integer.parseInt(split[1]));
				wx.setJumpurl(returnPath);
				List<WxProductimg> findimg = wxProductimgService.findimg(split[1]);
				wx.setImgurl(findimg.get(0).getUrl());
			} else if (split[0] == "S" || split[0].equals("S")) {
				wx.setJumpurl("../details-1/details-1?id=" + split[1]);
			} else if (split[0] == "F" || split[0].equals("F")) {
				wx.setJumpurl("../programme/programme?id=" + split[1]);
			} else if (split[0] == "LF" || split[0].equals("LF")) {
				wx.setJumpurl("../train/train?id=" + split[1]);
			}
			list4.add(wx);
		}
		// 遍历第二三四栏，必须是P:...为具体的商品
		list3.add(list1.get(3));
		list3.add(list1.get(4));
		list3.add(list1.get(5));
		list3.add(list1.get(6));
		list3.add(list1.get(7));
		for (WxPromotionRequest wx : list3) {
			String[] split = wx.getJumpurl().split(":");
			String[] split2 = split[1].split(",");
			List<String> asList = Arrays.asList(split2);
			List<WxProduct> findbyids1 = wxProductService.findbyids1(asList);
			for (WxProduct fi : findbyids1) {
				WxPromotionRequest request6 = new WxPromotionRequest();
				Integer findproid = wxProductService.findproid(fi.getId());
				String returnPath = Splice.ReturnPath(1, findproid, null, fi.getId());
				request6.setInfo(fi.getPname());
				request6.setImgurl(fi.getProimg().getUrl());
				request6.setJumpurl(returnPath);
				list7.add(request6);
			}
		}
		list6.add(list1.get(8));
		list6.add(list1.get(9));
		list6.add(list1.get(10));
		// 遍历文字
		for (WxPromotionRequest wx : list6) {
			String[] split = wx.getJumpurl().split(":");
			if (split[0] == "LP" || split[0].equals("LP")) {
				String returnPath = Splice.ReturnPath(0, Integer.parseInt(split[1]), null, null);
				wx.setJumpurl(returnPath);
			}
			list8.add(wx);
		}
		list9.add(list7.get(0));
		list9.add(list7.get(1));
		list9.add(list7.get(2));
		list10.add(list7.get(3));
		list10.add(list7.get(4));
		list10.add(list7.get(5));
		list10.add(list7.get(6));
		list11.add(list7.get(7));
		list11.add(list7.get(8));
		list11.add(list7.get(9));
		list11.add(list7.get(10));
		list12.add(list8.get(0));
		list13.add(list8.get(1));
		list14.add(list8.get(2));
		map.put("dingbu", list4);
		map.put("dierlan", list9);
		map.put("disanlan", list10);
		map.put("disilan", list11);
		map.put("wenzi1", list12);
		map.put("wenzi2", list13);
		map.put("wenzi3", list14);
		String json1 = gson.toJson(map);
		wt.write(json1.toString());
		wt.flush();
	}

	/**
	 * 此方法用于显示列表
	 *
	 * @param req
	 * @param res
	 * @param cid
	 *            商品分类id
	 * @param choise
	 *            下面三个都为商品的属性，可以为空
	 * @param timechoise
	 * @param naturechoise
	 * @throws IOException
	 */
	@RequestMapping("/findshop")
	public void findshop(HttpServletRequest req, HttpServletResponse res, Integer cid, String choise,Integer pageNum, Integer pageSize)
			throws IOException {
		WxProgram.main(req, res);
		pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 6 : pageSize;
		Map<String, Object> map = new HashMap<>();
		// choise 是筛选时特定传过来的参数
		// choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if (choise.equals("") || choise.equals("请选择") || choise.equals(null)) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		Integer sid = null;
		PageInfo<WxShop> list = wxShopService.findshopproduct(cid, sid, ptitle1, ptitle2,pageNum, pageSize);
		/**
		 * 注释片段是显示一个商户除了之前的一个商品外的几个商品 功能是查看更多（已移除）
		 */
		// if (list != null && list.size() != 0) {
		// for (WxShop ss : list) {
		// if (wxShopService.findshopproduct(null, ss.getSid(), choise).size()
		// != 0
		// && wxShopService.findshopproduct(null, ss.getSid(), choise) != null)
		// {
		// List<WxShop> findshopproduct = wxShopService.findshopproduct(null,
		// ss.getSid(), choise);
		// for (int i = 0; i < findshopproduct.size(); i++) {
		// if
		// (findshopproduct.get(i).getPro().getPname().equals(ss.getPro().getPname()))
		// findshopproduct.remove(i);
		// }
		// ss.setShop(findshopproduct);
		// }
		// }
		// } else {
		// WxShop shop = new WxShop();
		// WxProduct pro = new WxProduct();
		// pro.setInfo("暂无商品");
		// shop.setPro(pro);
		// }
		WxProductClass wxclass = wxProductClassService.selectclass(cid);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		map.put("list", list);
		map.put("bigclass", big);
		map.put("smallclass", small);
		String json = gson.toJson(map);
		Writer wt = res.getWriter();
		wt.write(json.toString());
		wt.flush();
	}

	/**
	 * 工作日常的商品详情 findbypid就是商品详情 json1 findlike是套餐 json2 selectassess是评论 json3
	 * findinfo是标签 json4 findtj是相似推荐 json5
	 *
	 * @param req
	 * @param res
	 * @param pid
	 *            商品id
	 * @param uid
	 *            用户id
	 * @param cid
	 *            商品分类id
	 * @throws IOException
	 */
	@RequestMapping("/findproductinfo")
	@ResponseBody
	public void findproductinfo(HttpServletRequest req, HttpServletResponse res, String pid, String cid, String uid)
			throws IOException {
		WxProgram.main(req, res);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = null;
		String json2 = null;
		String json3 = null;
		String json4 = null;
		String json5 = null;
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		if (cid != null) {
			String a = wxProductService.findid(cid);
			if (a != null) {
				pid = a;
			}
		}
		// 查询商品详情
		WxProduct findbypid = wxProductService.findbypid(pid);
		// 查询此商品是否被收藏
		if (wxUserCollectionService.findshou(uid, pid) != null) {
			findbypid.setCollection(true);
		} else {
			findbypid.setCollection(false);
		}
		WxShop findWxShopBySid = wxShopService.findWxShopBySid(findbypid.getSid());
		findbypid.setSname(findWxShopBySid.getSname());
		findbypid.setSlogo(findWxShopBySid.getSlogo());
		List<WxProduct> findtj = new ArrayList<>();
		List<String> li = new ArrayList<>();
		// 查询此商品所有的属性
		if (!findbypid.getProperty().equals("")) {
			String replaceAll = findbypid.getProperty().replaceAll("[\\[\\]]", "");
			String[] split = replaceAll.split(",");
			for (int i = 0; i < split.length; i++) {
				String[] split2 = split[i].split(":");
				String string = split2[1];
				li.add(string);
			}

			/* 注释掉的代码是根据属性进行的相似推荐，现在的相似推荐是根据相同分类进行推荐的 */

			/*
			 * String string = ":" + li.get(0); if
			 * (wxProductService.findtj(string, pid) != null &&
			 * wxProductService.findtj(string, pid).size() != 0) { findtj =
			 * wxProductService.findtj(string, pid); json5 =
			 * gson.toJson(findtj); } else { WxLabel wxl = new WxLabel();
			 * WxProduct wx = new WxProduct(); wxl.setLcinfo("暂无推荐");
			 * wx.setWxlabel(wxl); findtj.add(wx); json5 = gson.toJson(findtj);
			 * }
			 */
		} else {
			li.add("暂无属性");
		}
		findbypid.setPropertylist(li);// 得到此商品的所有属性
		if (cid == null || cid.equals("")) {
			cid = findbypid.getCid().toString();
		}
		// 根据商品分类进行相似推荐
		// findtj = wxProductService.findtj(pid, cid);
		if (wxProductService.findtj(pid, cid) != null && wxProductService.findtj(pid, cid).size() != 0) {
			findtj = wxProductService.findtj(pid, cid);
			json5 = gson.toJson(findtj);
		} else if (wxProductService.findtj(pid, cid).size() == 0) {
			WxProduct wx = new WxProduct();
			wx.setPname("暂无推荐");
			wx.setPrice(0.0);
			wx.setYprice(0.0);
			findtj.add(wx);
			json5 = gson.toJson(findtj);
		}
		json = gson.toJson(findbypid);
		String pname = findbypid.getPname();
		WxProduct findlike = new WxProduct();
		if (wxProductService.findlike(pname, pid) != null) {
			findlike = wxProductService.findlike(pname, pid);
			json2 = gson.toJson(findlike);
		} else {
			findlike.setPname("暂无套餐");
			json2 = gson.toJson(findlike);
		}
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxUser_assess> selectassess = new ArrayList<>();
		List<WxLabel> findinfo = new ArrayList<>();
		List<String> ls = new ArrayList<>();
		// 用户对此商品的评论
		Integer total = wps.total(Integer.parseInt(pid));// 查询商品评论总条数
		Integer commentsum = wps.commentsum(Integer.parseInt(pid));// 查询评论总分值
		Object sting =  null;
		if(total != 0 && commentsum !=0){
			double result = new BigDecimal((float)commentsum / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			sting = result;
		}else{
			double str = 0;sting = str;
		}
		if (wxUserAssessService.selectassess(Integer.parseInt(pid)) != null
				&& wxUserAssessService.selectassess(Integer.parseInt(pid)).size() != 0) {
			selectassess = wxUserAssessService.selectassess(Integer.parseInt(pid));
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
						if (wxLabelService.findinfo(lis) != null) {
							findinfo = wxLabelService.findinfo(lis);
							json4 = gson.toJson(findinfo);
						} else {
							WxLabel lab = new WxLabel();
							lab.setLcinfo("暂无标签");
							json4 = gson.toJson(findinfo);
						}
					} else {
						WxLabel lab = new WxLabel();
						lab.setLcinfo("暂无标签");
						findinfo.add(lab);
						json4 = gson.toJson(findinfo);
					}
				}
				hashset.add(ss);
			}
			json3 = gson.toJson(hashset);
		} else {
			WxUser_assess wxa = new WxUser_assess();
			wxa.setUainfo("暂无评论");
			hashset.add(wxa);
			json3 = gson.toJson(hashset);
			WxLabel lab = new WxLabel();
			lab.setLcinfo("暂无标签");
			findinfo.add(lab);
			json4 = gson.toJson(findinfo);
		}
		findbypid.setShop(findtj);
		findbypid.setLabe(findinfo);
		findbypid.setSet(hashset);
		findbypid.setPro1(findlike);
		String js = gson.toJson(findbypid);
		Map<String, String> map = new HashMap<>();
		map.put("info", json);// 详情
		map.put("total", total.toString());
		map.put("sting", sting.toString());
		map.put("label", json4);// 标签
		map.put("food", json2);// 套餐（删除）
		map.put("assess", json3);// 评论
		map.put("like", json5);// 推荐
		Writer wt = res.getWriter();
		wt.write(js.toString());
		wt.flush();
	}

	/**
	 * 
	 * @param req
	 * @param res
	 * @param firstPerson
	 *            筛选时传回来的第一项
	 * @param needchoise
	 *            筛选时，传回来的值，判断是方案还是商品
	 * @throws IOException
	 */
	@RequestMapping("/findaddress")
	public void findaddress(HttpServletRequest req, HttpServletResponse res, String firstPerson, String needchoise)
			throws IOException {
		WxProgram.main(req, res);
		// if (needchoise != null) {
		// needchoise = new String(needchoise.getBytes("iso8859-1"), "utf-8");
		// }
		// if (firstPerson != null) {
		// firstPerson = new String(firstPerson.getBytes("iso8859-1"), "utf-8");
		// }
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = null;
		if (needchoise.equals("整套方案") || needchoise.equals("整套方案") || needchoise.equals("完整方案")
				|| needchoise.equals("用餐+娱乐") || needchoise.equals("配套方案") || needchoise.equals("配套方案")
				|| needchoise.equals("系统推荐方案")) {

			Integer scid = null;
			if (scheme_classService.findscid(firstPerson) == null) {
				scid = 0;
			} else {
				scid = scheme_classService.findscid(firstPerson);
			}
			// 方案使用固定模板
			json = "../train/train?id=" + scid;
		} else if (needchoise.equals("商户推荐方案")) {
			needchoise = "培训方案";
		} else if (needchoise.equals("") || needchoise == "" || needchoise.equals("请选择")) {
			json = "../screen/screen";
		} else {
			json = Splice.ReturnPath(0, null, needchoise, null);
		}
		Writer wt = res.getWriter();
		wt.write(gson.toJson(json));
		wt.flush();
	}

	@RequestMapping("/findProductByIds")
	@ResponseBody
	public List<WxProduct> findProductByIds(HttpServletResponse response, String ids) {

		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");

		Gson gson = new Gson();
		List<Integer> list = gson.fromJson(ids, new TypeToken<List<Integer>>() {
		}.getType());
		return wxProductService.findProductByIds(list);

	}

	/**
	 * 对商品进行收藏
	 * 
	 * @param req
	 * @param res
	 * @param uid
	 *            用户id
	 * @param pid
	 *            商品id
	 * @throws IOException
	 */
	@RequestMapping("/insertshou")
	public void insertshou(HttpServletRequest req, HttpServletResponse res, Integer uid, Integer pid)
			throws IOException {
		WxProgram.main(req, res);
		WxUserCollection wx = new WxUserCollection();
		wx.setUrid(uid);
		wx.setOid(pid);
		wx.setOtype(1);
		wx.setUctype(1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		wx.setUcdate(formatter.format(new Date()));
		boolean collect = false;
		if(wx.getOid() != null || !wx.getOid().equals(null)){
			wxUserCollectionService.insert(wx);
			collect = true;
		}
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(collect));
		wt.flush();
	}
	
	//收藏商户
    @RequestMapping("/Scshop")
    public void Scshop(HttpServletRequest request,HttpServletResponse response,Integer uid,Integer sid) throws Exception{
    	WxProgram.main(request, response);
    	WxUserCollection wx = new WxUserCollection();
		wx.setUrid(uid);
		wx.setOid(sid);
		wx.setOtype(0);
		wx.setUctype(1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		wx.setUcdate(formatter.format(new Date()));
		wxUserCollectionService.Scshop(wx);
		boolean collect = true;
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = response.getWriter();
		wt.write(gson.toJson(collect));
		wt.flush();
    }
    
    //取消商户收藏
    @RequestMapping("/Qxshop")
	public void Qxshop(HttpServletRequest req, HttpServletResponse res, Integer sid, Integer uid)
			throws IOException {
		WxProgram.main(req, res);
		WxUserCollection findshou = wxUserCollectionService.scshop(sid,uid);
		wxUserCollectionService.Qxshop(findshou.getUcid());
		boolean collect = false;
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(collect));
		wt.flush();
	}
	/**
	 * 商品取消收藏
	 * 
	 * @param req
	 * @param res
	 * @param uid
	 *            用户id
	 * @param pid
	 *            商品id
	 * @throws IOException
	 */
	@RequestMapping("/deleteshou")
	public void deleteshou(HttpServletRequest req, HttpServletResponse res, Integer uid, Integer pid)
			throws IOException {
		WxProgram.main(req, res);
		WxUserCollection findshou = wxUserCollectionService.findshou(uid.toString(), pid.toString());
		wxUserCollectionService.delete(findshou.getUcid());
		boolean collect = false;
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(collect));
		wt.flush();
	}

	/**
	 * 列表页面的筛选，传回来的字，判断跳转页面
	 * 
	 * @param req
	 * @param res
	 * @param cname
	 *            商品分类名字
	 * @throws IOException
	 */
	@RequestMapping("/findmodel")
	public void findmodel(HttpServletRequest req, HttpServletResponse res, String cname) throws IOException {
		// if (cname != null) {
		// cname = new String(cname.getBytes("iso8859-1"), "utf-8");
		// }
		String returnPath = Splice.ReturnPath(0, null, cname, null);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(returnPath));
		wt.flush();
	}

	/**
	 * 查看用户对此商品的评论
	 * 
	 * @param req
	 * @param res
	 * @param pid
	 *            商品id
	 * @throws IOException
	 */
	@RequestMapping("/findcomment")
	public void findcomment(HttpServletRequest req, HttpServletResponse res, Integer pid,Integer pageNum, Integer pageSize) throws IOException {
		pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 6 : pageSize;
		PageInfo<WxUser_assess> selectassess1 = wxUserAssessService.selectassess1(pid,pageNum,pageSize);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(selectassess1));
		wt.flush();
	}
}
