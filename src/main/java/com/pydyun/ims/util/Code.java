package com.pydyun.ims.util;


/**
 * 类描述：验证码
 * @author jianTeng
 *
 */
public class Code {
	/**
	 * 方法描述：数字验证码
	 * @param :验证码个数
	 * @return (String)
	 */
	public static String codeNum(int count) {
		StringBuilder code = new StringBuilder();
		for(int i = 0;i < count ;i++) {
			int num = (int)Math.floor(Math.random()*9);
			code.append(num);
		}
		return code.toString();
	}
	/**
	 * 类描述：字母数字混合验证码
	 * @param count :验证码个数
	 * @return(String)
	 */
	public static String code(int count) {
		//65-112
		StringBuilder code = new StringBuilder();
		int i = 0;
		int num = 0;
		while_:while(i < count) {
			num = (int)Math.floor(Math.random()*123);
			if(num > 64 && num < 123) {
				for(int j = 0 ; j < 6 ; j++) {
					if(num != (91+j)) {
						if(j == 5) {
							i++;
							char letter = (char)num;
							code.append(letter);
							continue while_;
						}
					}else {
						break;
					}
				}
			}
			num = (int)Math.floor(Math.random()*10);
			code.append(num);
			i++;
		}
		return code.toString();
	}
}
