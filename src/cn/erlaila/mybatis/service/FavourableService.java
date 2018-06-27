package cn.erlaila.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.FavourableMapper;
import cn.erlaila.mybatis.po.Favourable;

/**
 * 
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月19日 上午9:21:36
 * @版本 V 1.0
 */
public interface FavourableService {
	
	/**
	 * 
	 * @Title: selectFavourableByUser
	 * @date:2018年5月19日上午9:24:22
	 * @Description: TODO 通过优惠卷id获取到优惠卷信息
	 * @param: @param favourableId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Favourable selectFavourableById(Integer favourableId) throws Exception; 
	
}
