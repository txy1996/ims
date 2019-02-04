package com.pydyun.ims.controller.wxcontroller;

import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pydyun.ims.model.Album;
import com.pydyun.ims.service.AlbumService;

@Controller
@RequestMapping("/wxphoto")
public class WxPhotoController {
	
	@Resource
	private AlbumService AlbumService;
	@RequestMapping("/photo")
	public void photo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       
        //获取微信小程序get的参数值并打印
//        String username = request.getParameter("username");
        //查询数据
        List<Album> list = AlbumService.select();
        System.out.println(list);
        //转json
        JSONArray jsonArray =JSONArray.fromObject(list);//把list转成JSONArray
        String json = jsonArray.toString();//json字符串
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
	}

}
