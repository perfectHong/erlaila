package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.vo.NurseOrdersVo;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;

public interface NurseOrdersMapperCustom {
    
	/**
	 * 
	 * @Title: selectOrderByNurseId
	 * @date:2018年5月22日下午4:26:57
	 * @Description: TODO  根据护工id查询该护工的so'y
	 * @param: @param nurseid
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 
	public List<NurseOrdersCustom> selectOrderByNurseId(Integer nurseid);
	*/
	
	
	/**
	 * @Title: selectOrderByNurseAndStatus
	 * @date:2018年5月18日上午10:12:11
	 * @Description: TODO 根据护工id 和 订单状态查询该订单
	 * @param: @param nurseOrdersVo
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public List<NurseOrdersCustom> selectOrderByNurseAndStatus(NurseOrdersVo nurseOrdersVo);
	
	/**
	 * 
	 * @Title: updateNurseOrdersByOrderId
	 * @date:2018年5月22日下午4:32:02
	 * @Description: TODO 修改护工订单状态
	 * @param: @param nurseOrdersVo
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateNurseOrdersByOrderId(NurseOrdersVo nurseOrdersVo);
		
}