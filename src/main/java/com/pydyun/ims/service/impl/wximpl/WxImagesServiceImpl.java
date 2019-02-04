package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxImagesDao;
import com.pydyun.ims.model.WxImages;
import com.pydyun.ims.service.wxservice.WxImagesService;
@Service
public class WxImagesServiceImpl implements WxImagesService{

	@Resource
	WxImagesDao WxImagesdao;

	@Override
	public List<WxImages> findimg(Integer id) {
		return WxImagesdao.findimg(id);
	}

//	@Override
//	public List<WxImages> findimg(List<String> ids) {
//		return WxImagesdao.findimg(ids);
//	}
}
