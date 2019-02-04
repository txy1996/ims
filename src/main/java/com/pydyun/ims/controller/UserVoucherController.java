package com.pydyun.ims.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.model.U_v_log;
import com.pydyun.ims.service.ShopBrandService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.UserService;
import com.pydyun.ims.service.UserVoucherService;
import com.pydyun.ims.service.VoucherService;

@Controller
@RequestMapping("/uservoucher")
public class UserVoucherController {
	@Resource
	UserVoucherService userVoucherService;
	@Resource
	ShopBrandService sb;
	@Resource
	UserService userService;
	@Resource
	VoucherService voucherService;
	@Resource
	ShopService ss;
	
	@RequiresPermissions("uservoucher:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum,Integer pageSize,Integer urid,String starttime,String endtime,String name,String uvlstate){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		Integer a=null;
		if(uvlstate!=null){
			if(uvlstate.equals("")||uvlstate.equals("lala")){
				uvlstate="-1";
				a=Integer.parseInt(uvlstate);
				a=null;
			}else{
				a=Integer.parseInt(uvlstate);
			}
		}else{
			uvlstate="-1";
			a=Integer.parseInt(uvlstate);
			a=null;
		}
		if(name!=null){
			urid=userService.findid(name);
		}
		if(starttime!=null &&endtime!=null){
			if(starttime==""||starttime.equals("")){
				starttime=null;
			}
			if(endtime==""||endtime.equals("")){
				endtime=null;
			}
		}
		PageInfo<U_v_log> page = userVoucherService.findall(pageNum, pageSize, urid,starttime,endtime,a);
//		if(page.getList()!=null && page.getList().size()!=0){
		List<U_v_log> list = page.getList();
		for(U_v_log uv : list){
			Shop s = new Shop();
			Integer sid2 = uv.getSid();
			String sname=null;
			if(sid2!=null){
				sname = ss.getsname(sid2);
			}
			s.setSname(sname);
			uv.setS(s);
			if(uv.getVou()!=null){
				if(uv.getVou().getVrange()!=null&&uv.getVou().getVrange().charAt(0)=='p'){
					String bid=uv.getVou().getVrange().substring(uv.getVou().getVrange().indexOf(":")+1);
					ShopBrand shopb = sb.selectshop2(Integer.parseInt(bid));
					
					if(shopb!=null){
						uv.setA(shopb.getBname());
					}
				}else if(uv.getVou().getVrange()!=null&&uv.getVou().getVrange().charAt(0)=='s'){
					String sid=uv.getVou().getVrange().substring(uv.getVou().getVrange().indexOf(":")+1);
					String getsname = ss.getsname(Integer.parseInt(sid));
					uv.setA(getsname);
				}else if(uv.getVou().getVrange()!=null&&uv.getVou().getVrange().charAt(0)=='a'){
					uv.setA("全站通用");
				}
			}else if(uv.getVou()==null||uv.getVou().equals("")){
				uv.setVou(null);
			}
//		}
		}
		String findname = userService.findname(urid);
		List<U_v_log> list2 = userVoucherService.select();
		ModelAndView mv = new ModelAndView("voucher/uservoucher");
		mv.addObject("list", page);
		mv.addObject("list2", list2);
		mv.addObject("findname", findname);
		mv.addObject("urid1", urid);
		return mv;
	}
	
	@RequiresPermissions("uservoucher:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Integer uvlid,String uvinfo){
		Date date= new Date();
		userVoucherService.update(uvlid,uvinfo,date);
	}
	
	@RequiresPermissions("uservoucher:update1")
    @RequestMapping("/update1")
    @ResponseBody
    public void update1(Integer uvlid,String uvinfo,String time,Integer vid,Integer state){
		if(state!=0){
			Integer aaa=Integer.parseInt(time);
			userVoucherService.update1(uvlid,uvinfo);
			voucherService.update(vid,aaa);
		}
	}
}
