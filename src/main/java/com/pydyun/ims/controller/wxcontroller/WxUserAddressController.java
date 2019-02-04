package com.pydyun.ims.controller.wxcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.model.WxUserAddress;
import com.pydyun.ims.service.wxservice.WxUserAddressService;

/**
 * @author tangxiaoyu
 * @ClassName: WxUserAddressController
 * @Description: TODO(微信 : 用户地址管理)
 * @date 2018年8月10日 下午3:15:14
 */
@Controller
@RequestMapping("/wxUserAddress")
public class WxUserAddressController
{
    @Resource
    private WxUserAddressService wxUserAddressService;

    /**
     * @param address
     * @return
     * @Title: findWxUserAddress
     * @Description: TODO(查询用户地址)
     */
    @RequestMapping("/findWxUserAddress")
    @ResponseBody
    public List<WxUserAddress> findWxUserAddress(WxUserAddress address) {


        return wxUserAddressService.findWxUserAddress(address);

    }

    /**
     * @Title: getWxUserDefaultAddress
     * @Description: TODO(查询默认地址)
     * @param: [request, response, address]
     * @return:java.util.List<com.pydyun.ims.model.WxUserAddress>
     * @Date: 2018/8/30 18:04
     */
    @RequestMapping("/getWxUserDefaultAddress")
    @ResponseBody
    public WxUserAddress getWxUserDefaultAddress(
            WxUserAddress address) {


        return wxUserAddressService.getWxUserDefaultAddress(address);

    }

    /**
     * @param uaid
     * @return
     * @Title: deleteWxUserAddress
     * @Description: TODO(删除用户地址)
     */
    @RequestMapping("/deleteWxUserAddress")
    @ResponseBody
    public Integer deleteWxUserAddress(Integer uaid) {


        return wxUserAddressService.deleteWxUserAddress(uaid);

    }

    /**
     * @param address
     * @return
     * @Title: updateWxUserAddress
     * @Description: TODO(修改用户地址)
     */
    @RequestMapping("/updateWxUserAddress")
    @ResponseBody
    @Transactional
    public Integer updateWxUserAddress(WxUserAddress address) {
    	wxUserAddressService.updateuaone(address.getUauid());
        return wxUserAddressService.updateWxUserAddress(address);

    }

    /**
     * @param address
     * @return
     * @Title: saveWxUserAddress
     * @Description: TODO(新增用户地址)
     */
    @RequestMapping("/saveWxUserAddress")
    @ResponseBody
    public WxUserAddress saveWxUserAddress(WxUserAddress address) {


        wxUserAddressService.saveWxUserAddress(address);
        return address;

    }

}
