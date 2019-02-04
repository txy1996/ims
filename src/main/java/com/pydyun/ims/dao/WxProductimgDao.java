package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.WxProductimg;

public interface WxProductimgDao
{
    List<WxProductimg> findimg(@Param("ids") String ids);
}
