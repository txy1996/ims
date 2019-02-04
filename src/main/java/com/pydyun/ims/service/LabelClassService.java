package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Label_class;

public interface LabelClassService
{

    PageInfo<Label_class> select(Integer pageNum, Integer pageSize);

    List<Label_class> selectByLclcid(Integer lclcid);

    Integer add(Label_class label_class);

    void update(Label_class label_class);

    void delete(Integer lcid);
    
    Label_class getByLclcid(Integer lcid);

	List<Label_class> findscscid(Integer lcid);
	
	List<Label_class> selectall();
	
	Integer findid(String lcname);
	
	String findlclcname(Integer lcid);
}
