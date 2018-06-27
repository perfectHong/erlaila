package cn.erlaila.mybatis.util;

import java.util.ResourceBundle;

public class WechatResource {
    public static String getProperty(String key) {    
        ResourceBundle rb = ResourceBundle.getBundle("wechat");
        String value=rb.getString(key);
        return value;  
    }  
}
