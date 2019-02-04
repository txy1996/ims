package com.pydyun.ims.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pydyun.ims.model.Image;
import com.pydyun.ims.service.ImageService;

@Controller
@RequestMapping("/file")
public class ImageController {
	@Autowired
	private ImageService is;
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,Image image,Model model)throws Exception {
		String sqlPath = null;
		String localPath = "F:\\File\\";
		String filename = null;
		if(!image.getFile().isEmpty()) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			//获取文件类型
			String contextType = image.getFile().getContentType();
			//获取文件后缀名
			String suffixName = contextType.substring(contextType.indexOf("/")+1);
			filename = uuid+"."+suffixName;
			image.getFile().transferTo(new File(localPath+filename));
			
		}
		sqlPath ="/images/"+filename;
		image.setImage(sqlPath);
		is.addImage(image);
		model.addAttribute("image",image);
		return "Myjsp";
	}
}
