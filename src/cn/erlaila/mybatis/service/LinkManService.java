/**
 * 
 */
package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.Linkman;

public interface LinkManService {
	
	/**
	 * 
	 * @Title: insertLinkMan
	 * @date:2018��5��9������2:00:02
	 * @Description: TODO������ϵ��
	 * @param: @param linkman
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertLinkMan(Linkman linkman) throws Exception;
	
	/**
	 * 
	 * @Title: seleteLinkManById
	 * @date:2018��5��20������6:57:14
	 * @Description: TODO ������ϵ��id ��ѯ��ϵ����Ϣ
	 * @param: @param linkmanId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Linkman selectLinkManById(Integer linkmanId) throws Exception;
	
	/**
	 * 
	 * @Title: selectAll
	 * @date:2018��5��27������10:28:02
	 * @Description: TODO ����������ϵ��
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<Linkman> selectAll(Integer userid) throws Exception;
	
	/**
	 * 
	 * @Title: deleteById
	 * @date:2018��5��28������8:35:31
	 * @Description: TODO ������ϵ��ɾ����ϵ����Ϣ
	 * @param: @param linkManId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public  int deleteById(Integer linkManId) throws Exception;
	
	/**
	 * 
	 * @Title: updateStatusByUserId
	 * @date:2018��5��28������9:00:29
	 * @Description: TODO �����û���id����Ĭ�ϵ�ַ
	 * @param: @param userId
	 * @param: @param linkManId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public  int updateStatusByUserId(Integer userId,Integer linkManId) throws Exception;
	
	
	/**
	 * 
	 * @Title: updateLinkManById
	 * @date:2018��5��28������10:06:01
	 * @Description: TODO ������ϵ��id�޸���ϵ������
	 * @param: @param linkManId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateLinkManById(Linkman linkman) throws Exception;
	
	/**
	 * 
	 * @Title: selectLinkManByStatus
	 * @date:2018��5��28������12:53:23
	 * @Description: TODO ѡ���û�������Ĭ�ϵĵ�ַ
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Linkman selectLinkManByStatus(Integer userid) throws Exception;
	
}
