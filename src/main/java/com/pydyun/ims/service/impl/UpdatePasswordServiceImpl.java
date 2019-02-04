package com.pydyun.ims.service.impl;

import com.pydyun.ims.dao.UserDAO;
import com.pydyun.ims.model.User;
import com.pydyun.ims.service.UpdatePasswordService;
import com.pydyun.ims.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UpdatePasswordServiceImpl implements UpdatePasswordService {
    protected Logger logger = LogManager.getLogger(this.getClass());

    @Resource
    private UserService userService;
    @Resource
    private UserDAO userDAO;

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private int hashIterations = 2;

    //验证密码（用于用户修改密码对原密码的验证）
    @Override
    public boolean validationPassword(String username, String oldPassword) {

        String algorithmName = "md5";
        int hashIterations = 2;

        User user = userService.getUserByUsername(username);
        String salt = user.getSalt();
        String oldDataBasePassword = user.getPassword();

        String newPassword = new SimpleHash(
                algorithmName,
                oldPassword,
                ByteSource.Util.bytes(username + salt),
                hashIterations).toHex();

        if(oldDataBasePassword.equals(newPassword)) {
            return true;
        } else {
            return false;
        }
    }

    //修改密码
    @Override
    public boolean updatePassword(String username,String newPassword) {
        User user=userDAO.findUserByUsername(username);

        String salt=randomNumberGenerator.nextBytes().toHex();
        user.setSalt(salt);
        newPassword = new SimpleHash(
                algorithmName,
                newPassword,
                ByteSource.Util.bytes(username + salt),
                hashIterations).toHex();
        user.setPassword(newPassword);

        boolean updatePasswordResult=userDAO.updateUser(user);
        if(updatePasswordResult){
            logger.info("用户"+username+"密码修改成功！");
            return true;
        }else{
            logger.info("用户"+username+"密码修改失败！");
            return false;
        }
    }

}
