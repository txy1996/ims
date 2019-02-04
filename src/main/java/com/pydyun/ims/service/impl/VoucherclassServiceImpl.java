package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.VoucherclassDao;
import com.pydyun.ims.model.Voucherclass;
import com.pydyun.ims.service.VoucherclassService;

@Service
public class VoucherclassServiceImpl implements VoucherclassService{
	
	@Resource
	private VoucherclassDao VoucherclassDao;

	@Override
	public PageInfo<Voucherclass> select(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Voucherclass> list = VoucherclassDao.select();
		return new PageInfo<>(list);
	}

	@Override
	public void delete(Integer vcid) {
		VoucherclassDao.delete(vcid);
		
	}

	@Override
	public Integer add(Voucherclass voucherclass) {
		VoucherclassDao.add(voucherclass);
		return voucherclass.getVcid();
	}

	@Override
	public Voucherclass getid(Integer vcid) {
		
		return VoucherclassDao.getid(vcid);		
	}

	@Override
	public void update(Voucherclass voucherclass) {
		VoucherclassDao.update(voucherclass);
	}

	@Override
	public List<Voucherclass> getVcname() {
		// TODO Auto-generated method stub
		return VoucherclassDao.getVcname();
	}
	
	

}
