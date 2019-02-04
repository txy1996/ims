package com.pydyun.ims.controller;

import com.github.pagehelper.PageInfo;
import com.pydyun.ims.model.Permission;
import com.pydyun.ims.service.PermissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
@RequestMapping("/perm")
public class PermissionController {
	protected Logger logger = LogManager.getLogger(this.getClass());
	@Resource
	private PermissionService permissionService;
	
	@RequiresPermissions("perm:show")
	@RequestMapping("/list")
	public ModelAndView showRoleList(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 8 : pageSize;
		PageInfo<Permission> Permissions = permissionService.getAllPermissionsList(pageNum, pageSize);
		ModelAndView mav=new ModelAndView("module/permission-list");
		mav.addObject("perms", Permissions);
		return mav;
	}

	@RequiresPermissions("perm:add")
	@RequestMapping("/add")
	@ResponseBody
	public Permission addPermission(Permission permission){
		permissionService.addPermission(permission);
		return permission;
	}
	
	@RequiresPermissions("perm:delete")
	@RequestMapping("/delete")
	@ResponseBody
	public void deletePermission(Long permId){
		permissionService.deletePermission(permId);
	}
	
	@RequiresPermissions("perm:delete")
	@RequestMapping("/deleteMore")
	@ResponseBody
	public void deleteMorePerms(Long...permIds){
		permissionService.deleteMorePermissions(permIds);
	}
	
	@RequiresPermissions("perm:show")
	@RequestMapping("/getPerm")
	@ResponseBody
	public Permission getPermById(Long permId){
		return permissionService.findById(permId);
	}

	@RequiresPermissions("perm:update")
	@RequestMapping("/update")
	@ResponseBody
	public void updatePermission(Permission permission){
		permissionService.updatePermission(permission);
	}
}
