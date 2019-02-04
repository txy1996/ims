package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxAlbumDao;
import com.pydyun.ims.model.WxAlbum;
import com.pydyun.ims.service.wxservice.WxAlbumService;

@Service
public class WxAlbumServiceImpl implements WxAlbumService{
	
	@Resource
	private WxAlbumDao wxalbumdao;

	@Override
	public List<WxAlbum> selectaid(Integer aid) {  
		return wxalbumdao.selectaid(aid);
	}
	
}
