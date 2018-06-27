package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.vo.WechatOrdersVo;

public interface WechatOrdersMapperCustom {
	
	/**
	 * 
	 * @Title: selectByUserId
	 * @date:2018��5��20������1:54:11
	 * @Description: TODO �����û���id ��ѯ�û������ж��� 
	 * @param: @param userId
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
    public  List<WechatOrders>  selectByWechat(WechatOrdersVo wechatOrdersVo);

    /**
     * 
     * @Title: updateByorderIdSelective
     * @date:2018��5��20������3:35:30
     * @Description: TODO ���ݶ��� id ����΢���û�������Ϣ
     * @param: @param orderid
     * @param: @param wechatOrders
     * @param: @return   
     * @return: bulesky  
     * @throws
     */
    public int updateByorderIdSelective(WechatOrders wechatOrders);
}