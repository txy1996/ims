package com.pydyun.ims.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.U_v_log;

public interface UserVoucherService {
	PageInfo<U_v_log> findall(Integer pageNum, Integer pageSize,Integer urid,String starttime,String endtime,Integer uvlstate);
	List<U_v_log> select();
	void update(Integer uvlid, String uvinfo,Date date);
	void update1(Integer uvlid, String uvinfo);
	List<Integer> findvid(Integer urid);
}
