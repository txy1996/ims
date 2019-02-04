package com.pydyun.ims.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

 
public class UploadUtil {  
	public String uploadimg(MultipartFile multi , HttpServletRequest request){
		String fileUrl="";
		if(multi.isEmpty()) {
			System.out.println("无法找到文件");
			return "";
		}else {
			System.out.println("文件长度"+multi.getSize());
			System.out.println("文件类型"+multi.getContentType());
			System.out.println("文件名称"+multi.getName());
			System.err.println("文件原名"+multi.getOriginalFilename());
			System.out.println("---------------------------------");
			String realPath= request.getSession().getServletContext().getRealPath("/WEB-INF/yeehot");
			File targeFile = new File(realPath);
			if(!targeFile.exists()) {
				targeFile.mkdirs();
			}
			System.out.println(realPath);
			int i = multi.getOriginalFilename().lastIndexOf(".");
			String extension = multi.getOriginalFilename().substring(i+1);
			String filename = UUID.randomUUID().toString()+"."+extension;
			fileUrl = filename;
			try {
				multi.transferTo(new File(realPath,filename));
			} catch (IllegalStateException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return fileUrl;
		}
	}
  
}  