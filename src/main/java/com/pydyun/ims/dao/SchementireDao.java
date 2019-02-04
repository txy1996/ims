package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Plan;

public interface SchementireDao {
	List<Plan> findPlanMessage()throws Exception;
}
