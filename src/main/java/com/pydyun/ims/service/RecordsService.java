package com.pydyun.ims.service;

import com.pydyun.ims.model.Records;

public interface RecordsService {

	Integer findnumber(String vrange);
	
	Integer findnumber1(String vrange);
	
	void addReVoucher(Records records);
	
	Integer findid();
}
