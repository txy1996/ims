package com.pydyun.ims.util;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
//	private static String to = "18883903107";
	private static String codeNum = Code.codeNum(6);
//	private static String smsContent = "【待客之道】您的验证码为"+Code.codeNum(6)+"，请于2分钟内正确输入，如非本人操作，请忽略此短信。";
	private static String smsContent = "【待客之道】您的验证码为"+codeNum+"，请于2分钟内正确输入，如非本人操作，请忽略此短信。";
	
	public static final String[] CODE_STATUS  = new String[] {"00141"};
	public static final String[] CODE_INSTRUCTIONS= new String[] {"	未知错误，请联系技术客服。"};
	/**
	 * 验证码通知短信
	 * @param to:手机号
	 */
	public static boolean execute(String to){
		if(to.length() == 11) {
			if(to.matches("1(3|5|7|8)[\\d]{9}")) {
				String url = Config.BASE_URL + operation;
				String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
						+ HttpUtil.createCommonParam();
				// 提交请求
				String result = HttpUtil.post(url, body);
				System.out.println("result:" + System.lineSeparator() + result);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	/**
	 * 验证码通知短信
	 * @param to:手机号
	 */
	public static String executeString(String to){
		if(to.length() == 11) {
			if(to.matches("1(3|5|7|8)[\\d]{9}")) {
				String url = Config.BASE_URL + operation;
				String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
						+ HttpUtil.createCommonParam();
				// 提交请求
				String result = HttpUtil.post(url, body);
				System.out.println("result:" + System.lineSeparator() + result);
				String status = result.substring(13, 18);
				System.out.println("status"+status);
				String statusInsturtions =  getCodeStatusInsturtions(status);
				if(statusInsturtions!=null) {
					System.out.println("statusInsturtions"+statusInsturtions);
					return statusInsturtions;
				}
				return codeNum;
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	
	
	public static void main(String[] args) {
		String ssss = "{\"respCode\":\"00141\",\"respDesc\":\"一小时内发送给单个手机次数超过限制(验证类短信：同一签名同一手机号码1小时内发送数次应小于等于4, 手机号=18883903107, 签名=待客之道)\"}";
		System.out.println(ssss);
		ssss = ssss.substring(13,18);
		System.out.println(ssss);
		
	}
	
	public static String getCodeStatusInsturtions(String status) {
		for (int i = 0; i < CODE_STATUS.length; i++) {
			if(status.equals(CODE_STATUS[i])){
				return CODE_INSTRUCTIONS[i];
			}
		}
		return null;
	}
}
