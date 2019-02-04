package com.pydyun.ims.controller;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.UserLevel;
import com.pydyun.ims.service.UserLevelService;

@Controller
@RequestMapping("/level")
public class UserLevelController {
	protected Logger logger = LogManager.getLogger(this.getClass());
	@Resource
	private UserLevelService levelservice;
	/**
	 * 等级信息列表，分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequiresPermissions("level:list")
	@RequestMapping("/list")
	public ModelAndView toLevel(Integer pageNum,Integer pageSize) {
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<UserLevel> level = levelservice.pollingList(pageNum, pageSize);
		ModelAndView mv = new ModelAndView("level/level-list");
		mv.addObject("level",level);
		return mv;
	}
	/**
	 * 添加等级信息
	 * @param userLevel
	 * @return
	 */
	@RequiresPermissions("level:add")
	@RequestMapping("/add")
	@ResponseBody
	public UserLevel addLevel(UserLevel userLevel) {
		levelservice.addLevel(userLevel);
		return userLevel;
	}
	/**
	 * 查询相关信息
	 * @param ulid
	 * @return
	 */
	@RequiresPermissions("level:list")
	@RequestMapping("/getLevel")
	@ResponseBody
	public UserLevel polling(String ulid) {
		return levelservice.polling(Integer.valueOf(ulid));
	}
	@RequiresPermissions("level:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updateLevel(UserLevel userLevel) {
		levelservice.updateLevel(userLevel);
	}
	
	@RequiresPermissions("level:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteLevel(String ulid) {
		levelservice.deleteLevel(Integer.valueOf(ulid));
	}
}
