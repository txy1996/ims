package com.pydyun.ims.dao;

import java.util.List;

import com.pydyun.ims.model.Stage;
import com.pydyun.ims.model.StageIo;

public interface StageDao {
	/**
	 * 全部阶段信息
	 * @return
	 */
	List<Stage> getStageMessage();
	/**
	 * 删除阶段信息
	 * @param id
	 */
	void deleteStage(int id);
	/**
	 * 添加阶段信息
	 * @param stage
	 */
	void creStage(Stage stage);
	/**
	 * 更新阶段信息
	 * @param stage
	 */
	void updateStage(Stage stage);
	/**
	 * id查询阶段信息
	 * @param id
	 * @return
	 */
	Stage getOne(int id);
	
	List<StageIo> getStageIoMessage();
	
	List<StageIo> getMessageByid(int id);
	
}
