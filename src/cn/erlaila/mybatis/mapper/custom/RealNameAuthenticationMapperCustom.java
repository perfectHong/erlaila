package cn.erlaila.mybatis.mapper.custom;

import cn.erlaila.mybatis.po.RealNameAuthentication;

public interface RealNameAuthenticationMapperCustom {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018��5��25������11:03:39
	 * @Description: TODO ����΢���û�id��ѯ user���е�id
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
 	public RealNameAuthentication selectByUserId(Integer userid);

}