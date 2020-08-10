package com.example.excalhandler.util.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * RSAEncrypt
 * 
 * @author
 * @see
 */
public class EncryptUtils {


	public static String encode(String str) {
		String enStr = encrypt(str, KEY_STR);
		try {
			return URLEncoder.encode(enStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decode(String str) throws Exception {
		//System.out.println("undeURLstr : " + str);		
		try {
			String deurlStr = URLDecoder.decode(str, "utf-8");
			//由于数据传输过程中，有可能在未知环节已经进行过一次URLDecoder，如再次decode，会将空格转换为'+'，影响
			//解密结果，因为id的加密并urlencode后的原串，不会存在空格，所以加上这次字符替换。
			String deurlStr2 = deurlStr.replace(' ', '+');
			return decrypt(deurlStr2, KEY_STR);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------- blow content : encrypt and decrypt -----------------------------
	// ------------------------------------------------------------------------------------------

	//public static String KEY_STR = getRandomString(16);
	public static String KEY_STR = "12345JKLMNabcdef";
	
	//public static String PASSWD = "tisplat||tisplat";
	public static String PASSWD = "tis_plat_encrypt";

	public static String encrypt(String content, String passwd) {
		if(null==content) {
			return null;
		}
		try {
			Cipher aesECB = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
			aesECB.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = aesECB.doFinal(content.getBytes());
			return new sun.misc.BASE64Encoder().encode(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String content, String passwd) throws Exception {
		if(null==content) {
			return null;
		}
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
			SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = new sun.misc.BASE64Decoder().decodeBuffer(content);
			return new String(cipher.doFinal(result)); // 解密
		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
			throw e;
		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
			throw e;
		} catch (InvalidKeyException e) {
//			e.printStackTrace();
			throw e;
		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
			throw e;
		} catch (BadPaddingException e) {
//			e.printStackTrace();
			throw e;
		} catch (IOException e) {
//			e.printStackTrace();
			throw e;
		}
//		return null;
	}
	
	public static String encrypt(String content) {
		return encrypt(content, PASSWD);
	}

	public static String decrypt(String content)  throws Exception {
		return decrypt(content, PASSWD);
	}

	
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(random.nextInt(range)));
		}
		return sb.toString();
	}
		
	protected static String bytesToString(byte[] encrytpByte) {
		String result = "";
		for (Byte bytes : encrytpByte) {
			result += (char) bytes.intValue();
		}
		return result;
	}
		
		

	public static void main(String[] args) throws Exception {
		String phone = "13010619";//身份证号
		String phone1 = "15732165082";//手机号
		String phone2 = "010-11111111";//座机号
		String phone3 = "0311-11111111";//座机号
//		String encodePhone = encode(phone);
//		String entryptPhone = encrypt(phone, "tisplat||tisplat");
		String entryptedPhone = encrypt(phone);
		String entryptedPhone1 = encrypt(phone1);
		String entryptedPhone2 = encrypt(phone2);
		String entryptedPhone3 = encrypt(phone3);
//		logger.info(encodePhone);
//		logger.info(decode(encodePhone));
//		logger.info(entryptPhone);
//		logger.info(decrypt(entryptPhone, "tisplat||tisplat"));
		String a= "2KM7dGJZBXAViZFhZhSaqA==";//2KM7dGJZBXAViZFhZhSaqA==
		System.out.println(a.getBytes("UTF-8").length+ "   " + a.getBytes().length%16);
//		logger.info("==|"+encrypt("")+"|==");
//		logger.info("==|"+decrypt("")+"|==");
//		logger.info(encrypt(null));
//		logger.info(decrypt(null));
	}

}