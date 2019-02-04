package com.pydyun.ims.dao;

import com.pydyun.ims.model.WxSchemeRecording;
import com.pydyun.ims.model.WxSchemeRecordingResponse;

import java.util.List;

/**
 * FileName: WxSchemeRecordingDao
 * Author:   tangxiaoyu
 * Date:     2018/10/16 10:06
 * Description: TODO(微信端方案记录)
 *
 * @since 1.0.0
 */
public interface WxSchemeRecordingDao
{

    Integer saveWxSchemeRecording(WxSchemeRecording wxSchemeRecording);

   List<WxSchemeRecordingResponse> findWxSchemeRecording(WxSchemeRecording wxSchemeRecording);

    WxSchemeRecording getWxSchemeRecording(WxSchemeRecording wxSchemeRecording);

}
