package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.WxProductimgDao;
import com.pydyun.ims.model.WxProductimg;
import com.pydyun.ims.service.wxservice.WxProductimgService;

@Service
public class WxProductimgServiceImpl implements WxProductimgService{

	@Resource
	WxProductimgDao wxProductimgDao;
	@Override
	public List<WxProductimg> findimg(String ids) {
		// TODO Auto-generated method stub
		return wxProductimgDao.findimg(ids);
	}

}
