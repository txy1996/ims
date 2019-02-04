package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.service.Label_shop_sumSerivce;

@Service
public class Label_shop_sumSerivceImpl implements Label_shop_sumSerivce
{

    @Resource
    private com.pydyun.ims.dao.Label_shop_sumDao Label_shop_sumDao;

	@Override
	public Integer findshbyid(Integer lid) {
		// TODO Auto-generated method stub
		return Label_shop_sumDao.findshbyid(lid);
	}


}
