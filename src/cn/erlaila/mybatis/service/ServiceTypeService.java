package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.ServiceType;

public interface ServiceTypeService {
	
	/**
	 * 
	 * @Title: selectServiceType
	 * @date:2018��5��18������8:30:56
	 * @Description: TODO ���ҷ�������
	 * @param: @param serviceTypeId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public ServiceType selectServiceType(Integer serviceTypeId) throws Exception;
	
	
}
