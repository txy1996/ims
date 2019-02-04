package com.pydyun.ims.service.wxservice;

import java.util.List;

import com.pydyun.ims.model.WxLabel;

public interface WxLabelService {

	List<WxLabel> findinfo(List<String> ids);
}
