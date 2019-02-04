package com.pydyun.ims.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.model.Coupon;
import com.pydyun.ims.service.AdminusersService;
import com.pydyun.ims.service.CouponService;
import com.pydyun.ims.service.CouponclassService;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	@Resource
	private CouponService CouponService;
	@Resource
	private CouponclassService cou;
	@Resource
	private AdminusersService adminService;
	//优惠券管理
	@RequiresPermissions("coupon:list")
	@RequestMapping("/list")
	public ModelAndView selectcoupon(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Coupon> list = CouponService.selectcoupon(pageNum,pageSize);
		List<String> name = cou.getName();
		ModelAndView mv = new ModelAndView("coupon/coupon");
		mv.addObject("list", list);
		mv.addObject("name", name);
		return mv;
	}
	@RequestMapping("/addCoupon")
	@ResponseBody
	public ModelAndView addCoupon(ModelAndView mv) {
		List<String> list = cou.getName();
		mv.setViewName("coupon/addCoupon");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequiresPermissions("coupon:add")
	@RequestMapping("/add")
	@ResponseBody
	public String addcou(@RequestParam("rowVal") String rowVal){
		Map<String,String> map = new Gson().
				fromJson(rowVal, new TypeToken<HashMap<String,Object>>(){}.getType());
		Coupon cp = new Coupon();
		String ccid = map.get("ccid");
		String ctitle = map.get("ctitle");
		String crange1 = map.get("crange1");
		if(crange1.equals("单店")){
			crange1 = "s:1";
		}else if(crange1.equals("品牌店")){
			crange1 = "p:1";
		}else{
			crange1 = "all";
		}
		String cdiscount = map.get("cdiscount");
		String csum = map.get("csum");
		String cfullcut = map.get("cfullcut");
		String cmoney = map.get("cmoney");
		String cprice = map.get("cprice");
		String cgoods = map.get("cgoods");
		String crefund = map.get("crefund");
		if(crefund.equals(0)){
			crefund = "失效不退款";
		}else if(crefund.equals(1)){
			crefund = "延长有效期";
		}else{
			crefund = "过期可退款";
		}
		String cisood = map.get("cisood");
		String cintegration = map.get("cintegration");
		String img = map.get("img");
		String vinfo = map.get("vinfo");
		String csdate = map.get("csdate");
		String codate = map.get("codate");
		cp.setCcid(Integer.parseInt(ccid));
		cp.setCtitle(ctitle);
		cp.setCrange(crange1);
		cp.setCdiscount(cdiscount);
		cp.setCsum(csum);
		cp.setCfullcut(cfullcut);
		cp.setCmoney(cmoney);
		cp.setCgoods(Integer.parseInt(cgoods));
		cp.setCrefund(crefund);
		cp.setCisood(Integer.parseInt(cisood));
		cp.setCintegration(Integer.parseInt(cintegration));
		cp.setCimg(img);
		cp.setCinfo(vinfo);
		cp.setCsdate(csdate);
		cp.setCodate(codate);
		cp.setCprice(cprice);
		CouponService.addcou(cp);
		return "coupon/addCoupon";
	}
	
	
	
	
	
	
/**
 * 添加优惠券信息
 * @param pageNum
 * @param pageSize
 * @param coupon
 * @param file
 * @param request
 * @return
 * @throws Exception
 */

	@RequestMapping(value="/upload",method=RequestMethod.POST)  
	public  String fildUpload(Integer pageNum, Integer pageSize,Coupon coupon,@RequestParam(value="file",required=false) MultipartFile file,  
			HttpServletRequest request)throws Exception {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Coupon> list = CouponService.selectcoupon(pageNum,pageSize);
		String pathRoot = request.getSession().getServletContext().getRealPath("");  
		String path="";  
		if(!file.isEmpty()) {
			String uuid = UUID.randomUUID().toString().replaceAll("-","");  
			String contentType=file.getContentType();  
			String imageName=contentType.substring(contentType.indexOf("/")+1);  
			path = "/images/"+uuid+"."+imageName;  
			file.transferTo(new File(pathRoot+path));  
		}
		coupon.setUaid(0);
		coupon.setCimg(path);
		CouponService.add(coupon);
		request.setAttribute("coupon",coupon);  
		request.setAttribute("list",list);
		return "coupon/success"; 
	}
	
	public static int getPrice(int originalPrice) {
		 int result = 0;
		 int discount = 0;
		 if(originalPrice>=100) {
			 discount =  (originalPrice - (originalPrice % 100)) / 100 * 40;
		 }
		 result = originalPrice - discount;
		 return result;
	}
	
	@RequiresPermissions("coupon:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteCoupon(Integer cid) {
		CouponService.delete(cid);
	}
	@RequestMapping("/getCoupon")
	public ModelAndView getCoupon(String id) {
		Coupon coupon = CouponService.getcoupon(Integer.valueOf(id));
		ModelAndView mv = new ModelAndView("coupon/couponMessage");
		mv.addObject("coupon", coupon);
		return mv;
	}
	@RequiresPermissions("coupon:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateCoupon(Coupon coupon) {
		CouponService.update(coupon);
	}
	@RequiresPermissions("coupon:list")
	@RequestMapping("/getUpdate")
	@ResponseBody
	public Coupon getUpdate(Integer id) {
		Coupon coupon = CouponService.getcoupon(id);
		return coupon;
	}
}
