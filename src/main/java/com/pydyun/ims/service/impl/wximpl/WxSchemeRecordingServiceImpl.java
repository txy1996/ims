package com.pydyun.ims.service.impl.wximpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.WxSchemeRecordingDao;
import com.pydyun.ims.model.WxSchemeRecording;
import com.pydyun.ims.model.WxSchemeRecordingResponse;
import com.pydyun.ims.service.wxservice.WxSchemeRecordingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: WxSchemeRecordingServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/10/16 10:09
 * Description: TODO(微信端方案记录服务类)
 *
 * @since 1.0.0
 */
@Service
public class WxSchemeRecordingServiceImpl implements WxSchemeRecordingService
{

    @Resource
    private WxSchemeRecordingDao wxSchemeRecordingDao;

    @Override
    public Integer saveWxSchemeRecording(WxSchemeRecording wxSchemeRecording) {
        WxSchemeRecording recording = new WxSchemeRecording();
        recording = wxSchemeRecordingDao.getWxSchemeRecording(wxSchemeRecording);
        if (recording != null) {
            return null;
        }
        return wxSchemeRecordingDao.saveWxSchemeRecording(wxSchemeRecording);
    }

    @Override
    public PageInfo<WxSchemeRecordingResponse> findWxSchemeRecording(Integer pageNum, Integer pageSize, WxSchemeRecording wxSchemeRecording) {
        PageHelper.startPage(pageNum, pageSize);
        List<WxSchemeRecordingResponse> list = wxSchemeRecordingDao.findWxSchemeRecording(wxSchemeRecording);
        return new PageInfo<>(list);
    }

    @Override
    public WxSchemeRecording getWxSchemeRecording(WxSchemeRecording wxSchemeRecording) {
        return wxSchemeRecordingDao.getWxSchemeRecording(wxSchemeRecording);
    }
}
