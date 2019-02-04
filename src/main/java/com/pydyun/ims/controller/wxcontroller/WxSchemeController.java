package com.pydyun.ims.controller.wxcontroller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxAssessImage;
import com.pydyun.ims.model.WxScheme;
import com.pydyun.ims.model.WxSchemeResponse;
import com.pydyun.ims.service.wxservice.WxSchemeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * FileName: WxSchemeController
 * Author:   tangxiaoyu
 * Date:     2018/9/29 11:23
 * Description: TODO(微信:方案)
 *
 * @since 1.0.0
 */
@Controller
@RequestMapping("/wxScheme")
public class WxSchemeController
{
    @Resource
    private WxSchemeService wxSchemeService;

    @RequestMapping("/findWxSchemeAll")
    @ResponseBody
    public PageInfo<WxSchemeResponse> findWxSchemeAll(Integer pageNum, Integer pageSize, WxScheme wxScheme) {

        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 3: pageSize;
        PageInfo<WxSchemeResponse> wxSchemeResponsePageInfo = wxSchemeService.findWxSchemeAll(pageNum, pageSize, wxScheme);
        return wxSchemeResponsePageInfo;

    }

}
