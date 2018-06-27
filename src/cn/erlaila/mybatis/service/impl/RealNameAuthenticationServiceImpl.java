package cn.erlaila.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.custom.RealNameAuthenticationMapperCustom;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.service.RealNameAuthenticationService;

public class RealNameAuthenticationServiceImpl implements RealNameAuthenticationService{
	
	@Autowired
	private RealNameAuthenticationMapperCustom realNameAuthenticationMapperCustom;
	
	@Override
	public RealNameAuthentication selectByUserId(Integer userid)
			throws Exception {
		RealNameAuthentication realNameAuthentication =realNameAuthenticationMapperCustom.selectByUserId(userid);
		return realNameAuthentication;
	}

}
