package com.pydyun.ims.controller.wxcontroller;

import com.pydyun.ims.model.WxVoucherResponse;
import com.pydyun.ims.service.wxservice.WxVoucherService;
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
 * @ClassName: WxVoucherController
 * @Description: TODO(微信部分, 个人中心代金券)
 * @date 2018年8月8日 上午10:41:42
 */
@RestController
@RequestMapping("/wxvoucher")
public class WxVoucherController
{

    @Resource
    private WxVoucherService wxVoucherService;

    /**
     * @param urid
     * @return
     * @Title: findVoucherByUrid
     * @Description: TODO(代金券有效)
     */
    @RequestMapping("/findVoucherByUrid")
    public List<WxVoucherResponse> findVoucherByUrid(Integer urid) {


        return DataProcessing(wxVoucherService.findVoucherByUrid(urid));

    }

    /**
     * @param urid
     * @return
     * @Title: findVoucherInvalidByUrid
     * @Description: TODO(代金券无效)
     */
    @RequestMapping("/findVoucherInvalidByUrid")
    public List<WxVoucherResponse> findVoucherInvalidByUrid(
            Integer urid) {


        return DataProcessing(wxVoucherService.findVoucherInvalidByUrid(urid));

    }


    private List<WxVoucherResponse> DataProcessing(List<WxVoucherResponse> wxVoucherResponses) {

        /**
         * @Title: DataProcessing
         * @Description: TODO(这里用一句话描述这个方法的作用)
         * @param: [wxVoucherResponses]
         * @return:java.util.List<com.pydyun.ims.model.WxVoucherResponse>
         * @Date: 2018/8/30 13:00
         */
        for (WxVoucherResponse wxVoucher : wxVoucherResponses) {
            if (wxVoucher.getVrange().contains("s:")) {
                wxVoucher.setVrange("单店");
            }
            if (wxVoucher.getVrange().contains("all")) {
                wxVoucher.setVrange("全站");
            }
            if (wxVoucher.getVrange().contains("p:")) {
                wxVoucher.setVrange("品牌");
            }


        }

        return wxVoucherResponses;
    }
}
