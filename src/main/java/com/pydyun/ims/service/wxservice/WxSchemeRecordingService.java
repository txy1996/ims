package com.pydyun.ims.service.wxservice;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxSchemeRecording;
import com.pydyun.ims.model.WxSchemeRecordingResponse;

import java.util.List;

/**
 * FileName: WxSchemeRecordingService
 * Author:   tangxiaoyu
 * Date:     2018/10/16 10:08
 * Description: TODO(微信端方案记录)
 *
 * @since 1.0.0
 */
public interface WxSchemeRecordingService
{

     /**
       * @Title:
       * @Description: TODO(新增方案记录)
       * @param: 
       * @return:
       * @Date: 2018/11/5 16:12
      */
    Integer saveWxSchemeRecording(WxSchemeRecording wxSchemeRecording);

     /**
       * @Title:
       * @Description: TODO(分页查询方案记录)
       * @param: 
       * @return:
       * @Date: 2018/11/5 16:14
      */
     
    PageInfo<WxSchemeRecordingResponse> findWxSchemeRecording( Integer pageNum, Integer pageSize,WxSchemeRecording wxSchemeRecording);

    WxSchemeRecording getWxSchemeRecording(WxSchemeRecording wxSchemeRecording);
}
