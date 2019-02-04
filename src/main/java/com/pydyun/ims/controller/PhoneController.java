package com.pydyun.ims.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pydyun.ims.util.SendMsg_webchinese;

public class PhoneController {
	private static final String VALIDATE_PHONE_CODE = "VALIDATE_PHONE_CODE";  
	private static final String VALIDATE_PHONE = "VALIDATE_PHONE";  
	private static final String SEND_CODE_TIME = "SEND_CODE_TIME";  
	 @RequestMapping("index.html")  
	    protected String index() {  
	        return "phone/list";  
	    }  
	  @RequestMapping("sendCode.html")  
	    @ResponseBody  
	    protected void sendCode(String phone, HttpServletRequest request) throws HttpException, IOException {  
	        StringBuilder code = new StringBuilder();  
	        Random random = new Random();  
	        // 6位验证码  
	        for (int i = 0; i < 6; i++) {  
	            code.append(String.valueOf(random.nextInt(10)));  
	        }  
	        HttpSession session = request.getSession();  
	        session.setAttribute(VALIDATE_PHONE, phone);  
	        session.setAttribute(VALIDATE_PHONE_CODE, code.toString());  
	        session.setAttribute(SEND_CODE_TIME, new Date().getTime());  
	        String smsText = "验证码：" + code;  
	        System.out.println("手机号：" + phone + ", " + smsText);  
	        SendMsg_webchinese.sendMessage(phone, smsText);  
	    }  
	      
	    @RequestMapping("validate.html")  
	    @ResponseBody  
	    protected String validate(HttpServletRequest request){  
	        HttpSession session = request.getSession();  
	        String code = (String) session.getAttribute(VALIDATE_PHONE_CODE);  
	        String phone = (String) session.getAttribute(VALIDATE_PHONE);  
	        String inputCode = request.getParameter("code");  
	        String inputPhone = request.getParameter("phone");  
	        if(phone.equals(inputPhone) && code.equalsIgnoreCase(inputCode)){  
	            return "success";  
	        }else{  
	            return "failure";  
	        }  
	    }  
}
