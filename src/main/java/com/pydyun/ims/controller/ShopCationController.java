package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.ShopCation;
import com.pydyun.ims.service.ShopCationService;

@Controller
@RequestMapping("/cation")
public class ShopCationController {
	@Resource
	private ShopCationService ShopCationService;

	@RequiresPermissions("cation:list")
	@RequestMapping("/list")
	public ModelAndView showSettMsg(Integer pageNum, Integer pageSize) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<ShopCation> list = ShopCationService.selectshopcation(pageNum,pageSize);		
		List<String> listid = ShopCationService.selectid();//所属分类ID
		List<String> listscname = ShopCationService.listname();//商户分类名
		ModelAndView mv = new ModelAndView("shop/shopcation");
		mv.addObject("list", list);
		mv.addObject("listid", listid);
		mv.addObject("listscname", listscname);
		return mv;
	}

	// id查询
	@RequiresPermissions("cation:list")
	@RequestMapping("/getUser")
	@ResponseBody
	public ShopCation getUser(Integer scid) {
		return ShopCationService.getshop(scid);

	}

	
	@RequiresPermissions("cation:delete")
	@RequestMapping("/delete")
	@ResponseBody
	@Transactional
	public void deleteshop(Integer scid) {		
		deletechild(scid);
		ShopCationService.deleteshop(scid);
		}
	
	public void deletechild(Integer scid){
		List<ShopCation> list = ShopCationService.findscscid(scid);
		if(list!=null && list.size()!=0){
			for(ShopCation sc:list){
				deleteshop(sc.getScid());
			}
		}
	}	
		
		
		
		
	

	// 新增
	@RequiresPermissions("cation:add")
	@RequestMapping("/add")
	@ResponseBody
	public ShopCation add(ShopCation shop) {
		if(shop.getScid()==null||shop.getScid().equals("")){
			shop.setScscid(0);
		}else if(shop.getScid()!=null){
			shop.setScscid(shop.getScid());
		}
		shop.setScid(null);
		shop.setScinfo(shop.getScinfo());
		shop.setScname(shop.getScname());
		ShopCationService.addshop(shop);
		return shop;

	}

	// 更新
	@RequiresPermissions("cation:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(ShopCation shop) {
		ShopCationService.updateshop(shop);
	}
	
	@RequestMapping("/selectname")
    @ResponseBody
    public String selectname(Integer scid)
    {
        return ShopCationService.findscscname(scid);
    }
}
