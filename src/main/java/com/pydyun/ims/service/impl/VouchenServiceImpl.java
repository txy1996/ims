package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.VoucherDao;
import com.pydyun.ims.model.Voucher;
import com.pydyun.ims.service.VoucherService;

@Service
public class VouchenServiceImpl implements VoucherService{
	@Resource
	private VoucherDao vdao;

	@Override
	public PageInfo<Voucher> toMessage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Voucher> list =vdao.getMessage();
		return new PageInfo<>(list);
	}

	@Override
	public void deltVoucher(int id) {
		Voucher voucher = vdao.selById(id);
		if(voucher!=null) {
			vdao.deltMessage(id);
		}
	}

	@Override
	public Voucher findOnemsg(int id) {
		return vdao.selById(id);
	}

	@Override
	public List<String> getVcname() {
		// TODO Auto-generated method stub
		return vdao.getVcname();
	}

	@Override
	public void updateMessage(Voucher voucher) {
		if(voucher!=null) {
			vdao.updateMessage(voucher);			
		}
	}

	@Override
	public int addMessage(Voucher voucher) {
		vdao.addMessage(voucher);
		return voucher.getVcid();
	}

	@Override
	public List<Voucher> findbys(String vrange) {
		// TODO Auto-generated method stub
		return vdao.findbys(vrange);
	}

	@Override
	public void update(Integer vid, Integer time) {
		// TODO Auto-generated method stub
		vdao.update(vid,time);
	}

	@Override
	public PageInfo<Voucher> findall1(Integer pageNum, Integer pageSize,String vrange,String starttime,String endtime,Integer vstore1,Integer vstore2) {
		// TODO Auto-generated method stub
		 List<Voucher> list = vdao.findall1(vrange,starttime,endtime,vstore1,vstore2);
		 return new PageInfo<>(list);
	}

	@Override
	public Voucher getmessage1(Integer vid) {
		// TODO Auto-generated method stub
		return vdao.getmessage1(vid);
	}

	@Override
	public void update1(Voucher vo) {
		// TODO Auto-generated method stub
		vdao.update1(vo);
	}

	@Override
	public void deleteshopvoucher(Integer vid) {
		// TODO Auto-generated method stub
		vdao.deleteshopvoucher(vid);
	}

	@Override
	public void addMessage1(List<Voucher> list) {
		// TODO Auto-generated method stub
		vdao.addMessage1(list);
	}

	@Override
	public Integer selectmaxid() {
		// TODO Auto-generated method stub
		return vdao.selectmaxid();
	}

	@Override
	public void alterTable() {
		// TODO Auto-generated method stub
		vdao.alterTable();
	}

	@Override
	public void addMessage2(Voucher vo) {
		// TODO Auto-generated method stub
		vdao.addMessage2(vo);
	}	
	
}
