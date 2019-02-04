package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Intentorder;

public interface IntentorderDao {

	List<Intentorder> listintentorder();

	void Handle(Integer id);

}
