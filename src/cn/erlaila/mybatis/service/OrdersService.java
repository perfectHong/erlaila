/**
 * 
 */
package cn.erlaila.mybatis.service;

import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.vo.OrdersVo;

/**
 * 
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��12�� ����9:27:04
 * @�汾 V 1.0
 */
public interface OrdersService {
	
	/**
	 * 
	 * @Title: insertOrder
	 * @date:2018��5��12������9:26:49
	 * @Description: TODO  ���ɶ���,�����ض�����id
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
	 * @date:2018��5��12������12:51:45
	 * @Description: TODO  ���ݶ������Ҷ�����ϸ��Ϣ
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
	 * @date:2018��5��12������5:12:03
	 * @Description: TODO ���ݶ���id��ѯ��������Ϣ
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
	 * @date:2018��5��12������5:13:17
	 * @Description: TODO ���ݶ�����Ÿ��Ķ�����Ϣ
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
	 * @date:2018��5��12������8:23:29
	 * @Description: TODO �����̻�������ȥ�޸Ķ���
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
	 * @date:2018��5��12������8:29:29
	 * @Description: TODO �����̻���Ų�ѯ����
	 * @param: @param orderWechat
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Orders selectOrderBytradeNo(String orderWechat) throws Exception;
}
