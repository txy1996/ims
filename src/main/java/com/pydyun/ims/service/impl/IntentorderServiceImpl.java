package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.IntentorderDao;
import com.pydyun.ims.model.Intentorder;
import com.pydyun.ims.service.IntentorderService;

@Service

public class IntentorderServiceImpl implements IntentorderService{
	@Resource
	private IntentorderDao idao;

	@Override
	public PageInfo<Intentorder> listintentorder(Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Intentorder> list = idao.listintentorder();
		return new PageInfo<>(list) ;
	}

	@Override
	public void Handle(Integer id) {
		idao.Handle(id);
	}

}
