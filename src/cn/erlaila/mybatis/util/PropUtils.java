package cn.erlaila.mybatis.util;

import org.apache.logging.log4j.util.PropertiesUtil;



public class PropUtils {
	static PropertiesUtil prop;

	static {
		prop = new PropertiesUtil("wechat.properties");
	}

	public static String getProperty(String name) {
		return prop.getStringProperty(name);
	}
}
