package com.pydyun.ims.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.RoleDAO;
import com.pydyun.ims.model.Role;
import com.pydyun.ims.model.RolePermission;
import com.pydyun.ims.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDAO roleDAO;
	
	@Override
	public Long addRole(Role role, String permissionIds) {
		roleDAO.addRole(role);
		if(permissionIds!=null&&permissionIds.length()!=0){
            String [] permIds=permissionIds.split(",");
			for(String permId:permIds){
                Long permissionId=Long.valueOf(permId);
                roleDAO.addRolePermission(new RolePermission(role.getId(),permissionId));
			}
		}
        return role.getId();
	}

	@Override
	public void deleteRole(Long roleId) {
		roleDAO.deleteUserRole(roleId);
		roleDAO.deleteRolePermission(roleId);
		roleDAO.deleteRole(roleId);
	}

	@Override
	public void deleteMoreRoles(Long... roleIds) {
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				deleteRole(roleId);
			}
		}
	}

	@Override
	public Role getRoleById(Long roleId) {
		return roleDAO.findById(roleId);
	}

	@Override
	public List<Role> getRolesByUsername(String username) {
		return roleDAO.findRolesByUsername(username);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDAO.findAllRoles();
	}

	@Override
	public PageInfo<Role> getAllRolesList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Role> roles=roleDAO.findAllRoles();
		return new PageInfo<>(roles);
	}
	@Override
	public void updateRole(Role role,Long...permIds) {
		roleDAO.updateRole(role);
		roleDAO.deleteRolePermission(role.getId());
		addRolePermissions(role.getId(),permIds);
	}

	@Override
	public void addRolePermissions(Long roleId, Long... permissionIds) {
		if(permissionIds!=null&&permissionIds.length>0){
			for(Long permissionId:permissionIds){
				roleDAO.addRolePermission(new RolePermission(roleId,permissionId));
			}
		}
	}

}
