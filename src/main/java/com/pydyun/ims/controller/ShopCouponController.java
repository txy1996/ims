package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Coupon;
import com.pydyun.ims.service.CouponService;
import com.pydyun.ims.service.ShopService;

@Controller
@RequestMapping("/shopcoupon")
public class ShopCouponController {

	@Resource
	CouponService couponService;
	@Resource
	ShopService ss;
	
	@RequiresPermissions("shopcoupon:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum,Integer pageSize,Integer sid,String starttime,String endtime,String name,String cstore){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		if(starttime!=null &&endtime!=null){
			if(starttime==""||starttime.equals("")){
				starttime=null;
			}
			if(endtime==""||endtime.equals("")){
				endtime=null;
			}
		}
		Integer a=null,b=null;
		if(cstore!=null){
			if(cstore==""||cstore.equals("")){
				a=null;
				b=null;
			}else{
			String[]  str= cstore.split("~");
			a=Integer.parseInt(str[0]);
			b=Integer.parseInt(str[1]);
			}
		}
		String crange="s:"+sid;
		PageInfo<Coupon> list = couponService.findall1(pageNum, pageSize, crange,starttime,endtime,a,b);
		String getsname = ss.getsname(sid);
		ModelAndView mv = new ModelAndView("coupon/shopcoupon");
		mv.addObject("list",list);
		mv.addObject("findname",getsname);
		mv.addObject("sid",sid);
		return mv;
	}
	
	@RequiresPermissions("shopcoupon:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Coupon co){
		couponService.update2(co);
		
	}
			
	@RequiresPermissions("shopcoupon:list")
    @RequestMapping("/getshopcoupon")
    @ResponseBody
    public Coupon getshopcoupon(Integer cid)
    {
		Coupon co = couponService.getmessage1(cid);
				return co;
    }
	
	@RequiresPermissions("shopcoupon:deleteshopcoupon")
    @RequestMapping("/deleteshopcoupon")
    @ResponseBody
    public void deleteshopcoupon(Integer cid)
    {
		couponService.deleteshopcoupon(cid);
    }
}
