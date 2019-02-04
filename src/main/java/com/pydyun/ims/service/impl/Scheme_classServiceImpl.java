package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.Scheme_classDao;
import com.pydyun.ims.model.Scheme_class;
import com.pydyun.ims.service.Scheme_classService;
@Service
public class Scheme_classServiceImpl implements Scheme_classService{
	@Resource
	private Scheme_classDao scdao;
	@Override
	public Scheme_class getOne(int id) {
		Scheme_class sc = scdao.getOneMessaeg(id);
		return sc;
	}
	@Override
	public List<String> getClassName() {
		return scdao.getClassSname();
	}
	
	@Override
	public PageInfo<Scheme_class> getClassList(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Scheme_class> list=scdao.getClassList();
		return new PageInfo<>(list);
	}
	@Override
	public List<Scheme_class> getClassIdAndNmae() {
		// TODO Auto-generated method stub
		return scdao.getClassIdAndNmae();
	}
	@Override
	public void deleteByScid(Integer id) {
		// TODO Auto-generated method stub
		scdao.deleteByScid(id);
	}
	@Override
	public void addClass(Scheme_class schemeClass) {
		// TODO Auto-generated method stub
		scdao.addClass(schemeClass);
	}
	@Override
	public void updateClass(Scheme_class schemeClass) {
		// TODO Auto-generated method stub
		scdao.updateClass(schemeClass);
	}
	@Override
	public int getid(String scname) {
		// TODO Auto-generated method stub
		return scdao.getid(scname);
	}
	@Override
	public List<Scheme_class> findscscid(Integer scid) {
		// TODO Auto-generated method stub
		return scdao.findscscid1(scid);
	}
	@Override
	public String findscscname(Integer scid) {
		// TODO Auto-generated method stub
		return scdao.findscscname(scid);
	}
	@Override
	public Integer findscid(String scname) {
		// TODO Auto-generated method stub
		return scdao.findscid(scname);
	}

}
