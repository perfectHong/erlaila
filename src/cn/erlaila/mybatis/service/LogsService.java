package cn.erlaila.mybatis.service;

import javax.servlet.http.HttpServletRequest;

import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.User;

/**
 * 
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月6日 下午8:08:03
 * @版本 V 1.0
 */
public interface LogsService {
	
    /**
     * @Title: insertLogs
     * @date:2018年5月6日下午8:17:57
	 * @Description: TODO 系统操作日志记录
	 * @param: @param userid 用户id
	 * @param: @param classname  操作的类名
	 * @param: @param method   操作的方法名
	 * @param: @param operationname 操作的名称
	 * @param: @param operationip 操作人的真实IP地址
	 * @param: @param iswechatuser 是不是微信用户，微信用户：true,后台管理用户：false
	 * @param: @return 返回数据库中受影响的行数
	 * @param: @throws Exception   
	 * @return: bulesky 
     */
	public int insertLogs(int userid,String classname,String method,String operationname,String operationip,boolean iswechatuser) throws Exception;
}
