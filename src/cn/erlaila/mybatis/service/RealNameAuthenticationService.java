package cn.erlaila.mybatis.service;

import cn.erlaila.mybatis.po.RealNameAuthentication;

public interface RealNameAuthenticationService {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018年5月25日下午12:38:34
	 * @Description: TODO 根据微信用户id (userId)查询是否提交过实名认证材料
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public RealNameAuthentication selectByUserId(Integer userid) throws Exception;
	
}
