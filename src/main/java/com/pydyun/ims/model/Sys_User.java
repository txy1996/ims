package com.pydyun.ims.model;

import lombok.Data;

@Data
public class Sys_User
{
    private Integer id;  //用后id
    private String username;  //用户名
    private String password;  //密码
    private String salt;  //
    private String create_time;  //注册时间
    private Integer state;  //帐号状态，0:未激活1:正常2:锁定
    private String real_name;  //真实姓名
    private Integer gender;  //性别,1-男,0-女
    private String nation;  //民族
    private String birth;  //出生日期
    private String urautograph;  //个性签名
    private String mobile;  //手机
    private String email;  //电子邮箱
    private String department;  //部门
    private String position;  //职位
    private String note;  //备注
    private String head;  //头像
    private String activate_time;  //激活时间
    private String code;  //邮件激活码
    private String maileCode;  //验证码
    private String wx_OpenId;  //用户的微信OPENID
    private String qq_openid;  //用户通过QQ绑定的openid
    private String zfb_openid;  //用户通过支付宝的openid
    private String referee;  //推荐人ID（u：1  或  s：1 ）用户推荐或者商户推荐

}
