/*package com.pydyun.ims.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.StageShop;
import com.pydyun.ims.service.SchemeService;

@Controller
@RequestMapping("/staShop")
public class StaShopController {
	@Resource
	private SchemeService scService;
	
	@RequiresPermissions("staShop:list")
	@RequestMapping("/list")
	public ModelAndView toCompany(Integer pageNum,Integer pageSize) throws Exception{
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		PageInfo<StageShop> staShop =scService.getStShop(pageNum, pageSize);
		List<String> list = scService.getShopName();
		List<String> stage = scService.stageName();
		ModelAndView mv = new ModelAndView("scheme/staShop_list");
		mv.addObject("staShop",staShop);
		mv.addObject("list",list);
		mv.addObject("stage", stage);
		return mv;
	}
	
	@RequiresPermissions("staShop:list")
	@RequestMapping("/getStaShop")
	@ResponseBody
	public StageShop getOneMessage(String id) {
		return scService.getOneStaShop(Integer.valueOf(id));
	}
	
	@RequiresPermissions("staShop:add")
	@RequestMapping("/add")
	@ResponseBody
	public StageShop add(StageShop staShop,HttpServletRequest  request) throws Exception{
		String sqlPath = null;
		String localPath ="D:\\File\\";
		String filename = null;
		if(!staShop.getFile().isEmpty()) {
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//获取文件类型
			String contentType = staShop.getFile().getContentType();
			//获取后缀名
			String suffixName = contentType.substring(contentType.indexOf("/")+1);
			filename =uuid +"."+suffixName;
			staShop.getFile().transferTo(new File(localPath+filename));
		}
		sqlPath ="/images/"+filename;
		staShop.setSsimgs(sqlPath);
		scService.addStaShop(staShop);
		return staShop;
	}
	@RequiresPermissions("staShop:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void delteInfo(String id) {
		scService.deleteStaShop(Integer.valueOf(id));
	}
	@RequiresPermissions("staShop:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateInfo(StageShop staShop) {
		scService.updateStaShop(staShop);
	}
}
*/