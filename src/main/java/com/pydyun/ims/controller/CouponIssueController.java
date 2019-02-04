package com.pydyun.ims.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.model.Coupon;
import com.pydyun.ims.model.Couponclass;
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.Records;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.model.User;
import com.pydyun.ims.service.CouponService;
import com.pydyun.ims.service.CouponclassService;
import com.pydyun.ims.service.ProductClassService;
import com.pydyun.ims.service.RecordsService;
import com.pydyun.ims.service.ShopBrandService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/couponissue")
public class CouponIssueController {

	@Resource
	private CouponService couponService;
	@Resource
	private CouponclassService couponclassService;
	@Resource
	private UserService userService;
	@Resource
	private ShopBrandService shopbrandService;
	@Resource
	private ShopService shopService;
	@Resource
	private RecordsService recordsService;
	@Resource
	private ProductClassService productClassService;

	@RequiresPermissions("couponissue:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum, Integer pageSize, String crange1, String ccid, String ctitle,
			Integer sid, Integer bid) throws UnsupportedEncodingException {
		List<Couponclass> list = couponclassService.getccname();
		List<User> users = userService.finduser();
		// List<Coupon> findbys = new ArrayList<>();
		List<ShopBrand> find1 = new ArrayList<>();
		List<Shop> find2 = new ArrayList<>();
		ModelAndView mv = new ModelAndView("coupon/couponissue");
		if (sid != null) {
			crange1 = "单店";
			find2 = shopService.findshop1(sid);
			String sname = null;
			for (Shop s : find2) {
				sname = s.getSname();
			}
			mv.addObject("find2", find2);
			mv.addObject("sid", sid);
			mv.addObject("sname", sname);
		} else if (bid != null) {
			crange1 = "品牌通用";
			find1 = shopbrandService.selectshop1(bid);
			mv.addObject("find1", find1);
			mv.addObject("bid", bid);
		} else if (bid == null && sid == null) {
			if (crange1 == null) {
				find2 = shopService.findshop();
				mv.addObject("find2", find2);
			} else {
				crange1 = new String(crange1.getBytes("iso8859-1"), "utf-8");
				if (crange1.equals("单店") || crange1.equals("单店1")) {
					find2 = shopService.findshop();
					mv.addObject("find2", find2);
				} else if (crange1.equals("品牌通用")) {
					find1 = shopbrandService.selectall();
					mv.addObject("find1", find1);
				}
			}
			mv.addObject("sid", sid);
			mv.addObject("bid", bid);
		}

		if (ccid != null && ctitle != null) {
			ccid = new String(ccid.getBytes("iso8859-1"), "utf-8");
			ctitle = new String(ctitle.getBytes("iso8859-1"), "utf-8");
		}
		mv.addObject("list", list);
		mv.addObject("users", users);
		mv.addObject("crange1", crange1);
		mv.addObject("ccname", ccid);
		mv.addObject("ctitle", ctitle);
		return mv;
	}

	@RequiresPermissions("couponissue:add")
	@RequestMapping("/add")
	@ResponseBody
	@Transactional
	public String add(@RequestParam("rowVal") String rowVal) throws ParseException {
		Map<String, String> map = new Gson().fromJson(rowVal, new TypeToken<HashMap<String, String>>() {
		}.getType());
		Records re = new Records();
		String crange = map.get("crange1");
		String sorpname = map.get("sorpname");
		if (sorpname == null) {
			sorpname = "";
		}
		String sids = map.get("sids");
		if (sids != null && sorpname.equals("")) {
			sorpname = sids;
		}
		if (crange == "单店" || crange == "单店1" || crange.equals("单店") || crange.equals("单店1")) {
			crange = "s:" + sorpname;
		} else if (crange == "品牌通用" || crange.equals("品牌通用")) {
			crange = "p:" + sorpname;
		} else if (crange == "全站通用" || crange.equals("全站通用")) {
			sorpname = "";
			crange = "all" + sorpname;
		}
		Date regdate = new Date();
		String rnumber = map.get("ctotal");
		Integer rnumber1 = Integer.parseInt(rnumber);
		Integer vorc = 1;
		String uaid = map.get("uaid");
		Integer uaid1 = Integer.parseInt(uaid);
		re.setVrange(crange);
		re.setRegdate(regdate);
		re.setRnumber(rnumber1);
		re.setVorc(vorc);
		re.setUaid(uaid1);
		recordsService.addReVoucher(re);
		Integer crid = recordsService.findid();
		String ccid = map.get("ccid");
		Integer ccid1 = Integer.parseInt(ccid);
		String csdate = map.get("csdate");
		String codate = map.get("codate");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date csdate1 = sdf.parse(csdate);
		// Date codate1 = sdf.parse(codate);
		String cdiscount = map.get("cdiscount");
		String csum = map.get("csum");
		String cfullcut = map.get("cfullcut");
		String cisood = map.get("cisood");
		Integer cisood1 = Integer.parseInt(cisood);
		String cintegration = map.get("cintegration");
		Integer cintegration1 = Integer.parseInt(cintegration);
		String cmoney = map.get("cmoney");
		// Double cmoney1 = new Double(cmoney);
		String cprice = map.get("cprice");
		// Double cprice1 = new Double(cprice);
		String cgoods = map.get("cgoods");
		Integer cgoods1 = Integer.parseInt(cgoods);
		String cimg = map.get("img");
		String ctitle = map.get("ctitle");
		String cinfo = map.get("cinfo");
		String crefund = map.get("crefund");
		String cisrepeat = map.get("cisrepeat");
		Integer cisrepeat1 = Integer.parseInt(cisrepeat);
		String xdprice = map.get("xdprice");
		String xdpcid = map.get("xdpcid");		
		Coupon co = new Coupon();
		co.setCcid(ccid1);
		co.setCrid(crid);
		co.setCsdate(csdate);
		co.setCodate(codate);
		co.setCrange(crange);
		co.setCdiscount(cdiscount);
		co.setCsum(csum);
		co.setCfullcut(cfullcut);
		co.setCisood(cisood1);
		co.setCintegration(cintegration1);
		co.setCmoney(cmoney);
		co.setCprice(cprice);
		co.setCgoods(cgoods1);
		co.setXdpcid(xdpcid);			
		BigDecimal bd=new BigDecimal(xdprice);
		System.err.println(bd);
		co.setXdprice(bd);
		System.out.println(co.getXdprice());
		if (cimg != null) {
			co.setCimg(cimg);
		} else {
			return "coupon/couponissue";
		}

		co.setCinfo(cinfo);
		co.setCtitle(ctitle);
		co.setCrefund(crefund);
		co.setCisrepeat(cisrepeat1);
		co.setUaid(uaid1);
		co.setCnum(rnumber1);
		co.setCstore(rnumber1);
		// String ctotal = map.get("ctotal");
		// Integer ctotal1 = Integer.parseInt(ctotal);
		couponService.addMessage1(co);
		return "coupon/couponissue";
	}

	@RequiresPermissions("couponissue:upload")
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "obj") String obj, @RequestParam(value = "obj1") String obj1,
			@RequestParam(value = "sid", required = false) String sid,
			@RequestParam(value = "sid1", required = false) String sid1) throws Exception {
		System.out.println(obj.toString());
		System.out.println(obj1.toString());
		String cimg1 = "E:\\项目\\ims\\src\\main\\webapp\\upload\\image\\coupon";
		String fileName = file.getOriginalFilename();// 获取文件名加后缀
		String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
		fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
		File file2 = new File(cimg1 + "/");
		File targetFile = new File(file2, fileName);
		file.transferTo(targetFile);
		return targetFile.toString();
	}
	
	@RequiresPermissions("couponissue:finds")
	@RequestMapping("/finds")
	@ResponseBody
	public List<ProductClass> finds(){
		return productClassService.finds();		
	}
}
