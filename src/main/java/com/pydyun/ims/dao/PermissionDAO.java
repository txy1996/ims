package com.pydyun.ims.dao;

import com.pydyun.ims.model.Permission;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDAO {
	void addPermission(Permission permission);
	void deletePermission(Long permissionId);
	Permission findById(Long permId);

	List<Permission> findNavByRoleIdAndPId(@Param("roleId")Long roleId, @Param("pId")Long pId);
	List<Permission> findPermissionsByRoleId(Long roleId);
	List<Permission> findAllPermissions();
    List<Permission> findPermissionsTree();
	void updatePermission(Permission permission);
	
	void deleteRolePermission(Long permissionId);
	List<String> name();
}
