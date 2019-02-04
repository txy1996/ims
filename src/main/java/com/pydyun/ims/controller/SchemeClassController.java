package com.pydyun.ims.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Scheme_class;
import com.pydyun.ims.service.Scheme_classService;

@Controller
@RequestMapping("/schemeclass")
public class SchemeClassController {
	@Resource
	private Scheme_classService classService;
	
	@RequiresPermissions("schemeclass:list")
	@RequestMapping("/list")
	public ModelAndView showClassList(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Scheme_class> list=classService.getClassList(pageNum, pageSize);
		List<Scheme_class> listsc=classService.getClassIdAndNmae();
		for(Scheme_class ss:list.getList()){
			if(ss.getScscid()==null||ss.getScscid().equals("")){
				ss.setScscid(0);
			}
			ss.setScscname(classService.findscscname(ss.getScscid()));
		}
		List<Integer> listint=new ArrayList<>();
		List<String> liststr=new ArrayList<>();
		for(Scheme_class sc:listsc){
			int id=sc.getScid();
			listint.add(id);
			String name=sc.getScname();
			liststr.add(name);
		}
		ModelAndView mv = new ModelAndView("scheme/schemeclass");
		mv.addObject("list", list);
		mv.addObject("listint", listint);
		mv.addObject("liststr", liststr);
		return mv;		
	}
	
	/**
	 * 根据id查询
	 */
	@RequiresPermissions("schemeclass:list")
	@RequestMapping("/getById")
	@ResponseBody
	public Scheme_class getById(Integer scid){
		return classService.getOne(scid);
	}
	
	/**
	 * 新增方案分类
	 */
	@RequiresPermissions("schemeclass:add")
	@RequestMapping("/addClass")
	@ResponseBody
	public Scheme_class addClass(Scheme_class scheme_class){
		if(scheme_class.getScid()==null||scheme_class.getScid().equals("")){
			scheme_class.setScscid(0);
		}else if(scheme_class.getScid()!=null){
			scheme_class.setScscid(scheme_class.getScid());
		}
		scheme_class.setScid(null);
		scheme_class.setScinfo(scheme_class.getScinfo());
		scheme_class.setScname(scheme_class.getScname());
		classService.addClass(scheme_class);
		return scheme_class;		
	}
	
	/**
	 * 删除方案分类
	 */
	@RequiresPermissions("schemeclass:delete")
	@RequestMapping("/deleteClass")
	@ResponseBody
	@Transactional
	public void deleteClass(Integer scid){		
		deletechild(scid);
		classService.deleteByScid(scid);
	}
	
	public void deletechild(Integer scid){
		List<Scheme_class> list = classService.findscscid(scid);
		if(list!=null && list.size()!=0){
			for(Scheme_class sc:list){
				deleteClass(sc.getScid());
			}
		}
	}
	
	/**
	 * 修改方案分类
	 */
	@RequiresPermissions("schemeclass:update")
	@RequestMapping("/updateClass")
	@ResponseBody
	public void updateClass(Scheme_class schemeClass){
		classService.updateClass(schemeClass);
	}
	
	@RequiresPermissions("schemeclass:selectname")
	@RequestMapping("/selectname")
	@ResponseBody
	public String selectname(Integer scid){
		return classService.findscscname(scid);
	}
}
