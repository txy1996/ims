package com.pydyun.ims.controller.wxcontroller;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wx")
public class WxController {
	@RequestMapping("/text")
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        
	        response.setContentType("text/html;charset=utf-8");          
	        /* 设置响应头允许ajax跨域访问 */  
	        response.setHeader("Access-Control-Allow-Origin", "*");  
	        /* 星号表示所有的异域请求都可以接受， */  
	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
	       
	        //获取微信小程序get的参数值并打印
	        String username = request.getParameter("username");
	        System.out.println("username="+username);
	        
	        //返回值给微信小程序
	        Writer out = response.getWriter(); 
	        out.write("进入后台了");
	        out.flush();   
	    }
}

