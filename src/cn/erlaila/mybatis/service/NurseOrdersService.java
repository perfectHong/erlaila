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
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月12日 上午9:27:04
 * @版本 V 1.0
 */
public interface NurseOrdersService {
	
	/**
	 * 
	 * @Title: insertNurseOrder
	 * @date:2018年5月18日上午8:15:43
	 * @Description: TODO 插入护工订单
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
	 * @date:2018年5月18日上午9:24:35
	 * @Description: TODO 根据护工查询护工的订单(所有)
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
	 * @date:2018年5月18日上午9:24:35
	 * @Description: TODO 根据护工的订单状态查询护工的订单
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
	 * @date:2018年5月22日下午4:39:46
	 * @Description: TODO 根据订单去修改护工订单的状态
	 * @param: @param nurseOrdersVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateNurseOrdersByOrderId(NurseOrdersVo nurseOrdersVo) throws Exception;
}
