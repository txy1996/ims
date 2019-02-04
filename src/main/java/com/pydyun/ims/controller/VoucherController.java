package com.pydyun.ims.controller;


import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Voucher;
import com.pydyun.ims.service.VoucherService;

@Controller
@RequestMapping("/voucher")
public class VoucherController {
	@Resource
	private VoucherService vService;
	
	@RequiresPermissions("voucher:list")
	@RequestMapping("/list")
	public ModelAndView toVoucher(Integer pageNum,Integer pageSize) throws Exception{
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		PageInfo<Voucher> voucher = vService.toMessage(pageNum, pageSize);
//		List<String> listCname = vService.getVcname();
		ModelAndView mv = new ModelAndView("voucher/voucher-list");
		mv.addObject("voucher",voucher);
//		mv.addObject("listCname",listCname);
		return mv;
		
	}
	@RequiresPermissions("voucher:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteMessage(String id) {
		vService.deltVoucher(Integer.valueOf(id));
	}
	
	@RequiresPermissions("voucher:list")
	@RequestMapping("/getVoucher")
	@ResponseBody
	public Voucher getMessage(String id) {
		Voucher voucher = vService.findOnemsg(Integer.valueOf(id));
		return voucher;
	}
	
	@RequiresPermissions("voucher:add")
	@RequestMapping("/add")
	@ResponseBody
	public Voucher addMessage(int vcid,String vrange,String vmoney,String vcost,
			String vprice, String vsdate,String vodate,Integer visood,Integer vgoods,Integer vintegration,String vimg,
			String vtitle,String vinfo,String vrefund,String uaid) {
		Voucher voucher = new Voucher();
		voucher.setVcid(vcid);
		voucher.setVrange(vrange);
		voucher.setVmoney(vmoney);
		voucher.setVcost(vcost);
		voucher.setVprice(vprice);
		voucher.setVsdate(vsdate);
		voucher.setVodate(vodate);
		voucher.setVisood(visood);
		voucher.setVgoods(vgoods);
		voucher.setVintegration(vintegration);
		voucher.setVimg(vimg);
		voucher.setVtitle(vtitle);
		voucher.setVinfo(vinfo);
		voucher.setVrefund(vrefund);
		voucher.setUaid(uaid);
		vService.addMessage(voucher);
		return voucher;
	}
	
	@RequiresPermissions("voucher:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateMessag(Voucher voucher) {
		vService.updateMessage(voucher);
	}
}
