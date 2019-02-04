package com.pydyun.ims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Company;
import com.pydyun.ims.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Resource
	private CompanyService companyService;
	@RequiresPermissions("company:list")
	@RequestMapping("/list")
	public ModelAndView toCompany(Integer pageNum,Integer pageSize,String cidentify,String ccode,String caccount
			,HttpServletRequest request) throws Exception{
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		cidentify = (cidentify == null || "".equals(cidentify))?null:cidentify;
		ccode = (ccode == null || "".equals(ccode))?null:ccode;
		caccount = (caccount == null || "".equals(caccount))?null:caccount;
		String falg = cidentify;String falg1 = ccode;String falg2 = caccount;
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("cidentify",cidentify);
		map.put("ccode",ccode);
		map.put("caccount", caccount);
		PageInfo<Company> company =companyService.queryAll(pageNum, pageSize, map);
		List<String> zone = companyService.querzone();
		ModelAndView mv = new ModelAndView("company/company-list");
		mv.addObject("company",company);
		mv.addObject("zone", zone);
		request.setAttribute("falg", falg);
		request.setAttribute("falg1", falg1);
		request.setAttribute("falg2", falg2);
		return mv;
	}
	@RequiresPermissions("company:add")
	@RequestMapping("/add")
	@ResponseBody
	public Company addCompany(Integer zid,String cname,Integer cgeneral_taxpayer,String cidentify,String ccode,String caddress,String cbank,String caccount,
			String ctel,String cinfo) {
		Company company = new Company();
		company.setZid(zid);
		company.setCname(cname);
		company.setCgeneral_taxpayer(cgeneral_taxpayer);
		company.setCidentify(cidentify);
		company.setCcode(ccode);
		company.setCaddress(caddress);
		company.setCbank(cbank);
		company.setCaccount(caccount);
		company.setCtel(ctel);
		company.setCinfo(cinfo);
		companyService.addCompany(company);
		return company;
	}
	@RequiresPermissions("company:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteCompany(int id) {
		companyService.deleteCompany(id);
	}
	@RequiresPermissions("company:list")
	@RequestMapping("/getMessage")
	@ResponseBody
	public Company findMessage(int  id) {
		Company company = companyService.queryById(id);
		return company;
	}
	@RequiresPermissions("company:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateCompany(Company company) {
		companyService.updateCompany(company);
	}
	@RequiresPermissions("company:list")
	@RequestMapping("/selectAllZName")
	@ResponseBody
	public List<Company> selectAllZName() {
		/*ModelAndView mv = new ModelAndView("company/company-list");
		List<Company> company = companyService.selectAllZName();
		mv.addObject("companys",company);*/
		return companyService.selectAllZName();
	}
}
