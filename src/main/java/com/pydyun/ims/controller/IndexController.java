package com.pydyun.ims.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pydyun.ims.model.User;
import com.pydyun.ims.model.UserCodeNum;
import com.pydyun.ims.service.SystemService;
import com.pydyun.ims.service.UpdatePasswordService;
import com.pydyun.ims.service.UserCodeNumService;
import com.pydyun.ims.service.UserService;
import com.pydyun.ims.service.impl.PasswordService;
import com.pydyun.ims.util.IndustrySMS;

@Controller
public class IndexController {
	protected Logger logger = LogManager.getLogger(this.getClass());
	@Resource
	private UserService userService;

	@Resource
	private SystemService systemService;
	
	@Resource
	private UserCodeNumService userCodeNumService;
	@Resource
	private UpdatePasswordService updatePasswordService;
	@Resource
	private PasswordService passwordService;
	
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@RequestMapping("/main")
	public String main() {
		return "module/main";
	}

	@RequestMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}

	@RequestMapping("/module-maintenance")
	public String moduleMaintenance() {
		return "module/maintenance";
	}

	@RequestMapping("/website-maintenance")
	public String websiteMaintenance() {
		return "maintenance";
	}
	@RequestMapping("/activation-result")
	public String activationResult() {
		return "/activation-result";
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		String error = null;
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			logger.error("用户名不存在!");
			error = "用户名或密码错误!";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			logger.error("密码错误!");
			error = "用户名或密码错误!";
		} else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
			logger.error("密码尝试次数超限，用户已锁定!");
			error = "密码尝试次数超限，用户已锁定!";
		}else if (DisabledAccountException.class.getName().equals(exceptionClassName)) {
			logger.error("帐户被禁用!");
			error = "帐户被禁用，请联系管理员!";
		} else if (exceptionClassName != null) {
			logger.error("未知错误：" + exceptionClassName);
			error = "未知错误，请联系管理员!";
		}
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("error", error);
		return mav;
	}

	@RequestMapping("/checkCode")
	@ResponseBody
	public Boolean getCode(String moblie) {
		String codeNum = IndustrySMS.executeString(moblie);
		System.out.println("Controller"+codeNum);
		if(!codeNum.matches("[\\d]+")) {
			return false;
		}
		UserCodeNum userCodeNum = new UserCodeNum();
		userCodeNum.setMoblie(moblie);
		userCodeNum.setCodeNum(codeNum);
		userCodeNumService.insertUserCodeNum(userCodeNum);
		if(codeNum!=null) {
			return true;
		}
		return false;
	}
	//注册验证邮箱是否存在
	@RequestMapping("/checkEmail")
	@ResponseBody
	public boolean checkEmail(String email) {
		User user = userService.getUserByEmail(email);
		if (user != null) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 注册验证电话是否存在
	 * @param mobile
	 * @return
	 */
	@RequestMapping("/checkMobile")
	@ResponseBody
	public boolean checkPhone(String mobile) {
		User user = userService.getUserByPhone(mobile);
		if(user !=null) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 注册验证验证码是否存在
	 * @return
	 */
	@RequestMapping("/checkMailCode")
	@ResponseBody
	public boolean checkCode(String maileCode) {
		User user = userService.getUserByMobileCode(maileCode);
		if(user !=null) {
			return false;
		}else {
			return true;
		}
	}

	//注册验证用户名是否存在
	@RequestMapping("/checkUsername")
	@ResponseBody
	public boolean checkUsername(String username) {
		User user = userService.getUserByUsername(username);
		if (user != null) {
			return false;
		} else {
			return true;
		}
	}


	//注册新用户
/*	@RequestMapping("/signUp")
	@ResponseBody
	public User signUp(User user) {
		Date date = new Date();
		user.setCreateTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式（用于日志输出）

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天

		Date activateTime = c.getTime();
		user.setActivateTime(activateTime);

		String code = UUID.randomUUID().toString() + UUID.randomUUID().toString();
		code = code.replaceAll("-", "");
		user.setCode(code);

		user.setState(0);

		//      注册新用户是默认不设置权限，所以权限置空
		Long roleIds = null;
		boolean signUpResult=userService.addUser(user, roleIds);
		if(signUpResult){
			logger.info("新用户注册：" + user.getUsername() + "，注册时间：" + sdf.format(date)+"激活过期时间:" + sdf.format(activateTime));
			String path="http://dev.pydyun.com:8080/ims/activation";
			String username=user.getUsername();
			String email=user.getEmail();
			boolean sendSignUpMailResult=systemService.sendSignUpMail(path,username,email,code);
			if(sendSignUpMailResult){
				logger.info("用户"+username+"邮箱验证邮件发送成功！");
			}else{
				logger.info("用户"+username+"邮箱验证邮件发送失败！");
			}

		}
		return user;
	}*/

	@RequestMapping("/signUp")
	@ResponseBody
	public User signUp(User user) {
		Date date = new Date();
		user.setCreateTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式（用于日志输出）

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天

		Date activateTime = c.getTime();
		user.setActivateTime(activateTime);

		String code = UUID.randomUUID().toString() + UUID.randomUUID().toString();
		code = code.replaceAll("-", "");
		user.setCode(code);
		user.setState(1);
		//注册新用户是默认不设置权限，所以权限置空
		Long roleIds = null;
		boolean signUpResult=userService.addUser(user, roleIds);
		if(signUpResult) {
			logger.info("新用户注册：" + user.getUsername() + "，注册时间：" + sdf.format(date)+"激活过期时间:" + sdf.format(activateTime));
			
			
		}
		return user;
	}

	//邮箱激活账号
	@RequestMapping("/activation")
	@ResponseBody
	public ModelAndView activation(String code) {
		logger.info("激活码["+code+"]正在激活用户...");
		String activationResult = userService.processActivate(code);

		ModelAndView mav = new ModelAndView("activation-result");
		mav.addObject("activationResult", activationResult);
		return mav;
	}

	@RequestMapping("/resendEmail")
	@ResponseBody
	public Integer resendEmail(String username){
		logger.info("正在重发用户"+username+"的激活邮件。");
		String path="http://dev.pydyun.com:8080/ims/activation";
		User user=userService.getUserByUsername(username);
		if(user!=null&&user.getState()==0){
			String email=user.getEmail();
			String code=user.getCode();
			boolean sendSignUpMailResult=systemService.sendSignUpMail(path,username,email,code);
			if(sendSignUpMailResult){
				logger.info("用户"+username+"邮箱验证邮件发送成功！");
				return 1;
			}else{
				logger.info("用户"+username+"邮箱验证邮件发送失败！");
				return 2;
			}
		}else{
			logger.info("用户"+username+"未注册或帐号不是未注册状态，不能发送激活邮件！");
			return 0;
		}
	}

	@RequestMapping("/updatePassword")
	@ResponseBody
	public Integer updatePassword(String username,String oldPassword,String newPassword) {
		boolean validationPassword = updatePasswordService.validationPassword(username, oldPassword);
		if (validationPassword) {
			boolean updatePasswordResult=updatePasswordService.updatePassword(username, newPassword);
			if(updatePasswordResult){
				logger.info("修改密码成功！");
				return 1;
			}else {
				logger.info("修改密码失败！");
				return 0;
			}
		}else{
			logger.info("原密码输入错误！");
			return 2;
		}
	}
	/**
	 * 发送验证码
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sendAuthCode", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public JSONObject sendAuthCode(String mobile) {
		String isRepeat = "no";
//		if (null != isReBind && !"".equals(isReBind) && "1".equals(isReBind)) {
//			Member member = null;
//			if (!StringUtil.isEmpty(tel)) {
//				member = memberMapper.selectByMobile(tel);
//			} else {
//				member = memberMapper.selectByUserId(Integer.parseInt(userId));
//				tel = member.getMobile();
//			}
//			if (member != null) {
//				isRepeat = "yes";
//			}
//		}
		/*//int authCode = (int) ((Math.random() * 9 + 1) * 100000);
		int authCode=610091;
		// 发送短信
		String msg = SmsSendUtil.sendSms(authCode + "", tel);
		JSONObject jb = JSONObject.fromObject(msg);
		String code = jb.getString("code");
		if (!"0".equals(code)) {
			throw new BaseRuntimeException("短信发送失败" + jb.getString("errorMsg"));
		}
		MobileMsg mobileMsg = new MobileMsg();
		mobileMsg.setMobile(tel);
		mobileMsg.setStartDatetime(new Date());
		// 生成验证码6位随机数
		// mobileMsg.setCode("123456");
		mobileMsg.setCode(authCode + "");
		mobileMsgMapper.insertCode(mobileMsg);
		mobileMsg = null;
		// 发送验证码
		return authCode+"";*/
		return null;	
	}


}