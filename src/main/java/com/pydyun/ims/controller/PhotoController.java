package com.pydyun.ims.controller;


import java.io.File;
import java.util.Date;


import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Album;
import com.pydyun.ims.model.Images;
import com.pydyun.ims.service.AlbumService;
import com.pydyun.ims.service.ImagesService;
import com.pydyun.ims.util.FileUploadUtil;

@Controller
@RequestMapping("/photo")
public class PhotoController {
	@Resource
	private AlbumService AlbumService;
	@Resource
	private ImagesService ImagesService;

	// 显示所创建的所有相册名称
	@RequiresPermissions("photo:list")
	@RequestMapping("/list")
	public ModelAndView photolist(Integer pageNum, Integer pageSize,Integer aid,Integer sid) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		if(aid == null){
			PageInfo<Album> listalbum = AlbumService.photolist1(pageNum, pageSize,sid);
			ModelAndView mv = new ModelAndView("shop/photo");
			mv.addObject("listalbum", listalbum);
			mv.addObject("sid", sid);
			return mv;
		}else{
			//aid查询相册对应照片
			PageInfo<Images> listimages = ImagesService.photolist(pageNum,pageSize,aid);
			ModelAndView mv = new ModelAndView("shop/images"); //展示照片信息
			mv.addObject("listimages", listimages);
			mv.addObject("aid", aid);
			return mv;
		}
	};

	// 创建相册
	@RequiresPermissions("photo:add")
	@RequestMapping("/addalbum")
	@ResponseBody
	public Album crealbum(/*Integer sid,*/Integer ssid,Integer faid,String aname,String ainfo,Integer urid,Integer auid,String adate,
			HttpServletRequest request) throws Exception {
		String aimg = request.getParameter("img");
		String sid = request.getParameter("sid");
		Album album = new Album();
		album.setSid(Integer.parseInt(sid));
		album.setSsid(ssid);
		album.setFaid(faid);
		album.setAname(aname);
		album.setAinfo(ainfo);
		album.setAimg(aimg);
		album.setUrid(urid);
		album.setAuid(auid);
		album.setAdate(adate);
			AlbumService.creabum(album);
			return album;
	}
	//处理文件
	@RequiresPermissions("photo:upload")
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request
			) throws Exception{
		String msg = FileUploadUtil.ImageUpload(file);
		return msg;
		/*File targetFile=null;
		String msg="";//返回存储路径
        String fileName=file.getOriginalFilename();//获取文件名加后缀
        if(fileName!=null&&fileName!=""){   
//            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/image/";//存储路径
            String returnUrl = "http" + "://" + "192.168.31.98" + ":" + "8080" + "/ims" +"/upload/image/photo";//存储路径
//            String path = request.getSession().getServletContext().getRealPath("upload/image"); //文件存储位置
            String path ="E:项目/ims/src/main/webapp/upload/image/photo"; //文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名
		//先判断文件是否存在
//        String fileAdd = DateUtil.formatDate(new Date(),"yyyyMMdd");
//        File file1 =new File(path+"/"+fileAdd); 
        File file1 =new File(path+"/"); 
        //如果文件夹不存在则创建    
        if(!file1 .exists()  && !file1 .isDirectory()){       
            file1 .mkdir();  
        }
        targetFile = new File(file1, fileName);
        try {
            file.transferTo(targetFile);
//            msg=returnUrl+fileAdd+"/"+fileName;
            msg=returnUrl+"/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
//        String fileName1 = a + fileName  ;
        return msg;*/
	}
	
	

	//aid查询相册对应的照片
	@RequiresPermissions("photo:list")
	@RequestMapping("/image")
	@ResponseBody
	public ModelAndView getimage(Integer pageNum,Integer pageSize,Integer aid) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Images> list = ImagesService.photolist(pageNum, pageSize,aid);
//		List<Images> list = ImagesService.photolist(pageNum,pageSize,aid);
		ModelAndView mv = new ModelAndView("shop/images"); //展示照片信息
		mv.addObject("list", list);
		return mv;
	};

	
    //aid查询数据
	@RequiresPermissions("photo:list")
	@RequestMapping("/getalbum")
	@ResponseBody
	public Album getUser(Integer aid) {
		Album album =  AlbumService.getalbum(aid);
		return album;

	}
	// 删除相册
	@RequiresPermissions("photo:delete")
	@RequestMapping("/deletealbum")
	@ResponseBody
	public void delete(Integer aid) {
		AlbumService.delete(aid);
	}
	// 更新相册
		@RequiresPermissions("photo:update")
		@RequestMapping("/updatealbum")
		@ResponseBody
		public void update(HttpServletRequest request) {
			String aimg = request.getParameter("img");
			String aid = request.getParameter("aid");
			Album album = new Album();
			album.setAimg(aimg);
			album.setAid(Integer.parseInt(aid));
			AlbumService.updatealbum(album); 
		}

	// 上传照片
	@RequiresPermissions("photo:add")
	@RequestMapping("/addscimages")
	@ResponseBody
	public Images creimages(/*Integer aid,*/String iname,String idate,HttpServletRequest request){
		String iurl = request.getParameter("iurl1");
		String iimgurl = request.getParameter("iimgurl1");
		String aid = request.getParameter("aid");
		Images images = new Images();
		images.setAid(Integer.parseInt(aid));
		images.setIdate(idate);
		images.setIurl(iurl);
		images.setIname(iname);
		images.setIimgurl(iimgurl);
		ImagesService.creimages(images);
		return images;
	}
    //iid查询数据
	@RequiresPermissions("photo:list")
	@RequestMapping("/getimages")
	@ResponseBody
	public Images getiid(Integer iid){
		return ImagesService.getiid(iid);
		
	}
	// 删除照片
	@RequiresPermissions("photo:delete")
	@RequestMapping("/deleteimages")
	@ResponseBody
	public void deleteimages(Integer iid) {
		ImagesService.deleteimages(iid);
	}
	
	//修改照片信息
	@RequiresPermissions("photo:update")
	@RequestMapping("/updateimages")
	@ResponseBody
	public void updateimages(Images images){
		ImagesService.updateimages(images);
	}
	
}
