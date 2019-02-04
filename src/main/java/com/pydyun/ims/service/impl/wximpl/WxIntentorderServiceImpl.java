package com.pydyun.ims.service.impl.wximpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.WxIntentorderDao;
import com.pydyun.ims.model.WxIntentorder;
import com.pydyun.ims.service.wxservice.WxIntentorderService;
@Service
public class WxIntentorderServiceImpl implements WxIntentorderService{
	@Resource
	WxIntentorderDao wxIntentorderDao;

	@Override
	public boolean insertIntentionOrder(WxIntentorder wxIntentorder) {
		// TODO Auto-generated method stub
		return wxIntentorderDao.insertIntentionOrder(wxIntentorder);
	}

	@Override
	public PageInfo<WxIntentorder> queryCustomization(Integer urid,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<WxIntentorder> queryCustomization = wxIntentorderDao.queryCustomization(urid);
		return new PageInfo<>(queryCustomization);
	}
}
