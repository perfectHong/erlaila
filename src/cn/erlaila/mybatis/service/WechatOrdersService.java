package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.po.vo.WechatOrdersVo;

public interface WechatOrdersService{	

	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018年5月20日下午1:56:49
	 * @Description: TODO 根据用户id查询用户的所有订单
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public List<WechatOrders> selectByWechat(WechatOrdersVo wechatOrdersVo) throws Exception;
	
	/**
	 * 
	 * @Title: insertWechatOrders
	 * @date:2018年5月20日下午2:52:16
	 * @Description: TODO 插入微信用户订单
	 * @param: @param wechatOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertWechatOrders(WechatOrders wechatOrders) throws Exception;
	
	/**
	 * 
	 * @Title: updateByorderIdSelective
	 * @date:2018年5月20日下午3:38:55
	 * @Description: TODO 修改微信订单信息
	 * @param: @param orderid
	 * @param: @param wechatOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateByorderIdSelective(Integer orderid,WechatOrders wechatOrders) throws Exception;
	
	/**
	 * 
	 * @Title: deleWechatOrder
	 * @date:2018年5月30日下午2:41:46
	 * @Description: TODO 微信用户删除订单
	 * @param: @param orderid
	 * @param: @param wechatOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int deleWechatOrder(Integer orderid) throws Exception;
	
}
