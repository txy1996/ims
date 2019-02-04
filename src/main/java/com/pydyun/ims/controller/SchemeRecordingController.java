package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.SchemeRecording;
import com.pydyun.ims.model.SchemeRecordingRequest;
import com.pydyun.ims.model.SchemeRecordingResponse;
import com.pydyun.ims.service.SchemeRecordingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * FileName: SchemeRecordingController
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:49
 * Description: TODO(方案记录表服务层)
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/schemeRecording")
public class SchemeRecordingController
{

    @Resource
    private SchemeRecordingService schemeRecordingService;

    @RequestMapping("/save")
    public Integer saveSchemeRecording(SchemeRecording schemeRecording) {
        /**
         * @Title: saveSchemeRecording
         * @Description: TODO(新增方案记录)
         * @param: [schemeRecording]
         * @return:java.lang.Integer
         * @Date: 2018/10/16 9:58
         */

        return schemeRecordingService.saveSchemeRecording(schemeRecording);
    }

    @RequiresPermissions("schemeRecording:list")
    @RequestMapping("/list")
    public ModelAndView findSchemeRecording(Integer pageNum, Integer pageSize, SchemeRecordingRequest request) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 8 : pageSize;
//        if (request.getStatus() == null) {
//            request.setStatus(2);
//        }
        PageInfo<SchemeRecordingResponse> responsePageInfo = schemeRecordingService.findSchemeRecording(pageNum, pageSize, request);
        ModelAndView mv = new ModelAndView("schemeRecording/schemeRecording");
        mv.addObject("list", responsePageInfo);
//        mv.addObject("request", request);
        return mv;
    }

    @RequestMapping("/updateSchemeRecording")
    public Integer updateSchemeRecording(SchemeRecordingRequest request) {

        return schemeRecordingService.updateSchemeRecording(request);
    }
}
