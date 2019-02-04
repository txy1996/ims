package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Label_class;

public interface LabelClassDao
{
    List<Label_class> select();

    List<Label_class> selectByLclcid(Integer lclcid);

    void add(Label_class label_class);

    void update(Label_class label_class);

    void delete(Integer lcid);

    Label_class getByLclcid(Integer lcid);

	List<Label_class> findscscid(Integer lclcid);
	
	Integer findid(String lcname);

	String findlclcname(Integer lcid);

}
