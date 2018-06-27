package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.User;

public interface NurseServiceContentService {
	
	/**
	 * 
	 * @Title: insertServiceContent
	 * @date:2018��5��24������7:48:42
	 * @Description: TODO ���뻤����������  ִ���߼����Ȳ�ѯ���û���֮ǰѡ��ķ������ͣ������еĻ���֮ǰ������ɾ��
	 * @param: @param userid
	 * @param: @param list
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertServiceContent(Integer userid,List<NurseServiceContent> list) throws Exception;
	
	/**
	 * 
	 * @Title: selectCountByServiceId
	 * @date:2018��5��25������6:47:34
	 * @Description: TODO  ���ݷ������Ͳ�ѯ��������ķ������͵��㻤��Ա
	 * @param: @param serviceTypeId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int selectCountByServiceId(Integer serviceTypeId) throws Exception;
	/**
	 * 
	 * @Title: selectedUserByService
	 * @date:2018��5��11������5:05:59
	 * @Description: TODO ���ݷ������Ͳ�ѯ�������÷�������л���
	 * @param: @param servicecontentId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 
	public User selectedUserByService(Integer servicecontentId) throws Exception;
	*/
}
