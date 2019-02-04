package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Voucherclass;

public interface VoucherclassService {

	PageInfo<Voucherclass> select(Integer pageNum, Integer pageSize);

	void delete(Integer vcid);

	Integer add(Voucherclass voucherclass);

	Voucherclass getid(Integer vcid);

	void update(Voucherclass voucherclass);
	
	List<Voucherclass> getVcname();

}
