package com.pydyun.ims.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.U_c_log;

public interface UserCouponDao {
	List<U_c_log> findall(@Param("urid")Integer urid,@Param("csdate")String csdate,@Param("codate")String codate,@Param("ucstate")Integer ucstate);
	
	List<U_c_log> select();

	void update(@Param("uclid")Integer uclid, @Param("ucinfo") String ucinfo,@Param("ucInvalid") Date ucInvalid);
	void update1(@Param("uclid")Integer uclid, @Param("ucinfo") String ucinfo);
	
	void insertuclog(U_c_log uclog);
    Integer selectmaxid();
	void alterTable();
	List<Integer> findcid(Integer urid);
}
