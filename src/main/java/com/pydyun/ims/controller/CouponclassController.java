package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Couponclass;
import com.pydyun.ims.service.CouponclassService;

@Controller
@RequestMapping("/couponclass")
public class CouponclassController {
	
	@Resource          
	private CouponclassService CouponclassService;
	
	//查询
	@RequiresPermissions("couponclass:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Couponclass> list = CouponclassService.select(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("coupon/couponclass");
		mv.addObject("list", list);
		return mv;
	}

	//删除
	@RequiresPermissions("couponclass:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Integer ccid){
		CouponclassService.delete(ccid);
	}
	
	//新增
	@RequiresPermissions("couponclass:add")
	@RequestMapping("/add")
	@ResponseBody
	public Couponclass add(Couponclass couponclass){
		CouponclassService.add(couponclass);
		return couponclass;
	}
	
	//ID查询
	@RequiresPermissions("couponclass:list")
	@RequestMapping("/getcouponclass")
	@ResponseBody
	public Couponclass getcoupon(Integer ccid){
		return CouponclassService.getcoupon(ccid);
	}
	//修改
	@RequiresPermissions("couponclass:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(Couponclass couponclass){
		CouponclassService.update(couponclass);
	}
}
