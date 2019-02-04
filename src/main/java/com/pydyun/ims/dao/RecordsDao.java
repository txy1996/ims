package com.pydyun.ims.dao;

import com.pydyun.ims.model.Records;

public interface RecordsDao {
	Integer findnumber(String vrange);
	
	Integer findnumber1(String vrange);
	
	void addReVoucher(Records records);
	
	Integer findid();
}
