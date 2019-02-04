package com.pydyun.ims.controller.wxcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pydyun.ims.service.wxservice.WxCompanyService;
import com.pydyun.ims.service.wxservice.WxCouponService;
import com.pydyun.ims.service.wxservice.WxVoucherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.service.Goods_userService;
import com.pydyun.ims.service.IntegrationsService;
import com.pydyun.ims.service.wxservice.WxUserLevelService;

/**
 * @author tangxiaoyu
 * @ClassName: WxGuestsController
 * @Description: TODO(微信端前端控制器, 个人中心积分金币)
 * @date 2018年8月7日 上午11:17:03
 */
@Controller
@RequestMapping("/wxguests")
public class WxGuestsController
{

    @Resource
    Goods_userService goods_userService;

    @Resource
    private IntegrationsService integrationsService;

    @Resource
    private WxUserLevelService WxUserLevelService;

    @Resource
    private WxCouponService wxCouponService;

    @Resource
    private WxVoucherService wxVoucherService;

    /**
     * @param request
     * @param response
     * @param id
     * @return
     * @throws Exception
     * @Title: findGoldAndIntegral
     * @Description: TODO(查询用户积分金币等级)
     */
    @RequestMapping("/findGoldAndIntegral")
    @ResponseBody
    public Map<String, Object> findGoldAndIntegral( Integer id)
            throws Exception {
        int golds = goods_userService.seleteNumA(id);
        int integrals = integrationsService.seleteNumA(id);
        String ulname = WxUserLevelService.findUserLevelByIntegrals(integrals);
        Integer coupon = wxCouponService.getCouponCountByUrid(id);
        Integer voucher = wxVoucherService.getVoucherCountByUrid(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("golds", golds);
        map.put("integrals", integrals);
        map.put("ulname", ulname);
        map.put("coupon", coupon);
        map.put("voucher", voucher);
        return map;
    }
}
