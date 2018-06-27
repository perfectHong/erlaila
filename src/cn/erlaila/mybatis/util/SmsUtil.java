package cn.erlaila.mybatis.util;

import java.util.Random;

import com.alibaba.fastjson.JSON;

public class SmsUtil {

	public static String createCode(int n) {
		String str = "0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(10); // [0-9] 间随机数
			char ch = str.charAt(index);
			sb.append(ch + "");
		}
		return sb.toString();
	}

//	private static String url = "http://smssh1.253.com/msg/send/json";
//
//	private static String account = "CN6446153";
//	// 发送短信的账号(非登录账号)
//	// (示例:N987654)
//	private static String pswd = "AT~_rLynfZ5t&";
//	// 发送短信的密码(非登录密码)

	
}
