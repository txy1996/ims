package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Voucherclass;
import com.pydyun.ims.service.VoucherclassService;

@Controller
@RequestMapping("/voucherclass")
public class VoucherclassController {
	
	@Resource
	private VoucherclassService VoucherclassService;
	
	//查询
	@RequiresPermissions("voucherclass:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum,Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Voucherclass> list = VoucherclassService.select(pageNum,pageSize);
		ModelAndView mv = new ModelAndView("voucher/voucherclass");
		mv.addObject("list", list);
		return mv;
	}
	
	//删除
	@RequiresPermissions("voucherclass:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Integer vcid){
		VoucherclassService.delete(vcid);
	}
	
	//新增
	@RequiresPermissions("voucherclass:add")
	@RequestMapping("/add")
	@ResponseBody
	public Voucherclass add(Integer vcid,Integer vcvcid,String vcname,String vcinfo){
		Voucherclass voucherclass = new Voucherclass();
//		voucherclass.setVcvcid(vcvcid);
		voucherclass.setVcname(vcname);
		voucherclass.setVcinfo(vcinfo);
		VoucherclassService.add(voucherclass);
		return voucherclass;
		
	}
	
	//更新ID查询
	@RequiresPermissions("voucherclass:list")
	@RequestMapping("/getvoucherclass")
	@ResponseBody
	public Voucherclass getid(Integer vcid){
		return VoucherclassService.getid(vcid);
	}
	
	//修改
	@RequiresPermissions("voucherclass:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(Voucherclass voucherclass){
		VoucherclassService.update(voucherclass);
	}
}
