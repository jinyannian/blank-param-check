package com.example.demo.config;

import org.jasypt.encryption.StringEncryptor;
import com.example.demo.utils.AesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class AesEncryptor implements StringEncryptor {

	@Value("${AESKEY}")
	private String aesKey;
	
	private Logger logger = LoggerFactory.getLogger(AesEncryptor.class);
	
	public String encrypt(String message) {
		String password = null;
		try {
			password = AesUtil.encrypt(message, aesKey);
		} catch (Exception e) {
			logger.error("密码加密错误");
		}
		return password;
	}

	public String decrypt(String encryptedMessage) {
		String password = null;
		try {
			password = AesUtil.decrypt(encryptedMessage, aesKey);
		} catch (Exception e) {
			logger.error("密码解密错误");
		}
		return password;
	}

}
