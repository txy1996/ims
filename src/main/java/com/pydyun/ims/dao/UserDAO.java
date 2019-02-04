package com.pydyun.ims.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pydyun.ims.model.User;
import com.pydyun.ims.model.UserPageResponse;
import com.pydyun.ims.model.UserRole;
import com.pydyun.ims.model.UserSearchQueryRequest;

public interface UserDAO {
	boolean addUser(User user);
	void deleteUser(Long id);
	User findUserByEmail(String email);
	User findUserByCode(String code);
	User findUserByUsername(String username);
	List<User> findAllUsers();
	List<User> finduser();

	List<User> findAllUsersAndRoles(@Param("words")String words);

	boolean updateUser(User user);

	void resetPassword(User user);
	void updateState(@Param("username")String username, @Param("state")Integer state);

	void deleteUserRole(Long userId);
	void addUserRole(UserRole userRole);
	
	List<String> findRolesCodeByUsername(String username);
	List<String> findPermissionsCodeByUsername(String username);
	/**
	 * 查询验证码是否存在
	 * @param maileCode
	 * @return
	 */
	User findUserByMaileCode(String maileCode);
	/**
	 * 查询电话是否存在
	 * @param phone
	 * @return
	 */
	User findUserByPhone(String mobile);
	
	void creUser(User user);
	
//	List<String> getName();
	
	/**
	 * @Title: select 
	 * @Description: TODO(分页查询) 
	 * @return
	 */
	List<UserPageResponse> select(UserSearchQueryRequest request);
    List<String> getName();
	
	String findname(Integer id);
	Integer findid(String username);
}
