package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.GuestBook;
import com.pydyun.ims.model.GuestBookResponse;
import com.pydyun.ims.service.GuestBookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestBookController
{
    @Resource
    private GuestBookService guestBookService;

    @RequiresPermissions("guest:list")
    @RequestMapping("/list")
    public ModelAndView selectPage(Integer pageNum, Integer pageSize, String status) {

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
        String string = status;
        if (status == null) {
            string = "all";
        }
        PageInfo<GuestBookResponse> list = guestBookService.selectPage(pageNum, pageSize, string);
        ModelAndView mv = new ModelAndView("sett/guest-list");
        mv.addObject("guest", list);
        return mv;

    }

    @RequestMapping("/saveGuestBook")
    @ResponseBody
    public GuestBook saveGuestBook(GuestBook guestBook) {


        return guestBookService.saveGuestBook(guestBook);
    }

    @RequestMapping("/getGuestBookDetails")
    @ResponseBody
    public List<GuestBook> getGuestBookDetails(GuestBook guestBook) {
        return guestBookService.getGuestBookDetails(guestBook);
    }
    @RequiresPermissions("guest:delete")
    @RequestMapping("/delete")
    @ResponseBody
    public Integer deleteGuestBook(String ids) {

        return guestBookService.deleteGuestBook(ids);
    }
}
