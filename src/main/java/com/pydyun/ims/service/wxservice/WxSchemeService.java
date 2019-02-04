package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.WxScheme;
import com.pydyun.ims.model.WxSchemeResponse;

public interface WxSchemeService
{

    List<WxScheme> findtrain(String task, String spnum, String sduration, String srange);

    /*微信:方案列表*/
    PageInfo<WxSchemeResponse> findWxSchemeAll(Integer pageNum, Integer pageSize, WxScheme wxScheme);
}
