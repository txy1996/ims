package com.pydyun.ims.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WxProgram {
	/*微信前后台通讯*/
	
	public static void main(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");          
//         设置响应头允许ajax跨域访问   
        response.setHeader("Access-Control-Allow-Origin", "*");  
//         星号表示所有的异域请求都可以接受，   
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}
}
