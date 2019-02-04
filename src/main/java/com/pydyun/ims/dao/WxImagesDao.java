package com.pydyun.ims.dao;

import java.util.List;


import com.pydyun.ims.model.WxImages;

public interface WxImagesDao {

	List<WxImages> findimg(Integer id);
//	List<WxImages> findimg(@Param(value = "ids") List<String> ids);
}
