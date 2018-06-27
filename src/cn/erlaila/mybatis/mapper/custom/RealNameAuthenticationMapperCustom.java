package cn.erlaila.mybatis.mapper.custom;

import cn.erlaila.mybatis.po.RealNameAuthentication;

public interface RealNameAuthenticationMapperCustom {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018年5月25日上午11:03:39
	 * @Description: TODO 根据微信用户id查询 user表中的id
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
 	public RealNameAuthentication selectByUserId(Integer userid);

}