package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Plan;

/**
 * 方案总览
 * @author Administrator
 *
 */
public interface SchementireService {
	PageInfo<Plan> toMessageInfo(Integer pageNum, Integer pageSize) throws Exception;
	List<Plan> toMessage()throws Exception;
}
