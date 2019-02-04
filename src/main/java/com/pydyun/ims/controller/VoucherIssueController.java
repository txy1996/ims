package com.pydyun.ims.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.pydyun.ims.model.ProductClass;
import com.pydyun.ims.model.Records;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.model.User;
import com.pydyun.ims.model.Voucher;
import com.pydyun.ims.model.Voucherclass;
import com.pydyun.ims.service.ProductClassService;
import com.pydyun.ims.service.RecordsService;
import com.pydyun.ims.service.ShopBrandService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.UserService;
import com.pydyun.ims.service.VoucherIssueService;
import com.pydyun.ims.service.VoucherService;
import com.pydyun.ims.service.VoucherclassService;

@Controller
@RequestMapping("/voucherissue")
public class VoucherIssueController {
	@Resource
	private VoucherIssueService voucherIssueService;
	@Resource
	private VoucherclassService voucherclassService;
	@Resource
	private UserService userService;
	@Resource
	private VoucherService voucherService;
	@Resource
	private ShopBrandService shopbrandService;
	@Resource
	private ShopService shopService;
	@Resource
	private ProductClassService productClassService;

	@Resource
	private RecordsService recordsService;

	@RequiresPermissions("voucherissue:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum, Integer pageSize, String vrange1, String vcid, String vtitle,
			Integer sid, Integer bid) throws UnsupportedEncodingException {
		List<Voucherclass> list = voucherclassService.getVcname();
		List<User> users = userService.finduser();
		List<ShopBrand> find1 = new ArrayList<>();
		List<Shop> find2 = new ArrayList<>();
		ModelAndView mv = new ModelAndView("voucher/voucherissue");
		if (sid != null) {
			vrange1 = "单店";
			find2 = shopService.findshop1(sid);
			String sname = null;
			for (Shop s : find2) {
				sname = s.getSname();
			}
			mv.addObject("find2", find2);
			mv.addObject("sid", sid);
			mv.addObject("sname", sname);
		} else if (bid != null) {
			vrange1 = "品牌通用";
			find1 = shopbrandService.selectshop1(bid);
			mv.addObject("find1", find1);
			mv.addObject("bid", bid);
		} else if (bid == null && sid == null) {
			if (vrange1 == null) {
				find2 = shopService.findshop();
				mv.addObject("find2", find2);
			} else {
				vrange1 = new String(vrange1.getBytes("iso8859-1"), "utf-8");
				if (vrange1.equals("单店") || vrange1.equals("单店1")) {
					find2 = shopService.findshop();
					mv.addObject("find2", find2);
				} else if (vrange1.equals("品牌通用")) {
					find1 = shopbrandService.selectall();
					mv.addObject("find1", find1);
				}
			}
			mv.addObject("sid", sid);
			mv.addObject("bid", bid);
		}
		if (vcid != null && vtitle != null) {
			vcid = new String(vcid.getBytes("iso8859-1"), "utf-8");
			vtitle = new String(vtitle.getBytes("iso8859-1"), "utf-8");
		}
		
		mv.addObject("list", list);
		mv.addObject("users", users);
		mv.addObject("vrange1", vrange1);
		mv.addObject("vcname", vcid);
		mv.addObject("vtitle", vtitle);
		return mv;
	}

	@RequiresPermissions("voucherissue:add")
	@RequestMapping("/add")
	@ResponseBody
	@Transactional
	public String add(@RequestParam(value = "rowVal", required = false) String rowVal, HttpServletRequest request)
			throws Exception {
		// QRCodeUtil qr=new QRCodeUtil(image);
		// 二维码地址，大小，格式
		// String pathName = QRCodeUtil.generateQRCode("我是一张代金券", 150, 150,
		// "png", "D:\\new.png");
		// 二维码内容
		// String content = QRCodeUtil.parseQRCode(pathName);
		System.out.println(rowVal);
		Map<String, String> map = new Gson().fromJson(rowVal, new TypeToken<HashMap<String, String>>() {
		}.getType());
		Records re = new Records();
		String vrange = map.get("vrange1");
		// System.out.println(map.get("sorpname").toString());
		System.out.println("1234");
		String sorpname = map.get("sorpname");
		if (sorpname == null) {
			sorpname = "";
		}
		String sids = map.get("sids");
		if (sids != null && sorpname.equals("")) {
			sorpname = sids;
		}
		if (vrange == "单店" || vrange == "单店1" || vrange.equals("单店") || vrange.equals("单店1")) {
			vrange = "s:" + sorpname;
		} else if (vrange == "品牌通用" || vrange.equals("品牌通用")) {
			vrange = "p:" + sorpname;
		} else if (vrange == "全站通用" || vrange.equals("全站通用")) {
			sorpname = "";
			vrange = "all" + sorpname;
		}
		Date regdate = new Date();
		// String rnumber = map.get("vamount");
		// Integer rnumber1 = Integer.parseInt(rnumber);
		Integer vorc = 0;
		String uaid = map.get("uaid");
		Integer uaid1 = Integer.parseInt(uaid);
		String vtotal = map.get("vtotal");
		Integer vtotal1 = Integer.parseInt(vtotal);
		String vinfo = map.get("vinfo");
		re.setVrange(vrange);
		re.setRegdate(regdate);
		re.setRnumber(vtotal1);
		re.setVorc(vorc);
		re.setUaid(uaid1);
		re.setInfo(vinfo);
		recordsService.addReVoucher(re);
		Integer vrid = recordsService.findid();
		String vcid = map.get("vcid");
		Integer vcid1 = Integer.parseInt(vcid);
		String vmoney = map.get("vmoney");
		// Double vmoney1 = new Double(vmoney);
		String vcost = map.get("vcost");
		// Double vcost1 = new Double(vcost);
		String vprice = map.get("vprice");
		// Double vprice1 = new Double(vprice);
		String vsdate = map.get("vsdate");
		String vodate = map.get("vodate");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date vsdate1 = sdf.parse(vsdate);
		// Date vodate1 = sdf.parse(vodate);
		String visood = map.get("visood");
		Integer visood1 = Integer.parseInt(visood);
		String vgoods = map.get("vgoods");
		Integer vgoods1 = Integer.parseInt(vgoods);
		String vintegration = map.get("vintegration");
		Integer vintegration1 = Integer.parseInt(vintegration);
		String vtitle = map.get("vtitle");
		String vrefund = map.get("vrefund");
		String vimg = map.get("img");
		String xdprice = map.get("xdprice");
		String xdpcid = map.get("xdpcid");		
			Voucher vo = new Voucher();
			vo.setVcid(vcid1);
			vo.setVrid(vrid);
			vo.setVrange(vrange);
			vo.setVmoney(vmoney);
			vo.setVcost(vcost);
			vo.setVprice(vprice);
			vo.setVsdate(vsdate);
			vo.setVodate(vodate);
			vo.setVisood(visood1);
			vo.setVgoods(vgoods1);
			// 发行总量
			vo.setVnum(vtotal1);
			// 库存
			vo.setVstore(vtotal1);
			vo.setVintegration(vintegration1);
			vo.setXdpcid(xdpcid);			
			BigDecimal bd=new BigDecimal(xdprice);
			System.err.println(bd);
			vo.setXdprice(bd);
			System.out.println(vo.getXdprice());
			if (vimg != null) {
				vo.setVimg(vimg);
			} else {
				return "voucher/voucherissue";
			}
			vo.setVtitle(vtitle);
			vo.setVinfo(vinfo);
			vo.setVrefund(vrefund);
			vo.setUaid(uaid);
		voucherService.addMessage2(vo);
		return "voucher/voucherissue";
	}

	@RequiresPermissions("voucherissue:upload")
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "obj", required = false) String obj,
			@RequestParam(value = "obj1", required = false) String obj1,
			@RequestParam(value = "sid", required = false) String sid,
			@RequestParam(value = "sid1", required = false) String sid1,
			HttpServletRequest request) throws Exception {
		System.out.println(obj.toString());
		System.out.println(obj1.toString()); 
		
		String vimg1 = "E:\\项目\\ims\\src\\main\\webapp\\upload\\image\\voucher";
		//String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/image/voucher";//存储路径
		//System.getProperty("user.dir")+"/src/main/webapp/NileImage/"+filename
		//String property = System.getProperty("java.class.path")+"/src/main/webapp/upload/image/voucher";
		String fileName = file.getOriginalFilename();// 获取文件名加后缀
		String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
		fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
		File file2 = new File(vimg1 + "/");
		File targetFile = new File(file2, fileName);
		file.transferTo(targetFile);
		return targetFile.toString();
	}
	
	@RequiresPermissions("voucherissue:finds")
	@RequestMapping("/finds")
	@ResponseBody
	public List<ProductClass> finds(){
		return productClassService.finds();		
	}
}
