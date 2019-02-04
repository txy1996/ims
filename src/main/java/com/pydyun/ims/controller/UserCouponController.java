package com.pydyun.ims.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Shop;
import com.pydyun.ims.model.ShopBrand;
import com.pydyun.ims.model.U_c_log;
import com.pydyun.ims.service.CouponService;
import com.pydyun.ims.service.ShopBrandService;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.UserCouponService;
import com.pydyun.ims.service.UserService;

@Controller
@RequestMapping("/usercoupon")
public class UserCouponController {
	@Resource
	UserCouponService userCouponService;
	@Resource
	ShopBrandService sb;
	@Resource
	UserService userService;
	@Resource
	CouponService couponService;
	@Resource
	ShopService ss;
	
	@RequiresPermissions("usercoupon:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum,Integer pageSize,Integer urid,String starttime,String endtime,String name,String ucstate,HttpServletRequest request) throws Exception{
//		userBuyCoupon.buycoupon(1, 3, 386, request);
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		Integer a=null;
		if(ucstate!=null){
			if(ucstate.equals("")||ucstate.equals("lala")){
				ucstate="-1";
				a=Integer.parseInt(ucstate);
				a=null;
			}else{
				a=Integer.parseInt(ucstate);
			}
		}else{
			ucstate="-1";
			a=Integer.parseInt(ucstate);
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
		PageInfo<U_c_log> page = userCouponService.findall(pageNum, pageSize, urid,starttime,endtime,a);
//		if(page.getList()!=null && page.getList().size()!=0){
			List<U_c_log> list = page.getList();
			for(U_c_log cv : list){
				Shop s = new Shop();
				Integer sid2 = cv.getSid();
				String sname=null;
				if(sid2!=null){
					sname = ss.getsname(cv.getSid());
				}				
				s.setSname(sname);
				cv.setS(s);
//				String vrange = uv.getVou().getVrange();
				if(cv.getCou()!=null){
					if(cv.getCou().getCrange()!=null&&cv.getCou().getCrange().charAt(0)=='p'){
						String bid=cv.getCou().getCrange().substring(cv.getCou().getCrange().indexOf(":")+1);
						ShopBrand shopb = sb.selectshop2(Integer.parseInt(bid));
						if(shopb!=null){
							cv.setA(shopb.getBname());
						}
					}else if(cv.getCou().getCrange()!=null&&cv.getCou().getCrange().charAt(0)=='s'){
						String sid=cv.getCou().getCrange().substring(cv.getCou().getCrange().indexOf(":")+1);
						String getsname = ss.getsname(Integer.parseInt(sid));
						cv.setA(getsname);
					}else if(cv.getCou().getCrange()!=null&&cv.getCou().getCrange().charAt(0)=='a'){
						cv.setA("全站通用");
					}
				}else if(cv.getCou()==null||cv.getCou().equals("")){
					cv.setCou(null);
				}
//			}
		}				
		String findname = userService.findname(urid);
		List<U_c_log> list2 = userCouponService.select();
		ModelAndView mv = new ModelAndView("coupon/usercoupon");
		mv.addObject("list", page);
		mv.addObject("list2", list2);
		mv.addObject("findname", findname);
		mv.addObject("urid1", urid);
		return mv;
	}
	
	@RequiresPermissions("usercoupon:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Integer uclid,String ucinfo){
		Date date= new Date();
		userCouponService.update(uclid,ucinfo,date);
		
	}
	
	@RequiresPermissions("usercoupon:update1")
    @RequestMapping("/update1")
    @ResponseBody
    public void update1(Integer uclid,String ucinfo,String time,Integer cid,Integer state){
		if(state!=0){
			Integer aaa=Integer.parseInt(time);
			userCouponService.update1(uclid,ucinfo);
			couponService.update1(cid,aaa);
		}
	}
}
