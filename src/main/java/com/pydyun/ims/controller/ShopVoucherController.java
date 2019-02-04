package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Voucher;
import com.pydyun.ims.service.ShopService;
import com.pydyun.ims.service.VoucherService;

@Controller
@RequestMapping("/shopvoucher")
public class ShopVoucherController {

	@Resource
	VoucherService voucherService;
	@Resource
	ShopService ss;
	
	@RequiresPermissions("shopvoucher:list")
	@RequestMapping("/list")
	public ModelAndView select(Integer pageNum,Integer pageSize,Integer sid,String starttime,String endtime,String name,String vstore){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		if(starttime!=null &&endtime!=null){
			if(starttime==""||starttime.equals("")){
				starttime=null;
			}
			if(endtime==""||endtime.equals("")){
				endtime=null;
			}
		}
		Integer a=null,b=null;
		if(vstore!=null){
			if(vstore==""||vstore.equals("")){
				a=null;
				b=null;
			}else{
			String[]  str= vstore.split("~");
			a=Integer.parseInt(str[0]);
			b=Integer.parseInt(str[1]);
			}
		}
		String vrange="s:"+sid;
		PageInfo<Voucher> list = voucherService.findall1(pageNum, pageSize, vrange,starttime,endtime,a,b);
		String getsname = ss.getsname(sid);
		ModelAndView mv = new ModelAndView("voucher/shopvoucher");
		mv.addObject("list",list);
		mv.addObject("findname",getsname);
		mv.addObject("sid",sid);
		return mv;
	}
	
	@RequiresPermissions("shopvoucher:update")
    @RequestMapping("/update")
    @ResponseBody
    public void update(Voucher vo){
		voucherService.update1(vo);
		
	}
			
	@RequiresPermissions("shopvoucher:list")
    @RequestMapping("/getshopvoucher")
    @ResponseBody
    public Voucher getshopvoucher(Integer vid)
    {
		Voucher vo = voucherService.getmessage1(vid);
				return vo;
    }
	
	@RequiresPermissions("shopvoucher:deleteshopvoucher")
    @RequestMapping("/deleteshopvoucher")
    @ResponseBody
    public void deleteshopvoucher(Integer vid)
    {
		voucherService.deleteshopvoucher(vid);
    }
}
