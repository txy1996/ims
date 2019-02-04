package com.pydyun.ims.service;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Intentorder;

public interface IntentorderService {

	PageInfo<Intentorder> listintentorder(Integer pageNum, Integer pageSize);

	void Handle(Integer id);

}
