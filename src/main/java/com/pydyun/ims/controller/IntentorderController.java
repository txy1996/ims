package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Intentorder;
import com.pydyun.ims.service.IntentorderService;

@Controller
@RequestMapping("/intentorder")
public class IntentorderController {
	
	@Resource
	private IntentorderService ids;
	
	@RequiresPermissions("intentorder:list")
	@RequestMapping("/list")
	public ModelAndView listintentorder(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Intentorder> list = ids.listintentorder(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("intentorder/intentorder");
		mv.addObject("list", list);
		return mv;
	} 
	
    //修改未处理的状态
	@RequestMapping("/Handle")
	public ModelAndView Handle(Integer id,Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		ids.Handle(id);
		PageInfo<Intentorder> list = ids.listintentorder(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("intentorder/intentorder");
		mv.addObject("list", list);
		return mv;
	}
}
