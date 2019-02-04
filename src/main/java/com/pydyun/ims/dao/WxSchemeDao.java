package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxSchemeResponse;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxScheme;

public interface WxSchemeDao
{
    List<WxScheme> scheme();

    List<WxScheme> findtrain(@Param("task") String task, @Param("spnum") String spnum, @Param("sduration") String sduration, @Param("srange") String srange);

    /*微信:方案列表*/
    List<WxSchemeResponse> findWxSchemeAll(WxScheme  wxScheme);

	List<WxScheme> fscheme(String str);
}
