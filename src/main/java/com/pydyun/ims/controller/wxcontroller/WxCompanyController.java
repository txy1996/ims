package com.pydyun.ims.controller.wxcontroller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.model.WxCompany;
import com.pydyun.ims.model.WxUserAndPosition;
import com.pydyun.ims.service.wxservice.WxCompanyService;
import com.pydyun.ims.service.wxservice.WxUserAndPositionService;

/**
 * @author tangxiaoyu
 * @ClassName: WxCompanyController
 * @Description: TODO(微信发票管理)
 * @date 2018年8月13日 上午10:56:51
 */

@Controller
@RequestMapping("/wxCompany")
public class WxCompanyController
{

    @Resource
    private WxCompanyService wxCompanyService;

    @Resource
    private WxUserAndPositionService WxUserAndPositionService;

    @RequestMapping("/saveWxCompany")
    @ResponseBody
    public WxCompany saveWxCompany(WxCompany company, Integer urid) {


        int cid = wxCompanyService.saveWxCompany(company);
        WxUserAndPosition userAndPosition = new WxUserAndPosition();
        userAndPosition.setCid(cid);
        userAndPosition.setUrid(urid);
        userAndPosition.setUpsort(0);
        WxUserAndPositionService.saveWxUserAndPosition(userAndPosition);
        return company;
    }

    @RequestMapping("/findWxCompany")
    @ResponseBody
    public List<WxCompany> findWxCompany(Integer urid) {


        return wxCompanyService.findWxCompany(urid);
    }

    @RequestMapping("/deleteWxCompany")
    @ResponseBody
    public Integer deleteWxCompany(Integer cid) {


        return wxCompanyService.deleteWxCompany(cid);
    }

    @RequestMapping("/updateWxCompany")
    @ResponseBody
    public Integer updateWxCompany(WxCompany company) {

       
        return wxCompanyService.updateWxCompany(company);
    }

}
