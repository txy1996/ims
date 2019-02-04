package com.pydyun.ims.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.U_v_log;

public interface UserVoucherDao {
	List<U_v_log> findall(@Param("urid")Integer urid,@Param("vsdate")String vsdate,@Param("vodate")String vodate,@Param("uvlstate")Integer uvlstate);
	
	List<U_v_log> select();

	void update(@Param("uvlid")Integer uvlid, @Param("uvinfo") String uvinfo,@Param("uvlInvalid") Date uvlInvalid);
	void update1(@Param("uvlid")Integer uvlid, @Param("uvinfo") String uvinfo);
	
    void insertuvlog(U_v_log uvlog);
    Integer selectmaxid();
	void alterTable();
	List<Integer> findvid(Integer urid);
}
