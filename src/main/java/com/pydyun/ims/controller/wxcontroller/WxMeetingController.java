package com.pydyun.ims.controller.wxcontroller;

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

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxImagesPl;
import com.pydyun.ims.model.WxProductClass;
import com.pydyun.ims.model.WxProductRequest;
import com.pydyun.ims.model.WxPromotion;
import com.pydyun.ims.model.WxPromotionRequest;
import com.pydyun.ims.model.WxSys_user;
import com.pydyun.ims.model.WxUser_assess;
import com.pydyun.ims.service.wxservice.WxProductClassService;
import com.pydyun.ims.service.wxservice.WxPromotionService;
import com.pydyun.ims.service.wxservice.WxUserAssessService;
import com.pydyun.ims.service.wxservice.WxUserCollectionService;
import com.pydyun.ims.util.Analysis2;
import com.pydyun.ims.util.WxProgram;

@Controller
@RequestMapping("/Meeting")
public class WxMeetingController {
	@Resource
	private WxPromotionService wps;
	@Resource
	private WxUserCollectionService wxUserCollectionService;
	@Resource
	private WxProductClassService wpc;
	@Resource
	WxUserAssessService wxUserAssessService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/classify")
	public void classify(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws Exception {
		WxProgram.main(request, response);
		ArrayList arr = new ArrayList();
		List<WxProductRequest> productclass = wps.productclass(id);// 查询商品分类一级id下所有分类
		WxPromotion training = wps.training();// 会议培训顶部广告
		String str = training.getPsource();
		Map<String, List<String>> ma = Analysis2.find(str);
		for (List<String> li : ma.values()) {
			String st = li.get(1);
			String[] sr = st.split(":");
			WxPromotionRequest request1 = new WxPromotionRequest();
			request1.setImgurl(li.get(0));
			request1.setInfo(null);
			request1.setJumpurl(sr[1]);
			WxProductRequest productfid = wps.productfid(Integer
					.parseInt(sr[1]));// 查询分类id
			request1.setFid(productfid.getCid());
			arr.add(request1);
		}
		List<WxProductRequest> seance = new ArrayList<>(); // 会议场地
		List<WxProductRequest> serve = new ArrayList<>(); // 会议服务
		if (productclass.size() != 0 && productclass != null) {
			for (WxProductRequest wx : productclass) {
				if (wx.getCid() == 11 || wx.getCid().equals("11")) {
					seance.add(wx);
				} else {
					serve.add(wx);
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seance", seance);
		map.put("serve", serve);
		map.put("arr", arr);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查询更多讲师
	@RequestMapping("/morelecturer")
	public void morelecturer(HttpServletRequest request,Integer pageNum, Integer pageSize,
			HttpServletResponse response, Integer id, String choise)throws Exception {
		WxProgram.main(request, response);
		 pageNum = pageNum == null ? 1 : pageNum;
	     pageSize = pageSize == null ? 5 : pageSize;
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if (choise.equals("") || choise.equals("请选择")) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> morelecturer = wps.morelecturer(id, ptitle1,ptitle2,pageNum,pageSize);
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		// for (WxProductRequest wx : morelecturer) {
		// String str = wx.getProperty();
		// String st = str.replaceAll("[\\[\\]]", "");
		// String[] sto = st.split(":");
		// wx.setProperty(sto[1]);
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("morelecturer", morelecturer);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查询更多课程
	@RequestMapping("/morecourse")
	public void morecourse(HttpServletRequest request,Integer pageNum, Integer pageSize,
			HttpServletResponse response, Integer id, String choise) throws Exception {
		WxProgram.main(request, response);
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 5 : pageSize;
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		String ptitle3 = null;
		if (choise.equals("") || choise.equals("请选择")) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> morecourse = wps.morecourse(id, ptitle1,ptitle2, ptitle3,pageNum,pageSize);
		// for (WxProductRequest wx : morecourse) {
		// String str = wx.getProperty();
		// String st = str.replaceAll("[\\[\\]]", "");
		// String[] sto = st.split(":");
		// wx.setProperty(sto[1]);
		// }
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("morecourse", morecourse);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查看课程详情
	@RequestMapping("/specificourse")
	public void specificourse(HttpServletRequest request,HttpServletResponse response, Integer id,String uid)
			throws Exception {
		WxProgram.main(request, response);
		List<String> ls = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxProductRequest> specificourse = wps.specificourse(id);
		List<WxProductRequest> forward = wps.forward(id); // 推荐理由
		List<WxProductRequest> teacher = wps.teacher(id); // 推荐讲师
		List<WxProductRequest> teacherr = new ArrayList<>();
		if (wxUserCollectionService.findshou(uid, id.toString()) != null) {
			specificourse.get(0).setCollection(true);
		} else {
			specificourse.get(0).setCollection(false);
		}
		if (teacher.size() != 0 && teacher != null) {
			for (WxProductRequest wx : teacher) {
				if (wx.getCid().equals("20") || wx.getCid() == 20) {
					teacherr.add(wx);
				}
			}
		}
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
		Map<String, Object> map = new HashMap<String, Object>();
		List<WxProductRequest> Besimilar = wps.Besimilar(id);// 查询相似推荐
		map.put("Besimilar", Besimilar);
		map.put("specificourse", specificourse);
		map.put("total", total);
		map.put("sting", sting);
		map.put("hashset", hashset);
		map.put("forward", forward);
		map.put("teacherr", teacherr);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查看场地详情页面数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/details")
	public void details(Integer id, String uid, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		WxProgram.main(request, response);
		ArrayList arr = new ArrayList();
		List<String> ls = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxProductRequest> details = wps.details(id);
		if (wxUserCollectionService.findshou(uid, id.toString()) != null) {
		    details.get(0).setCollection(true);
		} else {
			details.get(0).setCollection(false);
		}
		for (WxProductRequest wx : details) {
			String str = wx.getProperty();
			String st = str.replaceAll("[\\[\\]]", "");
			String[] sto = st.split(",");
			for (int i = 0; i < sto.length; i++) {
				String[] s = sto[i].split(":");
				String s1 = s[1];
				arr.add(s1);
			}
		}
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
		Object st =  null;
		if(total != 0 && commentsum !=0){
			double result = new BigDecimal((float)commentsum / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			st = result;
		}else{
			double str = 0;st = str;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<WxProductRequest> Besimilar = wps.Besimilar(id);// 查询相似推荐
		map.put("Besimilar", Besimilar);
		map.put("details", details);
		map.put("arr", arr);
		map.put("total", total);
		map.put("hashset", hashset);
		map.put("st", st);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查看更多高性价比场地
	@RequestMapping("/Moresites")
	public void Moresites(HttpServletRequest request,Integer pageNum, Integer pageSize,
			HttpServletResponse response, Integer id, String choise)throws Exception {
		WxProgram.main(request, response);
		 pageNum = pageNum == null ? 1 : pageNum;
	     pageSize = pageSize == null ? 5 : pageSize;
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if (choise.equals("") || choise.equals("请选择")) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> Moresites = wps.Moresites(id, ptitle1, ptitle2,pageNum,pageSize);
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Moresites", Moresites);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 配套服务列表查询
	@RequestMapping("/Matching")
	public void Matching(HttpServletRequest request,Integer pageNum, Integer pageSize,
			HttpServletResponse response, Integer id, String choise)
			throws Exception {
		WxProgram.main(request, response);
		 pageNum = pageNum == null ? 1 : pageNum;
	     pageSize = pageSize == null ? 5 : pageSize;
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if (choise.equals("") || choise.equals("请选择")) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> Matching = wps.Matching(id, ptitle1, ptitle2,pageNum,pageSize);
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Matching", Matching);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 配套服务详情页面
	@RequestMapping("/XqMatching")
	public void XqMatching(HttpServletRequest request,HttpServletResponse response, Integer id,Integer uid) throws Exception {
		WxProgram.main(request, response);
		List<String> ls = new ArrayList<>();
		Set<String> set = new HashSet<>();
		List<String> lis = new ArrayList<>();
		Set<WxUser_assess> hashset = new HashSet<>();
		List<WxProductRequest> XqMatching = wps.XqMatching(id);
		if (wxUserCollectionService.findshou(uid.toString(),id.toString())!= null) {
			XqMatching.get(0).setCollection(true);
		} else {
			XqMatching.get(0).setCollection(false);
		}
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
		List<WxProductRequest> Besimilar = wps.Besimilar(id);// 查询相似推荐
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XqMatching", XqMatching);
		map.put("hashset", hashset);
		map.put("total", total);
		map.put("sting", sting);
		map.put("Besimilar", Besimilar);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 方案列表查询
	@RequestMapping("/schema")
	public void schema(HttpServletRequest request,HttpServletResponse response, Integer id, String choise,
			Integer pageNum, Integer pageSize)throws Exception {
		WxProgram.main(request, response);
		choise = new String(choise.getBytes("iso8859-1"), "utf-8");
		String ptitle1 = null;
		String ptitle2 = null;
		if (choise.equals("") || choise.equals("请选择")) {
			ptitle1 = null;
			ptitle2 = null;
		} else {
			String[] split = choise.split("-");
			ptitle1 = split[0];
			ptitle2 = split[1];
		}
		PageInfo<WxProductRequest> schema = wps.schema(id, ptitle1, ptitle2,pageNum,pageSize);
		WxProductClass wxclass = wpc.selectclass(id);
		String big = wxclass.getCcname();
		String small = wxclass.getCname();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("schema", schema);
		map.put("big", big);
		map.put("small", small);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查询商品更多评论
	@RequestMapping("/productcomment")
	public void productcomment(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws Exception {
		WxProgram.main(request, response);
		List<WxUser_assess> productcomment = wps.productcomment(id); // 用户评论商品 (0=商户，1=方案，2=阶段，3=商品)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productcomment", productcomment);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}

	// 查询商户更多评论
	@RequestMapping("/shopcomment")
	public void shopcomment(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws Exception {
		WxProgram.main(request, response);
		List<WxUser_assess> shopcomment = wps.shopcomment(id); // 用户评论商品  (0=商户，1=方案，2=阶段，3=商品)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("shopcomment", shopcomment);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
}
