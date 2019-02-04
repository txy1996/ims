package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxLabelDao;
import com.pydyun.ims.model.WxLabel;
import com.pydyun.ims.service.wxservice.WxLabelService;

@Service
public class WxLabelServiceImpl implements WxLabelService{

	@Resource
	WxLabelDao wxdao;
	
	@Override
	public List<WxLabel> findinfo(@Param("ids")List<String> ids) {
		// TODO Auto-generated method stub
		return wxdao.findinfo(ids);
	}

}
