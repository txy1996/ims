package com.pydyun.ims.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Settings;
import com.pydyun.ims.service.SettService;

@Controller
@RequestMapping("/sett")
public class SettController {
	@Resource
	private SettService settService;
	@RequiresPermissions("sett:show")
	@RequestMapping("/list")
	public ModelAndView showSettMsg(Integer pageNum,Integer pageSize,String systitle,HttpServletRequest request) throws UnsupportedEncodingException {
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		systitle = (systitle == null || "".equals(systitle))?null:systitle;
	/*	try {
			systitle = java.net.URLDecoder.decode(systitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		PageInfo<Settings> sett = settService.getAllMessage(pageNum, pageSize,systitle);
		String falg = systitle;
		ModelAndView mv = new ModelAndView("sett/sett-list");
		request.setAttribute("falg", falg);
		mv.addObject("sett",sett);
		return mv;
	}

	@RequiresPermissions("sett:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteSett(String id) {
		if(id !=null && id.length()>0) {			
			settService.delteSett(Integer.valueOf(id));
		}
	}
	@RequiresPermissions("sett:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateSett(Settings settings) {
		settService.updateSettings(settings);
	}
	
	
	@RequiresPermissions("sett:show")
    @RequestMapping("/getSett")
    @ResponseBody
    public Settings getSett(int id) {
		return settService.findById(id);
    }
	@RequiresPermissions("sett:show")
    @RequestMapping("/getSettInfo")
    @ResponseBody
	public Settings getMsgBySystitle(String systitle) {
		return settService.GetMsgByTitle(systitle);
	}
	@RequiresPermissions("sett:add")
	@RequestMapping("/add")
	@ResponseBody
	public Settings addSettings(Settings settings){
		settService.addSett(settings);
		return settings;
	}
}
