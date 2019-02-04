package com.pydyun.ims.controller.wxcontroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pydyun.ims.model.Sys_User;
import com.pydyun.ims.service.wxservice.WxSysUserService;
import com.pydyun.ims.util.MD5Encryption;

/**
 * @author tangxiaoyu
 * @ClassName: WxLoginController
 * @Description: TODO(微信登陆)
 * @date 2018年8月13日 下午2:11:18
 */
@Controller
@RequestMapping("/wxLogin")
public class WxLoginController
{

    /*公众号*/
    private static final String APPID = "wx4ba06915f74f5639";
    private static final String SECRET = "f7119d88b45179ba93a4044a9bf21af3";

    @Resource
    private WxSysUserService wxSysUserService;

    @RequestMapping("/Login")
    @ResponseBody
    public Sys_User Login(HttpServletRequest request, HttpServletResponse response, Sys_User user) {

         /**
           * @Title: Login
           * @Description: TODO(微信端登陆,用户第一次登陆会注册账号
           * 并返回用户id等信息,已经注册的用户直接返回用户信息)
           * @param: [request, response, user]
           * @return:com.pydyun.ims.model.Sys_User
           * @Date: 2018/11/5 16:00
          */

        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String sessionId = request.getSession().getId();

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code="
                + user.getCode() + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        user.setCode(sessionId);
        if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
            String sessionData = responseEntity.getBody();
            JSONObject jsonObj = JSON.parseObject(sessionData);
            String openId = jsonObj.getString("openid");
            //通过解析出来的openId查询是否存在此用户
            Sys_User oldUser = wxSysUserService.findWxSysUserByWxOpenId(openId);
            if (oldUser == null && openId != null) {
                user.setWx_OpenId(openId);
                user.setState(1);
                user.setPassword("123456");
                user.setSalt(openId);
                wxSysUserService.saveWxSysUser(MD5Encryption.encryptPassword(user));//md5加密
            } else {
                oldUser.setCode(sessionId);
                return oldUser;
            }
        }
        return user;
    }
}
