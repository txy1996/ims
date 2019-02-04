package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.SchementireDao;
import com.pydyun.ims.model.Plan;
import com.pydyun.ims.service.SchementireService;
@Service
public class SchementireServiceImpl implements SchementireService {
	@Resource
	private SchementireDao schementireDao;
	@Override
	public PageInfo<Plan> toMessageInfo(Integer pageNum, Integer pageSize) throws Exception{
		PageHelper.startPage(pageNum, pageSize);
		List<Plan> list = schementireDao.findPlanMessage();
		return new PageInfo<>(list);
	}
	@Override
	public List<Plan> toMessage() throws Exception {
		// TODO Auto-generated method stub
		return schementireDao.findPlanMessage();
	}

}
