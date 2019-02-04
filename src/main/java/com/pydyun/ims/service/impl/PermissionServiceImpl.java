package com.pydyun.ims.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.PermissionDAO;
import com.pydyun.ims.model.Permission;
import com.pydyun.ims.service.PermissionService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionDAO permissionDAO;
	
	@Override
	public Long addPermission(Permission permission) {
		permissionDAO.addPermission(permission);
		return permission.getId();
	}

	@Override
	public void deletePermission(Long permissionId) {
		permissionDAO.deleteRolePermission(permissionId);
		permissionDAO.deletePermission(permissionId);
	}

	@Override
	public void deleteMorePermissions(Long... permIds) {
		if(permIds!=null&&permIds.length>0){
			for(Long permId:permIds){
				deletePermission(permId);
			}
		}
	}

	@Override
	public Permission findById(Long permId) {
		return permissionDAO.findById(permId);
	}

	@Override
	public List<Permission> getPermissionsByRoleId(Long roleId) {
		return permissionDAO.findPermissionsByRoleId(roleId);
	}

	@Override
	public List<Permission> getAllPermissions() {
		return permissionDAO.findAllPermissions();
	}

	@Override
	public PageInfo<Permission> getAllPermissionsList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Permission> Permissions=permissionDAO.findAllPermissions();
		return new PageInfo<>(Permissions);
	}

	@Override
	public List<Permission> getPermissionsTree() {
		return permissionDAO.findPermissionsTree();
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionDAO.updatePermission(permission);
	}

//	@Override
//	public List<String> name() {
//		return permissionDAO.name();
//	}

}
