/**
 * 
 */
package cn.erlaila.mybatis.service;

import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.vo.OrdersVo;

/**
 * 
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月12日 上午9:27:04
 * @版本 V 1.0
 */
public interface OrdersService {
	
	/**
	 * 
	 * @Title: insertOrder
	 * @date:2018年5月12日上午9:26:49
	 * @Description: TODO  生成订单,并返回订单的id
	 * @param: @param orders  
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertOrder(Orders orders) throws Exception;
	
	/**
	 * 
	 * @Title: selectOrderMess
	 * @date:2018年5月12日下午12:51:45
	 * @Description: TODO  根据订单查找订单详细信息
	 * @param: @param orderid 
	 * @param: @return OrdersVo
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public OrdersVo selectOrderMess(Integer orderid) throws Exception;
	
	/**
	 * 
	 * @Title: selectOrdersById
	 * @date:2018年5月12日下午5:12:03
	 * @Description: TODO 根据订单id查询订单的信息
	 * @param: @param orderid
	 * @param: @return Orders
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Orders selectOrdersById(Integer orderid) throws Exception;
	
	/**
	 * 
	 * @Title: updateOrdersById
	 * @date:2018年5月12日下午5:13:17
	 * @Description: TODO 根据订单编号更改订单信息
	 * @param: @param orderid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateOrdersById(Integer orderid,Orders orders) throws Exception;
	
	
	/**
	 * 
	 * @Title: updateByOuttradenoSelective
	 * @date:2018年5月12日下午8:23:29
	 * @Description: TODO 根据商户订单号去修改订单
	 * @param: @param orderWechat
	 * @param: @param orders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateByOuttradenoSelective(String orderWechat,Orders orders) throws Exception;
	
	/**
	 * 
	 * @Title: selectOrderBytradeNo
	 * @date:2018年5月12日下午8:29:29
	 * @Description: TODO 根据商户编号查询订单
	 * @param: @param orderWechat
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Orders selectOrderBytradeNo(String orderWechat) throws Exception;
}
