package cn.erlaila.mybatis.service;

import cn.erlaila.mybatis.po.RealNameAuthentication;

public interface RealNameAuthenticationService {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018��5��25������12:38:34
	 * @Description: TODO ����΢���û�id (userId)��ѯ�Ƿ��ύ��ʵ����֤����
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public RealNameAuthentication selectByUserId(Integer userid) throws Exception;
	
}
