/**
 * 
 */
package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.controller.wechat.NurseOrdersController;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;
import cn.erlaila.mybatis.po.vo.NurseOrdersVo;
import cn.erlaila.mybatis.po.vo.OrdersVo;

/**
 * 
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��12�� ����9:27:04
 * @�汾 V 1.0
 */
public interface NurseOrdersService {
	
	/**
	 * 
	 * @Title: insertNurseOrder
	 * @date:2018��5��18������8:15:43
	 * @Description: TODO ���뻤������
	 * @param: @param nurseOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertNurseOrder(Orders orders) throws Exception;
	
	/**
	 * 
	 * @Title: selectOrderByNurse
	 * @date:2018��5��18������9:24:35
	 * @Description: TODO ���ݻ�����ѯ�����Ķ���(����)
	 * @param: @param nurseid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 
	public List<NurseOrdersCustom> selectOrderByNurse(Integer nurseid) throws Exception;
	*/
	
	/**
	 * 
	 * @Title: selectOrderByNurseAndStatus
	 * @date:2018��5��18������9:24:35
	 * @Description: TODO ���ݻ����Ķ���״̬��ѯ�����Ķ���
	 * @param: @param nurseid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<NurseOrdersCustom> selectOrderByNurseAndStatus(NurseOrdersVo nurseOrdersVo) throws Exception;

	/**
	 * 
	 * @Title: updateNurseOrdersByOrderId
	 * @date:2018��5��22������4:39:46
	 * @Description: TODO ���ݶ���ȥ�޸Ļ���������״̬
	 * @param: @param nurseOrdersVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateNurseOrdersByOrderId(NurseOrdersVo nurseOrdersVo) throws Exception;
}
