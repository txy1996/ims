package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Stage;
import com.pydyun.ims.service.SchemeService;
import com.pydyun.ims.service.StageService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Resource
	private StageService stageService;
	@Resource
	private SchemeService schemeService;
	
	@RequiresPermissions("plan:list")
	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView plan(Integer pageNum, Integer pageSize){
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		PageInfo<Stage> stage = stageService.getStageMessage(pageNum, pageSize);
		List<String> list = schemeService.getSnameMessage();
		ModelAndView mv = new ModelAndView("stage/plan");
		mv.addObject("stage",stage);
		mv.addObject("list", list);
		return mv;
	}
	//id删除信息
	@RequiresPermissions("plan:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteMessage(String id) {
		stageService.deleteStage(Integer.valueOf(id));
	}
	//修改信息
	@RequiresPermissions("plan:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateStage(Stage stage) {
		stageService.updateStage(stage);
	}
    //id查询信息
	@RequiresPermissions("plan:list")
	@RequestMapping("/getMethod")
	@ResponseBody
	public Stage getOneMessage(String id) {
		return stageService.getOneMessage(Integer.valueOf(id));
	}
    //新增信息
	@RequiresPermissions("plan:add")
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
	
	//查看详情页面
	@RequestMapping("/getplan")
	public ModelAndView getMethod(Integer id) {
		ModelAndView mv = new ModelAndView("stage/plan-method");
		Stage list = stageService.getMessage(id);
		mv.addObject("list", list);
		return mv;
	}
}
