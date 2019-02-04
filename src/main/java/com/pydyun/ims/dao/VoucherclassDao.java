package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Voucherclass;

public interface VoucherclassDao {

	List<Voucherclass> select();

	void delete(Integer vcid);

	void add(Voucherclass voucherclass);

	Voucherclass getid(Integer vcid);

	void update(Voucherclass voucherclass);
	
	List<Voucherclass> getVcname();

}
