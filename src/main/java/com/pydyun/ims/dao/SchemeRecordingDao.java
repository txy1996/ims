package com.pydyun.ims.dao;

import com.pydyun.ims.model.SchemeRecording;
import com.pydyun.ims.model.SchemeRecordingRequest;
import com.pydyun.ims.model.SchemeRecordingResponse;

import java.util.List;

/**
 * FileName: SchemeRecordingDao
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:26
 * Description: TODO(方案记录表)
 *
 * @since 1.0.0
 */
public interface SchemeRecordingDao
{

     /**
       * @Title:
       * @Description: TODO(新增方案记录)
       * @param: 
       * @return:
       * @Date: 2018/10/16 9:53
      */
     
    Integer saveSchemeRecording(SchemeRecording schemeRecording);

    List<SchemeRecordingResponse> findSchemeRecording(SchemeRecordingRequest request);

    Integer updateSchemeRecording(SchemeRecordingRequest request);



}
