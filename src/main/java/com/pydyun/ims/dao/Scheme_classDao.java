package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Scheme_class;

public interface Scheme_classDao {
	Scheme_class getOneMessaeg(int id);
	List<String> getClassSname();	
	List<Scheme_class> getClassList();
	List<Scheme_class> getClassIdAndNmae();
	Scheme_class getOneMessage(int id);
	void deleteByScid(Integer id);
	void addClass(Scheme_class schemeClass);
	void updateClass(Scheme_class schemeClass);	
	int getid(String scname);
	List<Scheme_class> findscscid1(Integer scscid);
	String findscscname(Integer scid);
	Integer findscid(String scname);
}
