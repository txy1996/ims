package com.pydyun.ims.controller.wxcontroller;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pydyun.ims.model.WxIntentorder;
import com.pydyun.ims.service.Scheme_classService;
import com.pydyun.ims.service.wxservice.WxIntentorderService;
import com.pydyun.ims.service.wxservice.WxProductClassService;
import com.pydyun.ims.util.WxProgram;

/**
 * wx提交意向订单
 * @author fy
 *
 */
@Controller
@RequestMapping("/WxIntentorder")
public class WxIntentorderController {
	@Resource
	WxIntentorderService wxIntentorderService;
	@Resource
	Scheme_classService scheme_classService;
	@Resource
	WxProductClassService wxProductClassService;
	
	/**
	 * 新增意向订单
	 * @param req
	 * @param res
	 * @param wxIntentorder
	 * @param sign
	 * @throws IOException
	 */
	@RequestMapping("/newIntentionOrder")
	public void newIntentionOrder(HttpServletRequest req, HttpServletResponse res,WxIntentorder wxIntentorder,String sign)
			throws IOException {
		WxProgram.main(req, res);
		Integer scid = null;
		if(sign != null){
			if(sign == "1" || sign.equals("1")){
				scid = scheme_classService.findscid(wxIntentorder.getFirstPerson());
				wxIntentorder.setTreat(0);
			}else if(sign == "0" || sign.equals("0")){
				scid = wxProductClassService.findaddress(null,wxIntentorder.getNeedchoise()).getId();
				wxIntentorder.setTreat(1);
			}
			wxIntentorder.setScid(scid);
			wxIntentorder.setState(0);
		}
		boolean boo;
		boo = wxIntentorderService.insertIntentionOrder(wxIntentorder);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(boo));
		wt.flush();
	}
	
	@RequestMapping("/queryCustomization")
	public void queryCustomization(HttpServletRequest req, HttpServletResponse res,Integer urid,Integer pageNum,Integer pageSize)
			throws IOException {
		WxProgram.main(req, res);
		pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 6 : pageSize;
        PageInfo<WxIntentorder> list = wxIntentorderService.queryCustomization(urid,pageNum,pageSize);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Writer wt = res.getWriter();
		wt.write(gson.toJson(list));
		wt.flush();
	}
}
