package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Linkman;

public interface LinkmanMapperCustom {
	
	/**
	 * 
	 * @Title: selectAll
	 * @date:2018年5月28日上午8:42:27
	 * @Description: TODO 查找用户创建的所有联系人
	 * @param: @param userid
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
    List<Linkman> selectAll(Integer userid);
    
    
    /**
     * 
     * @Title: getLinkManByStatus
     * @date:2018年5月28日下午12:51:37
     * @Description: TODO 选择用户创建的默认的地址
     * @param: @param userid
     * @param: @return   
     * @return: bulesky  
     * @throws
     */
    Linkman selectLinkManByStatus(Integer userid);
   
}