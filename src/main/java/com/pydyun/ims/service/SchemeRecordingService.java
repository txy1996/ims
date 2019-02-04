package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.SchemeRecording;
import com.pydyun.ims.model.SchemeRecordingRequest;
import com.pydyun.ims.model.SchemeRecordingResponse;

import java.util.List;

/**
 * FileName: SchemeRecordingService
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:46
 * Description: TODO(方案记录业务层接口)
 *
 * @since 1.0.0
 */
public interface SchemeRecordingService
{
    Integer saveSchemeRecording(SchemeRecording schemeRecording);

    PageInfo<SchemeRecordingResponse> findSchemeRecording(Integer pageNum, Integer pageSize, SchemeRecordingRequest request);

    Integer updateSchemeRecording(SchemeRecordingRequest request);

}
