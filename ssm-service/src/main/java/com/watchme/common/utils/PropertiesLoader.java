/**
 * Copyright (c) 2005-2011 springside.org.cn
 * 
 * $Id: PropertiesLoader.java 1690 2012-02-22 13:42:00Z calvinxiu $
 */
package com.watchme.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

public class PropertiesLoader {

	private static Properties properties;

	public static Properties createInstance(String... resourcesPaths) {

		return createInstance(false, resourcesPaths);
	}

	/**
	 * 
	 * @param flag:true:强制重新加载、false：不重新加载
	 * @param resourcesPaths
	 * @return
	 */
	public static Properties createInstance(boolean flag, String... resourcesPaths) {

		if (flag) {
			if (resourcesPaths != null && resourcesPaths.length > 0) {
				properties = loadProperties(resourcesPaths);
			}
			if (properties == null) {
				properties = loadProperties("dsToolConfig.properties");
			}
		} else {
			if (properties == null) {
				if (resourcesPaths != null && resourcesPaths.length > 0) {
					properties = loadProperties(resourcesPaths);
				}
				if (properties == null) {
					properties = loadProperties("dsToolConfig.properties");
				}
			}
		}

		return properties;
	}

	private PropertiesLoader(String... resourcesPaths) {
		properties = loadProperties(resourcesPaths);
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * 取出Property，但以System的Property优先,取不到返回空字符串.
	 */
	private String getValue(String key) {
		String systemProperty = System.getProperty(key);
		if (systemProperty != null) {
			return systemProperty;
		}
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return "";
	}

	/**
	 * 取出String类型的Property，但以System的Property优先,如果都为Null则抛出异常.
	 */
	public String getProperty(String key) {
		String value = getValue(key);
		if (value == null) {
			throw new NoSuchElementException();
		}
		return value;
	}

	/**
	 * 取出String类型的Property，但以System的Property优先.如果都为Null则返回Default值.
	 */
	public String getProperty(String key, String defaultValue) {
		String value = getValue(key);
		return value != null ? value : defaultValue;
	}

	/**
	 * 载入多个文件, 文件路径使用Spring Resource格式.
	 */
	private static Properties loadProperties(String... resourcesPaths) {
		Properties props = new Properties();

		for (String location : resourcesPaths) {
			InputStream fis = null;
			try {
				fis = PropertiesLoader.class.getClassLoader().getResourceAsStream(location);
				props.load(fis);
			} catch (IOException ex) {
				System.err.println("Could not load properties from path:" + location + ", " + ex.getMessage());
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return props;
	}
}
