/*package com.pydyun.ims.controller.wxcontroller;

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

import com.pydyun.ims.model.WxUser_level;
import com.pydyun.ims.service.wxservice.WxUserService;

@Controller
@RequestMapping("/wxuser")
public class WxUserController {
	@Resource
	private  WxUserService wxuser;
	
	
	//用户等级
	@RequestMapping("/level")
	public void level(HttpServletRequest request,HttpServletResponse response,Integer id) throws Exception{
		WxUserController.main(request, response);
		List<WxUser_level> level = wxuser.level(id);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("level", level);
		JSONArray json = JSONArray.fromObject(level);
		String jsonl = json.toString();
		Writer wt = response.getWriter();
	    wt.write(jsonl);
		wt.flush();
		
	}
	public static void main(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");          
         设置响应头允许ajax跨域访问   
        response.setHeader("Access-Control-Allow-Origin", "*");  
         星号表示所有的异域请求都可以接受，   
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}
}
*/