package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Scheme_class;

public interface Scheme_classService {
	Scheme_class getOne(int id);
	List<String> getClassName();
	
	PageInfo<Scheme_class> getClassList(Integer pageNum, Integer pageSize);
	List<Scheme_class> getClassIdAndNmae();
	void deleteByScid(Integer id);
	void addClass(Scheme_class schemeClass);
	void updateClass(Scheme_class schemeClass);	
	int getid(String scname);
	List<Scheme_class> findscscid(Integer scid);
	String findscscname(Integer scid);
	Integer findscid(String scname);
}
