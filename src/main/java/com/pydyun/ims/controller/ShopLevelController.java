package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopLevel;
import com.pydyun.ims.service.ShopLevelService;

@Controller
@RequestMapping("/grade")
public class ShopLevelController {
	@Resource
	private ShopLevelService ShopLevelService;
	
	//查询
	@RequestMapping("/list")
	@RequiresPermissions("grade:list")
	public ModelAndView selectlevel(Integer pageNum,Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<ShopLevel> list = ShopLevelService.selectshop(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("shop/shoplevel");
		mv.addObject("list", list);
		return mv;
	}
	
	//删除
	@RequiresPermissions("grade:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Integer slid){
		ShopLevelService.delete(slid);
	}
	
	//ID查询数据
	@RequiresPermissions("grade:list")
	@RequestMapping("/getLevel")
	@ResponseBody
	public ShopLevel getLevel(Integer slid){
		return ShopLevelService.getLevel(slid);
	}

	//修改
	@RequiresPermissions("grade:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(ShopLevel shoplevel){
		ShopLevelService.update(shoplevel);
	}
	
	//新增
	@RequiresPermissions("grade:add")
	@RequestMapping("/add")
	@ResponseBody
	public ShopLevel add(ShopLevel shoplevel){
		ShopLevelService.add(shoplevel);
		return shoplevel;
		
	}
}
