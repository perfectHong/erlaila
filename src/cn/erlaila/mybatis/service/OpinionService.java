package cn.erlaila.mybatis.service;

import cn.erlaila.mybatis.po.Opinion;

/**
 * 
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月23日 下午9:40:54
 * @版本 V 1.0
 */
public interface OpinionService {
	
	/**
	 * 
	 * @Title: insertOpinion
	 * @date:2018年5月23日下午9:44:39
	 * @Description: TODO 插入用户使用意见
	 * @param: @param opinion
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertOpinion(Opinion opinion) throws Exception;
}
