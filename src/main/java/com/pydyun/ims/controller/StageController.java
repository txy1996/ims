/*package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Stage;
import com.pydyun.ims.model.StageIo;
import com.pydyun.ims.service.SchemeService;
import com.pydyun.ims.service.StageService;

@Controller
@RequestMapping("/stage")
public class StageController {
	@Resource
	private StageService stageService;
	@Resource
	private SchemeService schemeService;
	*//**
	 * 全部阶段信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 *//*
	@RequiresPermissions("stage:list")
	@RequestMapping("/list")
	public ModelAndView toMessage(Integer pageNum,Integer pageSize) {
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		PageInfo<Stage> stage = stageService.getStageMessage(pageNum, pageSize);
		List<String> list = schemeService.getSnameMessage();
		ModelAndView mv = new ModelAndView("stage/scheme_stage");
		mv.addObject("stage",stage);
		mv.addObject("list",list);
		return mv;
	}
	*//**
	 * 删除对应阶段信息
	 * @param id
	 *//*
	@RequiresPermissions("stage:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteMessage(String id) {
		stageService.deleteStage(Integer.valueOf(id));
	}

	@RequiresPermissions("stage:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateStage(Stage stage) {
		stageService.updateStage(stage);
	}

	@RequiresPermissions("stage:list")
	@RequestMapping("/getMethod")
	@ResponseBody
	public Stage getOneMessage(String id) {
		return stageService.getOneMessage(Integer.valueOf(id));
	}

	@RequiresPermissions("stage:add")
	@RequestMapping("/add")
	@ResponseBody
	public Stage creStage(Integer sid,String ssname,String ssinfo) {
		Stage stage = new Stage();
		stage.setSid(sid);
		stage.setSsname(ssname);
		stage.setSsinfo(ssinfo);
		stageService.creStage(stage);
		return stage;
	}

	@RequestMapping("/getOneMethod")
	public String getMethod(HttpServletRequest request,Integer id) {
		List<StageIo> list = stageService.getMessageByid(id);
		for(int i=0;i<list.size();i++) {
			request.setAttribute("list",list.get(i));
		}
		return "stage/method";
	}
}
*/