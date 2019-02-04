package com.pydyun.ims.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Stage;
import com.pydyun.ims.model.StageIo;

public interface StageService {
	PageInfo<Stage> getStageMessage(Integer pageNum, Integer pageSize);
	
	void updateStage(Stage stage);
	void deleteStage(int id);
	int creStage(Stage stage);
	Stage getOneMessage(int id);
	
	List<StageIo> getMessage();
	List<StageIo> getMessageByid(int id);
	Stage getMessage(int id);
}
