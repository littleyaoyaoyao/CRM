package com.yao.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class MyStringUtils {
	public static String getMD5Value(String value){
		try {
			//1 获得jdk提供消息摘要算法工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2 加密的结果10进制
			byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
			//3将10进制 转换16进制
//			System.out.println(Arrays.toString(md5ValueByteArray));
			BigInteger bigInteger = new BigInteger(1 , md5ValueByteArray);
			
			
			return bigInteger.toString(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
			//如果出现了异常，将默认值
			//return value;
		}
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
