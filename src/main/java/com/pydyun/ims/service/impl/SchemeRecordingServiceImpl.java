package com.pydyun.ims.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.SchemeRecordingDao;
import com.pydyun.ims.model.SchemeRecording;
import com.pydyun.ims.model.SchemeRecordingRequest;
import com.pydyun.ims.model.SchemeRecordingResponse;
import com.pydyun.ims.service.SchemeRecordingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: SchemeRecordingServiceImpl
 * Author:   tangxiaoyu
 * Date:     2018/10/16 9:48
 * Description: TODO(方案记录业务层实现类)
 *
 * @since 1.0.0
 */
@Service
public class SchemeRecordingServiceImpl implements SchemeRecordingService
{

    @Resource
    private SchemeRecordingDao schemeRecordingDao;

    @Override
    public Integer saveSchemeRecording(SchemeRecording schemeRecording) {
        /**
         * @Title: saveSchemeRecording
         * @Description: TODO(新增方案记录)
         * @param: [schemeRecording]
         * @return:java.lang.Integer
         * @Date: 2018/10/16 9:54
         */

        return schemeRecordingDao.saveSchemeRecording(schemeRecording);
    }

    @Override
    public PageInfo<SchemeRecordingResponse> findSchemeRecording(Integer pageNum, Integer pageSize, SchemeRecordingRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        List<SchemeRecordingResponse> responses = schemeRecordingDao.findSchemeRecording(request);
        return new PageInfo<>(responses);
    }

    @Override
    public Integer updateSchemeRecording(SchemeRecordingRequest request) {
        return schemeRecordingDao.updateSchemeRecording(request);
    }


}
