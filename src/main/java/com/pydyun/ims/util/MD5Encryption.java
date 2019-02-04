package com.pydyun.ims.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.pydyun.ims.model.Sys_User;

/**
 * @ClassName: MD5Encryption
 * @Description: TODO(MD5加密工具类)
 * @author tangxiaoyu
 * @date 2018年8月14日 上午9:47:55
 *
 */
public class MD5Encryption
{

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static Sys_User encryptPassword(Sys_User user)
    {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(algorithmName, user.getPassword(),
                ByteSource.Util.bytes(user.getUsername() + user.getSalt()), hashIterations).toHex();
        user.setPassword(newPassword);
        return user;
    }
}
