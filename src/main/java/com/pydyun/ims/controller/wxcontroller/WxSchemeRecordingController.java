package com.pydyun.ims.controller.wxcontroller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxSchemeRecording;
import com.pydyun.ims.model.WxSchemeRecordingResponse;
import com.pydyun.ims.service.wxservice.WxSchemeRecordingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: WxSchemeRecordingController
 * Author:   tangxiaoyu
 * Date:     2018/10/16 10:11
 * Description: TODO(微信方案记录表)
 *
 * @since 1.0.0
 */
@RestController
@RequestMapping("/wxSchemeRecording")
public class WxSchemeRecordingController
{

    @Resource
    private WxSchemeRecordingService wxSchemeRecordingService;

    @RequestMapping("/saveWxSchemeRecording")
    public Integer saveWxSchemeRecording(WxSchemeRecording wxSchemeRecording) {
        return wxSchemeRecordingService.saveWxSchemeRecording(wxSchemeRecording);

    }

    @RequestMapping("/findWxSchemeRecording")
    public PageInfo<WxSchemeRecordingResponse> findWxSchemeRecording(Integer pageNum, Integer pageSize, WxSchemeRecording wxSchemeRecording) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageInfo<WxSchemeRecordingResponse> recordingResponsePageInfo = wxSchemeRecordingService.findWxSchemeRecording(pageNum, pageSize, wxSchemeRecording);
        return recordingResponsePageInfo;

    }

    @RequestMapping("/getWxSchemeRecording")
    public WxSchemeRecording getWxSchemeRecording(WxSchemeRecording wxSchemeRecording) {
        return wxSchemeRecordingService.getWxSchemeRecording(wxSchemeRecording);

    }
}
