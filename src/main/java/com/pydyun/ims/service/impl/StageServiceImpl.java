package com.pydyun.ims.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.StageDao;
import com.pydyun.ims.model.SchemeIo;
import com.pydyun.ims.model.Stage;
import com.pydyun.ims.model.StageIo;
import com.pydyun.ims.service.StageService;
@Service
public class StageServiceImpl implements StageService {
	@Resource
	private StageDao stageDao;
	@Override
	public PageInfo<Stage> getStageMessage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Stage> list = stageDao.getStageMessage();
		return new PageInfo<>(list);
	}
	@Override
	public void updateStage(Stage stage) {
			stageDao.updateStage(stage);
	}
	@Override
	public void deleteStage(int id) {
		// TODO Auto-generated method stub
		if(stageDao.getOne(id)!=null) {
			stageDao.deleteStage(id);
		}
		
	}
	@Override
	public int creStage(Stage stage) {
		// TODO Auto-generated method stub
		stageDao.creStage(stage);
		return stage.getSsid();
	}
	@Override
	public Stage getOneMessage(int id) {
		Stage stage = stageDao.getOne(id);
		return stage;
	}
	@Override
	public List<StageIo> getMessage() {
		List<StageIo> list = stageDao.getStageIoMessage();
		/*for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		return list;
	}
	@Override
	public List<StageIo> getMessageByid(int id) {
		// TODO Auto-generated method stub
		return stageDao.getMessageByid(id);
	}
	@Override
	public Stage getMessage(int id) {
		// TODO Auto-generated method stub
		return stageDao.getOne(id);
	}

}
