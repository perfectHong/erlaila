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
	 * @date:2018年5月9日下午2:00:02
	 * @Description: TODO新增联系人
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
	 * @date:2018年5月20日下午6:57:14
	 * @Description: TODO 根据联系人id 查询联系人信息
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
	 * @date:2018年5月27日下午10:28:02
	 * @Description: TODO 查找所有联系人
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<Linkman> selectAll(Integer userid) throws Exception;
	
	/**
	 * 
	 * @Title: deleteById
	 * @date:2018年5月28日上午8:35:31
	 * @Description: TODO 根据联系人删除联系人信息
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
	 * @date:2018年5月28日上午9:00:29
	 * @Description: TODO 根据用户的id更改默认地址
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
	 * @date:2018年5月28日上午10:06:01
	 * @Description: TODO 根据联系人id修改联系人详情
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
	 * @date:2018年5月28日下午12:53:23
	 * @Description: TODO 选择用户创建的默认的地址
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Linkman selectLinkManByStatus(Integer userid) throws Exception;
	
}
