package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.WxLabel;

public interface WxLabelDao {

	List<WxLabel> findinfo(List<String> ids);
}
