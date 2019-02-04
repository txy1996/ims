package com.pydyun.ims.util;

import java.util.Random;

public class RandomMeail {
	public static final char[] chars = {'A','B','C','D','E','F','G','H','I','J','K','L',
			'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k',
			'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
	public static Random random = new Random();
	public static String getRandom() {
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<6;i++) {
			sb.append(chars[random.nextInt(chars.length)]);
		}
		return sb.toString();
	}
}
