package com.pydyun.ims.controller.wxcontroller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydyun.ims.model.Scheme;
import com.pydyun.ims.model.WxUserCart;
import com.pydyun.ims.model.WxUserCartResponse;
import com.pydyun.ims.service.wxservice.WxUserCartService;
import com.pydyun.ims.util.WxProgram;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * FileName: WxUserCartController
 * Author:   tangxiaoyu
 * Date:     2018/8/27 9:33
 * Description: TODO(微信:购物车)
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/wxUserCart")
public class WxUserCartController
{
    @Resource
    private WxUserCartService wxUserCartService;

    @RequestMapping("/saveWxUserCart")
    public WxUserCart saveWxUserCart(WxUserCart wxUserCart)throws Exception {
        return wxUserCartService.saveWxUserCart(wxUserCart);
    }

    @RequestMapping("/updateWxUserCart")
    public Integer updateWxUserCart(WxUserCart wxUserCart) {
        return wxUserCartService.updateWxUserCart(wxUserCart);
    }

    @RequestMapping("/updateWxUserCartByUidAllStatus")
    public Integer updateWxUserCartByUidAllStatus(Integer uid, Integer status) {

        return wxUserCartService.updateWxUserCartByUidAllStatus(uid, status);

    }

    @RequestMapping("/deleteWxUserCart")
    public Integer deleteWxUserCart(String ids) {

        Gson gson = new Gson();
        List<Integer> list = gson.fromJson(ids, new TypeToken<List<Integer>>()
        {
        }.getType());

        return wxUserCartService.deleteWxUserCart(list);

    }

    @RequestMapping("/findWxUserCart")
    public PageInfo<WxUserCartResponse> findWxUserCart(Integer pageNum, Integer pageSize,
                                                       WxUserCart wxUserCart) {

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageInfo<WxUserCartResponse> wxUserCartResponsePageInfo = wxUserCartService.findWxUserCart(pageNum, pageSize, wxUserCart);

        return wxUserCartResponsePageInfo;

    }

}
