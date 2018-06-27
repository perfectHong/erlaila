package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Userfavourable;

public interface UserfavourableService {
	
	/**
	 * 
	 * @Title: selectFavourableByUser
	 * @date:2018年5月19日上午9:37:01
	 * @Description: TODO 通过用户id 获取微信用户可以使用的优惠卷
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<Favourable>  selectFavourableByUser(Integer userid) throws Exception; 
	
	/**
	 * 
	 * @Title: updateFavourableById
	 * @date:2018年5月21日下午6:31:12
	 * @Description: TODO 通过id更改用户优惠卷信息
	 * @param: @param favourableId
	 * @param: @param userFavourable
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateFavourableByUIdAndFId(Userfavourable userFavourable) throws Exception;
}
