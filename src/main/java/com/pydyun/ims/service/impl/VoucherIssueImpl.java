package com.pydyun.ims.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pydyun.ims.dao.VoucherIssueDao;
import com.pydyun.ims.service.VoucherIssueService;

@Service
public class VoucherIssueImpl implements VoucherIssueService{

	@Resource
	private VoucherIssueDao voucherIssueDao;
}
