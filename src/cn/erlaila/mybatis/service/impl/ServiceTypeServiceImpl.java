package cn.erlaila.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.ServiceTypeMapper;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.service.ServiceTypeService;

public class ServiceTypeServiceImpl implements ServiceTypeService {

	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	
	@Override
	public ServiceType selectServiceType(Integer serviceTypeId)
			throws Exception {
		ServiceType serviceType=null;
		if(serviceTypeId!=null){
			serviceType=serviceTypeMapper.selectByPrimaryKey(serviceTypeId);			
		}
		return serviceType;
	}

}
