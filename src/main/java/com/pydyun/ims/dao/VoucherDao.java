package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.Voucher;

public interface VoucherDao {
	List<Voucher> getMessage();
	/**
	 * 删除对应信息
	 * @param id
	 */
	void deltMessage(int id);
	/**
	 * 查询对应信息
	 * @param id
	 * @return
	 */
	Voucher selById(int id);
	/**
	 *
	 * @return
	 */
	List<String>getVcname();
	/**
	 * 更新信息
	 * @param voucher
	 */
	void updateMessage(Voucher voucher);
	/**
	 * 添加信息
	 * @param voucher
	 * @return
	 */
	void addMessage(Voucher voucher);
	
	List<Voucher> findbys(@Param("vrange")String vrange);
	
	void addMessage1(/*@Param("list")*/List<Voucher> list);
	void update(@Param("vid")Integer vid,@Param("vodate") Integer vodate);
	
	List<Voucher> findall1(@Param("vrange")String vrange,@Param("vsdate")String vsdate,@Param("vodate")String vodate,@Param("vstore")Integer vstore,@Param("vstore2")Integer vstore2);
	
	Voucher getmessage1(Integer vid);
	void update1(Voucher vo);
	void deleteshopvoucher(Integer vid);
	Integer selectmaxid();
	void alterTable();
	void addMessage2(Voucher vo);
	Voucher findbyid(Integer vid);
	void updatevstore(@Param("vid")Integer vid,@Param("vstore")Integer vstore);
	String selectimg(Integer vid);
}
