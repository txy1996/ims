package com.pydyun.ims.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述:
 * @author jiangTeng
 *
 */
public class GetTimestamp {
	/**
	 * 方法描述：默认获取当前电脑的时间戳,并以yyyy-MM-dd HH:mm:ss格式返回
	 * @return (String)
	 */
	public static String getTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 * 方法描述：获取当前电脑时间戳
	 * @param format :时间格式
	 * @return (String) 
	 */
	public static String getTimestamp(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	/**
	 * 方法描述：转换成日期对象
	 * @param format:时间格式 与要转的日期格式保持一致
	 * @param time : 要转的时间 
	 * @return (Date)
	 */
	public static Date getTimestamp(String format,String time) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("输入的时间格式有误");
			e.printStackTrace();
			return null;
		}
	}
}
