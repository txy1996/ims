package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Voucher;

public interface VoucherService {
	PageInfo<Voucher> toMessage(Integer pageNum, Integer pageSize);
	void deltVoucher(int id);
	Voucher findOnemsg(int id);
	List<String> getVcname();
	void updateMessage(Voucher voucher);
	int addMessage(Voucher voucher);
	List<Voucher> findbys(String vrange);
	void addMessage1(List<Voucher> list);
	void update(Integer vid, Integer time);
	PageInfo<Voucher> findall1(Integer pageNum, Integer pageSize,String vrange,String starttime,String endtime,Integer vstore1,Integer vstore2);
	Voucher getmessage1(Integer vid);
	void update1(Voucher vo);
	void deleteshopvoucher(Integer vid);
	Integer selectmaxid();
	void alterTable();
	void addMessage2(Voucher vo);
}
