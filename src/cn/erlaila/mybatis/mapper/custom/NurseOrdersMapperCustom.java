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
	 * @date:2018��5��22������4:26:57
	 * @Description: TODO  ���ݻ���id��ѯ�û�����so'y
	 * @param: @param nurseid
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 
	public List<NurseOrdersCustom> selectOrderByNurseId(Integer nurseid);
	*/
	
	
	/**
	 * @Title: selectOrderByNurseAndStatus
	 * @date:2018��5��18������10:12:11
	 * @Description: TODO ���ݻ���id �� ����״̬��ѯ�ö���
	 * @param: @param nurseOrdersVo
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public List<NurseOrdersCustom> selectOrderByNurseAndStatus(NurseOrdersVo nurseOrdersVo);
	
	/**
	 * 
	 * @Title: updateNurseOrdersByOrderId
	 * @date:2018��5��22������4:32:02
	 * @Description: TODO �޸Ļ�������״̬
	 * @param: @param nurseOrdersVo
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateNurseOrdersByOrderId(NurseOrdersVo nurseOrdersVo);
		
}