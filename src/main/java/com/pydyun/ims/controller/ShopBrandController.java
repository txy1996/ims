package com.pydyun.ims.controller;


import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.service.ShopBrandService;

@Controller
@RequestMapping("/brand")
public class ShopBrandController {
	@Resource
	private ShopBrandService ShopBrandService;

	@RequiresPermissions("brand:list")
	@RequestMapping("/list")
	public ModelAndView showSettMsg(Integer pageNum, Integer pageSize) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<ShopBrand> list = ShopBrandService.selectshopcation(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("shop/shopbrand");
		mv.addObject("list", list);
		return mv;
	}
	//id查询
	 @RequiresPermissions("brand:list")
	    @RequestMapping("/getUser")
	    @ResponseBody
	    public ShopBrand getUser(Integer bid){
			return ShopBrandService.getshop(bid);
		 
	 }
	//删除单个
	 @RequiresPermissions("brand:delete")
	    @RequestMapping("/delete")
	    @ResponseBody
	    public void deleteshop(Integer bid) {
		 ShopBrandService.deleteshop(bid);
	    }
	 //新增
	 @RequiresPermissions("brand:add")
	 @RequestMapping("/add")
	 @ResponseBody
	 public ShopBrand add(ShopBrand shop){
		 ShopBrandService.addshop(shop);
		return shop;
		 
	 }
	 //更新
	 @RequiresPermissions("brand:update")
	 @RequestMapping("/update")
	 @ResponseBody
	 public void update(ShopBrand shop){
		 ShopBrandService.updateshop(shop);
	 }
}
