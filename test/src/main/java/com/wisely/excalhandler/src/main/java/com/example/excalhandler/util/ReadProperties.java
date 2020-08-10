package com.example.excalhandler.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件信息
 * 
 * @author Administrator
 * 
 */
public class ReadProperties {

	private String filePath = "/bootstrap.properties";
	private Properties property;

	public ReadProperties(String filePath) {
		if (!("").equals(filePath)) {
			this.filePath = filePath;
		}
		property = new Properties();

		try {
			InputStream in = ReadProperties.class
					.getResourceAsStream(this.filePath);
			property.load(in);
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String getValue(String key) {
		if (this.property.containsKey(key)) {
			return this.property.getProperty(key);
		} else {
			return "";
		}
	}
	
}
