package com.bjsxt.sm.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * 加密算法的工具类
 * @author WangshSxt
 *
 */
@Component("encryptUtil")
public class EncryptUtil
{
	/**
	 * 加密字符串
	 * @param souStr 明文
	 * @return
	 */
	public String encodeStr(String souStr)
	{
		return DigestUtils.sha256Hex(souStr) ; 
	}
	
	public static void main(String[] args)
	{
		String souStr = "111111" ; 
		String md5Res = DigestUtils.md5Hex(souStr);
		System.out.println("md5:" + md5Res + ";长度:" + md5Res.length());
		
		String sha256Res = DigestUtils.sha256Hex(souStr);
		System.out.println("sha256Res:" + sha256Res + ";长度:" + sha256Res.length());
		
		String sha512Res = DigestUtils.sha512Hex(souStr);
		System.out.println("sha512Res:" + sha512Res + ";长度:" + sha512Res.length());
	
		EncryptUtil encryptUtil = new EncryptUtil() ; 
		String res = encryptUtil.encodeStr(souStr);
		System.out.println(res);
	}
}
