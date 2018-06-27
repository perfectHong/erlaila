package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.vo.WechatOrdersVo;

public interface WechatOrdersMapperCustom {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018年5月20日下午1:54:11
	 * @Description: TODO 根据用户的id 查询用户的所有订单 
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
    public  List<WechatOrders>  selectByWechat(WechatOrdersVo wechatOrdersVo);

    /**
     * 
     * @Title: updateByorderIdSelective
     * @date:2018年5月20日下午3:35:30
     * @Description: TODO 根据订单 id 更改微信用户订单信息
     * @param: @param orderid
     * @param: @param wechatOrders
     * @param: @return   
     * @return: bulesky  
     * @throws
     */
    public int updateByorderIdSelective(WechatOrders wechatOrders);
}