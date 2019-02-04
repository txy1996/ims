package com.pydyun.ims.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pydyun.ims.dao.PermissionDAO;
import com.pydyun.ims.dao.RoleDAO;
import com.pydyun.ims.dao.UserDAO;
import com.pydyun.ims.model.Navigation;
import com.pydyun.ims.model.Permission;
import com.pydyun.ims.model.Role;
import com.pydyun.ims.model.User;
import com.pydyun.ims.model.UserPageResponse;
import com.pydyun.ims.model.UserRole;
import com.pydyun.ims.model.UserSearchQueryRequest;
import com.pydyun.ims.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    protected Logger logger = LogManager.getLogger(this.getClass());
    @Resource
    private UserDAO userDAO;
    @Resource
    private RoleDAO roleDAO;
    @Resource
    private PermissionDAO permissionDAO;
    @Resource
    private PasswordService passwordService;

    @Override
    public boolean addUser(User user, Long... roleIds)
    {
        passwordService.encryptPassword(user);
        if (userDAO.addUser(user))
        {
            if (roleIds != null && roleIds.length > 0)
            {
                for (Long roleId : roleIds)
                {
                    userDAO.addUserRole(new UserRole(user.getId(), roleId));
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(Long userId)
    {
        userDAO.deleteUserRole(userId);
        userDAO.deleteUser(userId);
    }

    @Override
    public void deleteMoreUsers(Long... userIds)
    {
        if (userIds != null && userIds.length > 0)
        {
            for (Long userId : userIds)
            {
                deleteUser(userId);
            }
        }
    }

    @Override
    public User getUserByEmail(String email)
    {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public User getUserByUsername(String username)
    {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers()
    {
        return userDAO.findAllUsers();
    }

    @Override
    public PageInfo<User> getAllUsersAndRoles(Integer pageNum, Integer pageSize, String words)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDAO.findAllUsersAndRoles(words);
        return new PageInfo<>(users);
    }

    @Override
    public void updateUser(User user, Long... roleIds)
    {
        userDAO.updateUser(user);
        userDAO.deleteUserRole(user.getId());
        if (roleIds != null && roleIds.length > 0)
        {
            for (Long roleId : roleIds)
            {
                userDAO.addUserRole(new UserRole(user.getId(), roleId));
            }
        }
    }

    @Override
    public void resetPassword(String username)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");

        PasswordService passwordService = new PasswordService();
        passwordService.encryptPassword(user);

        userDAO.resetPassword(user);
        logger.info("用户" + user.getUsername() + "的密码已重置为123456");
    }

    @Override
    public void updateState(String username, Integer state)
    {
        userDAO.updateState(username, state);
        logger.info("用户" + username + "的状态已更改为" + state);
    }

    @Override
    public Set<String> findRolesCodeByUsername(String username)
    {
        return new HashSet<String>(userDAO.findRolesCodeByUsername(username));
    }

    @Override
    public Set<String> findPermissionsCodeByUsername(String username)
    {
        return new HashSet<String>(userDAO.findPermissionsCodeByUsername(username));
    }

    @Override
    public List<Navigation> getNavigationBar(String username)
    {
        List<Navigation> navigationBar = new ArrayList<Navigation>();
        Navigation navigation;
        List<Role> roles = roleDAO.findRolesByUsername(username);
        for (Role role : roles)
        {
            Long pId = new Long((long) 0);
            Long roleId = role.getId();
            List<Permission> perms = permissionDAO.findNavByRoleIdAndPId(roleId, pId);
            for (Permission perm : perms)
            {
                navigation = new Navigation();
                navigation.setNavId(perm.getId());
                navigation.setNavigationName(perm.getName());
                navigation.setNavIcon(perm.getIcon());
                navigation.setChildNavigations(permissionDAO.findNavByRoleIdAndPId(roleId, perm.getId()));
                navigationBar.add(navigation);
            }
        }
        logger.info("UserServiceImpl→getNavigationBar已成功获取菜单数据。");
        return navigationBar;
    }

    // 激活
    @Override
    public String processActivate(String code)
    {
        String activationResult = null;
        User user = userDAO.findUserByCode(code);
        if (user != null)
        {
            // 验证用户激活状态
            if (user.getState() == 0)
            {
                // 没激活
                Date currentTime = new Date();// 获取当前时间
                // 验证链接是否过期
                if (currentTime.after(user.getCreateTime()) && currentTime.before(user.getActivateTime()))
                {
                    // 验证激活码是否正确
                    if (code.equals(user.getCode()))
                    {
                        // 激活成功，并更新用户的激活状态为已激活1
                        user.setState(1);// 把状态改为激活
                        user.setCode("");// 把激活码清空
                        userDAO.updateUser(user);
                        logger.warn("帐号激活成功");
                        activationResult = "帐号激活成功";
                    }
                    else
                    {
                        logger.warn("激活链接不正确");
                        activationResult = "激活链接不正确";
                    }
                }
                else
                {
                    logger.warn("激活链接已过期");
                    activationResult = "激活链接已过期";
                }
            }
            else
            {
                logger.warn("帐户已是激活状态，请直接登录");
                activationResult = "帐户已是激活状态，请直接登录";
            }
        }
        else
        {
            logger.warn("激活链接已失效");
            activationResult = "激活链接已失效";
        }
        return activationResult;

    }

    @Override
    public User getUserByPhone(String mobile)
    {
        // TODO Auto-generated method stub
        return userDAO.findUserByPhone(mobile);
    }

    @Override
    public User getUserByMobileCode(String maileCode)
    {
        // TODO Auto-generated method stub
        return userDAO.findUserByMaileCode(maileCode);
    }

    @Override
    public void creUser(User user, Long... roleIds)
    {
        passwordService.encryptPassword(user);
        if (roleIds != null && roleIds.length > 0)
        {
            for (Long roleId : roleIds)
            {
                userDAO.addUserRole(new UserRole(user.getId(), roleId));
                userDAO.creUser(user);
            }
        }
    }

    @Override
    public PageInfo<UserPageResponse> select(Integer pageNum, Integer pageSize, String Userattribute, String userinfo
            ,String filter,Integer minNum,Integer maxNum      )
    {
        UserSearchQueryRequest request = new UserSearchQueryRequest();
        if (Userattribute!="Undefined")
        {
            switch (Userattribute)
            {
                case "username":
                    request.setUsername(userinfo);
                    break;
                case "real_name":
                    request.setReal_name(userinfo);
                    break;
                case "mobile":
                    request.setMobile(userinfo);
                    break;
            }
        }
        if (filter!="filter") {
            switch (filter)
            {
                case "vmoney":
                    request.setVmoney(0);
                    request.setMaxNum(maxNum);
                    request.setMinNum(minNum);
                    break;
                case "isum":
                    request.setIsum(1);
                    request.setMaxNum(maxNum);
                    request.setMinNum(minNum);
                    break;
                case "gnum":
                    request.setGnum(1);
                    request.setMaxNum(maxNum);
                    request.setMinNum(minNum);
                    break;
                case "coupon":
                    request.setCoupon(3);
                    request.setMaxNum(maxNum);
                    request.setMinNum(minNum);
                    break;
            }
        }
        
        

        PageHelper.startPage(pageNum, pageSize);
        List<UserPageResponse> list = userDAO.select(request);
        return new PageInfo<>(list);
    }

	@Override
	public List<User> finduser() {
		// TODO Auto-generated method stub
		return userDAO.finduser();
	}

	@Override
	public String findname(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.findname(id);
	}

	@Override
	public Integer findid(String username) {
		// TODO Auto-generated method stub
		return userDAO.findid(username);
	}

}
