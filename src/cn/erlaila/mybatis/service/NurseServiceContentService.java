package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.User;

public interface NurseServiceContentService {
	
	/**
	 * 
	 * @Title: insertServiceContent
	 * @date:2018年5月24日下午7:48:42
	 * @Description: TODO 插入护工服务类型  执行逻辑，先查询出该护工之前选择的服务类型，假如有的话把之前的数据删除
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
	 * @date:2018年5月25日下午6:47:34
	 * @Description: TODO  根据服务类型查询所有满足改服务类型的陪护人员
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
	 * @date:2018年5月11日下午5:05:59
	 * @Description: TODO 根据服务类型查询可以做该服务的所有护工
	 * @param: @param servicecontentId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 
	public User selectedUserByService(Integer servicecontentId) throws Exception;
	*/
}
