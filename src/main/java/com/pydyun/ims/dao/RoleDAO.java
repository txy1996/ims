package com.pydyun.ims.dao;


import com.pydyun.ims.model.Role;
import com.pydyun.ims.model.RolePermission;

import java.util.List;

public interface RoleDAO {
	void addRole(Role role);
	void deleteRole(Long id);
	Role findById(Long id);
	List<Role> findAllRoles();
	void updateRole(Role role);

	List<Role> findRolesByUsername(String username);

	void deleteUserRole(Long roleId);
	void deleteRolePermission(Long roleId);
	void addRolePermission(RolePermission rolePermission);
}
