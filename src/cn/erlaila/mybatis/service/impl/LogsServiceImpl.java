package cn.erlaila.mybatis.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.LogsMapper;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.util.GetRealIp;

public class LogsServiceImpl implements LogsService{
	
	@Autowired
	private LogsMapper logsMapper;

	@Override
	public int insertLogs(int userid, String classname, String method,
			String operationname, String operationip, boolean iswechatuser)
			throws Exception {
		Date operationtime=new Date();
		Logs logs=new Logs();
		logs.setClassname(classname);
		logs.setIswechatuser(iswechatuser);
		logs.setMethod(method);
		logs.setOperationip(operationip);
		logs.setOperationname(operationname);
		logs.setOperationtime(operationtime);
		logs.setUserid(userid);
		int num=logsMapper.insert(logs);
		return num;
	}
	
}
