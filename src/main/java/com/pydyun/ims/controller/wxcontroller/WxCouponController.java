package com.pydyun.ims.controller.wxcontroller;

import com.pydyun.ims.model.WxCouponResponse;
import com.pydyun.ims.service.wxservice.WxCouponService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author tangxiaoyu
 * @ClassName: WxCouponController
 * @Description: TODO(微信 : 用户优惠券记录)
 * @date 2018年8月8日 下午2:43:23
 */
@RestController
@RequestMapping("/wxcoupon")
public class WxCouponController
{

    @Resource
    private WxCouponService wxCouponService;

    /**
     * @param urid
     * @return
     * @Title: findCouponByUrid
     * @Description: TODO(用户优惠券记录, 有效)
     */
    @RequestMapping("/findCouponByUrid")
    public List<WxCouponResponse> findCouponByUrid(Integer urid) {

        return DataProcessing(wxCouponService.findCouponByUrid(urid));

    }

    /**
     * @param urid
     * @return
     * @Title: findCouponInvalidByUrid
     * @Description: TODO(用户优惠券记录, 无效)
     */
    @RequestMapping("/findCouponInvalidByUrid")
    public List<WxCouponResponse> findCouponInvalidByUrid(Integer urid) {

        return DataProcessing(wxCouponService.findCouponInvalidByUrid(urid));

    }


    private List<WxCouponResponse> DataProcessing(List<WxCouponResponse> wxCouponResponses) {

        /**
         * @Title: DataProcessing
         * @Description: TODO(数据处理)
         * @param: [wxCouponResponses]
         * @return:java.util.List<com.pydyun.ims.model.WxCouponResponse>
         * @Date: 2018/8/30 12:00
         */

        for (WxCouponResponse wxCoupon : wxCouponResponses) {
            if (wxCoupon.getCrange().contains("s:")) {
                wxCoupon.setCrange("单店");
            } else if (wxCoupon.getCrange().contains("all")) {
                wxCoupon.setCrange("全站");
            } else if (wxCoupon.getCrange().contains("p:")) {
                wxCoupon.setCrange("品牌");
            }

            if (wxCoupon.getCdiscount() != null) {
                wxCoupon.setOfferContent(String.valueOf(wxCoupon.getCdiscount()) + "%");
            } else if (wxCoupon.getCsum() != null) {
                wxCoupon.setOfferContent("￥" + String.valueOf(wxCoupon.getCsum()));
            } else if (wxCoupon.getCfullcut() != null) {
                wxCoupon.setOfferContent(wxCoupon.getCfullcut());
            }

        }

        return wxCouponResponses;
    }
}
