package com.pydyun.ims.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Album;
import com.pydyun.ims.model.Promotion;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.model.ShopCation;
import com.pydyun.ims.model.ShopResponse;
import com.pydyun.ims.model.ShopSpare;
import com.pydyun.ims.model.Zone;
import com.pydyun.ims.service.AlbumService;
import com.pydyun.ims.service.PromotionService;
import com.pydyun.ims.service.RecordsService;
import com.pydyun.ims.service.ShopBrandService;
import com.pydyun.ims.service.ShopCationService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.ZoneService;
import com.pydyun.ims.util.FileUploadUtil;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Resource
	private ShopService ShopService;
	@Resource
	private ZoneService zService;
	@Resource
	private AlbumService AlbumService;
	@Resource
	private RecordsService recordsService;
	@Resource
	private ShopCationService shopcation;
	@Resource
	private ShopBrandService shopbrand;
	@Resource
	private PromotionService promotionService;

	@RequiresPermissions("shop:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum, Integer pageSize, String name1, Integer scid1, Integer bid1,
			String name2,Integer id) throws UnsupportedEncodingException {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		String sname = null;
		String scommerce = null;
		if (name1 == null || name1.equals("") || name1 == "") {
			name1 = null;
			name2 = null;
		} else {
			name1 = new String(name1.getBytes("iso8859-1"), "utf-8");
			if (name2 == "" || name2 == null || name2.equals("")) {
				name2 = null;
			} else {
				name2 = new String(name2.getBytes("iso8859-1"), "utf-8");
			}
			if (name1.equals("商户名") || name1 == "商户名") {
				sname = name2;
				scommerce = null;
			} else if (name1.equals("联系电话") || name1 == "联系电话") {
				sname = null;
				scommerce = name2;
			}
		}
		PageInfo<Shop> list = ShopService.selectshop(pageNum, pageSize, scid1, bid1, sname, scommerce);
		List<Shop> lists = list.getList();
		Integer snumber1 = 0;
		Integer pnumber1 = 0;
		Integer snumber2 = 0;
		Integer pnumber2 = 0;
		List<String> lis2 = new ArrayList<String>();
		ModelAndView mv = new ModelAndView("shop/shop");
		String a = null;
		String b = null;
		for (Shop li : lists) {
			Integer sid = li.getSid();
			StringBuffer vrange = new StringBuffer();
			vrange.append("s:" + sid);
			snumber1 = recordsService.findnumber(vrange.toString());
			if (snumber1 != null) {
				a = String.valueOf(snumber1);
			} else {
				a = null;
			}
			snumber2 = recordsService.findnumber1(vrange.toString());
			if (snumber2 != null) {
				b = String.valueOf(snumber2);
			} else {
				b = null;
			}
			Integer bids;
			if (bid1 == null || bid1.equals("") || bid1.equals("0")) {
				bids = li.getBid();
			} else {
				bids = bid1;
			}
			if (bids != null) {
				StringBuffer vrange1 = new StringBuffer();
				vrange1.append("p:" + bids);
				pnumber1 = recordsService.findnumber(vrange1.toString());
				if (pnumber1 != null) {
					if (a != null) {
						a = a + "+" + String.valueOf(pnumber1);
					} else {
						a = String.valueOf(pnumber1);
					}

				} /*else {
					a = a;
				}*/
				pnumber2 = recordsService.findnumber1(vrange1.toString());
				if (pnumber2 != null) {
					if (b != null) {
						b = b + "+" + String.valueOf(pnumber2);
					} else {
						b = String.valueOf(pnumber2);
					}
				} /*else {
					b = b;
				}*/
			}
			li.setNumber(a);
			li.setNumber1(b);
			list.setList(lists);
		}
		List<String> listbid = ShopService.selectbid();// 商户分类ID
		List<Zone> zid = ShopService.selectzid();// 查询地区
		List<ShopCation> findAllSett = shopcation.findAllSett();
		List<ShopBrand> selectall = shopbrand.selectall();
		if(id!=null){
			mv.addObject("ggid", id);
		}
		mv.addObject("lists", lists);
		mv.addObject("lis2", lis2);
		mv.addObject("list", list);
		mv.addObject("listbid", listbid);
		mv.addObject("zid", zid);
		mv.addObject("findAllSett", findAllSett);
		mv.addObject("selectall", selectall);
		return mv;
	}

	// id查询
	@RequiresPermissions("shop:list")
	@RequestMapping("/getUser")
	@ResponseBody
	public ShopSpare getUser(Integer sid) {
		return ShopService.getshop(sid);

	}

	// 删除单个
	@RequiresPermissions("shop:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteshop(Integer sid) {
		ShopService.deleteshop(sid);
	}

	@RequiresPermissions("shop:add")
	@RequestMapping("/add")
	@ResponseBody
	public Shop add(@RequestParam(value = "file", required = false) MultipartFile[] file,Shop shop){
		String slogo = null;
		if(file!=null){
			slogo = FileUploadUtil.ImageUpload(file[0]);
		}
		shop.setSlogo(slogo);
		shop.setStime(new Date());
		shop.setSutime(new Date());
		ShopService.addshop(shop);
		return shop;
		
	}

	// 更新
	@RequiresPermissions("shop:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(@RequestParam(value = "file", required = false) MultipartFile[] file,Shop shop) {
		if(file!=null){
			if(!file[0].isEmpty()){
				String slogo = FileUploadUtil.ImageUpload(file[0]);
				shop.setSlogo(slogo);
			}						
		}	
		shop.setSutime(new Date());
		System.err.println(shop.toString());
		ShopService.updateshop(shop);
	}

	// sid查看相册
	@RequestMapping("/getalbum")
	public ModelAndView getsid(Integer pageNum, Integer pageSize, Integer sid) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Album> listalbum = AlbumService.photolist(pageNum, pageSize, sid);
		ModelAndView mv = new ModelAndView("shop/photo");
		mv.addObject("listalbum", listalbum);
		return mv;
	}

	@RequestMapping("/getByShopName")
	@ResponseBody
	public List<ShopResponse> getByShopName(ShopResponse response) {
		List<ShopResponse> shops = ShopService.getByShopName(response);

		return shops;

	}
	
	private String fileUpload(MultipartFile file)
    {
        File targetFile = null;
        String msg = "";// 返回存储路径
        String fileName = file.getOriginalFilename();// 获取文件名加后缀
        if (fileName != null && fileName != "")
        {
            String returnUrl = "http" + "://" + "192.168.31.98" + ":" + "8080" + "/ims" + "/upload/image";// 存储路径
            String path = "E:\\项目\\ims\\src\\main\\webapp\\upload\\image"; // 文件存储位置
            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
            fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
            File file1 = new File(path + "/");
            targetFile = new File(file1, fileName);
            try
            {
                file.transferTo(targetFile);
                msg = returnUrl + "/" + fileName;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return msg;

    }
	
	@RequestMapping("/ShopRecommend")
	@ResponseBody
	public List<Promotion> ShopRecommend(Integer ptype) {	
//		List<Promotion> findShopRecommend = promotionService.findShopRecommend(ptype);
		return promotionService.findShopRecommend(ptype);
	}

	@RequestMapping("/findshopname")
	@ResponseBody
	public String findshopname(Integer id) {		
		return ShopService.getsname(id);
	}
	
	@RequestMapping("/findprombyid")
	@ResponseBody
	public Promotion findprombyid(Integer id) {	
		return promotionService.edit1(id);
	}
	
	//给商户添加照片id
	@RequestMapping("/picture")
	public void picture(Integer id,Integer sid,HttpServletResponse response) throws Exception{
		Shop shop = new Shop();
		List<Shop> sp = ShopService.Styleimg(sid);
		if(sp.get(0) == null){
			shop.setStyleimg(String.valueOf(id));
			shop.setSid(sid);
			ShopService.picture(shop);
		}else{
		for (Shop shp : sp) {
			String str = shp.getStyleimg();
			/*if(str == null){
				shop.setStyleimg(String.valueOf(id));
			}else*/ if(str.contains(String.valueOf(id))){
				shop.setStyleimg(str);
			}else{
				String s = str + "," + String.valueOf(id);
				shop.setStyleimg(s);
			}
		}
		shop.setSid(sid);
		ShopService.picture(shop);
		}
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter wt = response.getWriter();
		wt.print(1);
		wt.close();
	}
	
	@RequestMapping("/findpromlist")
	@ResponseBody
	public List<Promotion> findpromlist(Integer id) {	
		
		String psource = null;
		if(id==-1){
			psource = null;
		}else if(id==5){
			psource = ":LST";
		}else if(id==11){
			psource = ":LS";
		}else if(id==8){
			psource = ":LSC";
		}
		List<Promotion> list = promotionService.findpromlist(psource);
		return list;
	}
}
