package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Orders;

public interface OrdersMapperCustom { 
    
	Orders selectOrderBytradeNo(String orderWechat);
	
	List<Orders> selectByLinkmanId(Integer linkmanId);
	
}