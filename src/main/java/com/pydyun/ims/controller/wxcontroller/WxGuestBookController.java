package com.pydyun.ims.controller.wxcontroller;

import com.pydyun.ims.model.WxGuestBook;
import com.pydyun.ims.model.WxOrders;
import com.pydyun.ims.model.WxOrdersResponseList;
import com.pydyun.ims.service.wxservice.WxGuestBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * FileName: WxGuestBookController
 * Author:   tangxiaoyu
 * Date:     2018/8/28 9:35
 * Description: TODO(微信:用户留言)
 *
 * @since 1.0.0
 */
@Controller
@RequestMapping("/wxGuestBook")
public class WxGuestBookController
{

    @Resource
    private WxGuestBookService wxGuestBookService;

    @RequestMapping("/saveWxGuestBook")
    @ResponseBody
    public WxGuestBook saveWxGuestBook(WxGuestBook wxGuestBook) {


        return wxGuestBookService.saveWxGuestBook(wxGuestBook);

    }

    @RequestMapping("/findWxGuestBookUserMessage")
    @ResponseBody
    public List<WxGuestBook> findWxGuestBookUserMessage(WxGuestBook wxGuestBook) {

        return wxGuestBookService.findWxGuestBookUserMessage(wxGuestBook);

    }

    @RequestMapping("/findWxGuestBookSystemReply")
    @ResponseBody
    public List<WxGuestBook> findWxGuestBookSystemReply(WxGuestBook wxGuestBook) {


        return wxGuestBookService.findWxGuestBookSystemReply(wxGuestBook);

    }


    @RequestMapping("/deleteWxGuestBook")
    @ResponseBody
    public Integer deleteWxGuestBook(String gbids) {


        return wxGuestBookService.deleteWxGuestBook(gbids);

    }

}
