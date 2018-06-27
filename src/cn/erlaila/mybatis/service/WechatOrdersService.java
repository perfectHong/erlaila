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
	 * @date:2018��5��20������1:56:49
	 * @Description: TODO �����û�id��ѯ�û������ж���
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
	public List<WechatOrders> selectByWechat(WechatOrdersVo wechatOrdersVo) throws Exception;
	
	/**
	 * 
	 * @Title: insertWechatOrders
	 * @date:2018��5��20������2:52:16
	 * @Description: TODO ����΢���û�����
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
	 * @date:2018��5��20������3:38:55
	 * @Description: TODO �޸�΢�Ŷ�����Ϣ
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
	 * @date:2018��5��30������2:41:46
	 * @Description: TODO ΢���û�ɾ������
	 * @param: @param orderid
	 * @param: @param wechatOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int deleWechatOrder(Integer orderid) throws Exception;
	
}
