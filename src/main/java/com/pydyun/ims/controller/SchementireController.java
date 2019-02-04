package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Plan;
import com.pydyun.ims.service.SchementireService;

@Controller
@RequestMapping("/stage")
public class SchementireController {
	@Resource
	private SchementireService tireService;
	
	@RequiresPermissions("stage:list")
	@RequestMapping("/list")
	public ModelAndView toMessage(Integer pageNum,Integer pageSize) throws Exception{
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		PageInfo<Plan> list = tireService.toMessageInfo(pageNum, pageSize);
		ModelAndView mv = new ModelAndView("stage/plan-list");
		mv.addObject("list", list);
		return mv;
		
	}
	
	@RequestMapping("/getList")
	public ModelAndView toInfo()throws Exception{
		List<Plan> list = tireService.toMessage();
		
		return null;
	}
}
