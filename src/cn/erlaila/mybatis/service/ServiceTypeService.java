package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.ServiceType;

public interface ServiceTypeService {
	
	/**
	 * 
	 * @Title: selectServiceType
	 * @date:2018年5月18日上午8:30:56
	 * @Description: TODO 查找服务类型
	 * @param: @param serviceTypeId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public ServiceType selectServiceType(Integer serviceTypeId) throws Exception;
	
	
}
