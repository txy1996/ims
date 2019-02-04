package com.pydyun.ims.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.User_position;
import com.pydyun.ims.service.UserPositionService;

@Controller
@RequestMapping("/position")
public class UserPositionController {
	@Resource
	private UserPositionService userPositionService;
	/**
	 * 查询所有
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions("position:list")
	@RequestMapping("/list")
	public ModelAndView toPosition(Integer pageNum,Integer pageSize) throws Exception{
		pageNum = pageNum ==null ? 1:pageNum;
		pageSize = pageSize ==null ? 8:pageSize;
		/*Map<String,Object>	map =new HashMap<String,Object>();*/
		List<String> pname = userPositionService.getMessage();
		List<String> cname = userPositionService.getCompanyMsg();
		List<String> username = userPositionService.getUsername();
		PageInfo<User_position> position = userPositionService.queryAll(pageNum, pageSize);
		ModelAndView mv = new ModelAndView("position/position_list");
		mv.addObject("position", position);
		mv.addObject("pname",pname );
		mv.addObject("cname", cname);
		mv.addObject("username",username);
		return mv;
	}
/**
 * 单项删除
 * @param id
 */
	@RequiresPermissions("position:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteUposition(String id) {
		if(id !=null && id.length()>0) {
			userPositionService.deletePositon(Integer.valueOf(id));
		}
	}
	/**
	 * 查询id对应的数据
	 * @param id
	 * @return
	 */
	@RequiresPermissions("position:list")
	@RequestMapping("/getPosiMsg")
	@ResponseBody
	public User_position getPositionMessage(String id) {
		return  userPositionService.queryById(Integer.valueOf(id));
	}
	
	/*@RequiresPermissions("position:add")
	@RequestMapping("/add")
	@ResponseBody
	public User_position addMessage(User_position position) {
		userPositionService.addPosition(position);
		return position;
	}*/
	@RequiresPermissions("position:add")
	@RequestMapping("/add")
	@ResponseBody
	public User_position getMessage(int urid,int cid,int pid,String upsort,String upsdate,String upodate) {
		User_position position = new User_position();
		position.setUrid(urid);
		position.setCid(cid);
		position.setPid(pid);
		position.setUpsort(upsort);
		position.setUpsdate(upsdate);
		position.setUpodate(upodate);
		userPositionService.addPosition(position);
		return position;
	}
	@RequiresPermissions("position:update")
	@RequestMapping("/update")
	@ResponseBody
	public void update(User_position position) {
		userPositionService.updatePosition(position);
	}
}
