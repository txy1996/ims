package com.pydyun.ims.controller.wxcontroller;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pydyun.ims.model.WxSettings;
import com.pydyun.ims.service.wxservice.WxSettingsService;
import com.pydyun.ims.util.WxProgram;

@Controller
@RequestMapping("/settings")
public class WxSettingsController {
  
	@Resource
	private WxSettingsService wts;
	
	@RequestMapping("/sysreadme")
	public void sysreadme(HttpServletRequest request,HttpServletResponse response) throws Exception{
		WxProgram.main(request, response);
		List<WxSettings> sysreadme = wts.sysreadme();//用户协议、隐私说明
		Map<String,Object> map = new HashMap<>();
		map.put("sysreadme", sysreadme);
		JSONArray json = JSONArray.fromObject(map);
		String jsonlist = json.toString();
		Writer wt = response.getWriter();
		wt.write(jsonlist);
		wt.flush();
	}
	
}
