package cn.erlaila.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.OrdersMapper;
import cn.erlaila.mybatis.mapper.WechatOrdersMapper;
import cn.erlaila.mybatis.mapper.custom.WechatOrdersMapperCustom;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.vo.WechatOrdersVo;
import cn.erlaila.mybatis.service.WechatOrdersService;

public class WechatOrdersServiceImpl implements WechatOrdersService{

	@Autowired
	private WechatOrdersMapperCustom wechatOrdersMapperCustom;
	
	@Autowired
	private WechatOrdersMapper wechatOrdersMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public List<WechatOrders> selectByWechat(WechatOrdersVo wechatOrdersVo){	
		List<WechatOrders>  list=wechatOrdersMapperCustom.selectByWechat(wechatOrdersVo);
		return list;
	}

	@Override
	public int insertWechatOrders(WechatOrders wechatOrders) throws Exception {
		int n=wechatOrdersMapper.insertSelective(wechatOrders);
		return n;
	}

	@Override
	public int updateByorderIdSelective(Integer orderid,WechatOrders wechatOrders) throws Exception {
		int n=0;
		if(orderid!=null){
			n=wechatOrdersMapperCustom.updateByorderIdSelective(wechatOrders);		
		}	
		return n;
	}

	@Override
	public int deleWechatOrder(Integer orderid) throws Exception {
		WechatOrders wechatOrders=new WechatOrders();
		wechatOrders.setOrderid(orderid);
		wechatOrders.setDelestatus(1);
		
		int n=wechatOrdersMapperCustom.updateByorderIdSelective(wechatOrders);
		Orders orders = new Orders();
		orders.setOrderid(orderid);
		orders.setDelestatus(1);
		ordersMapper.updateByPrimaryKeySelective(orders);
		return n;
	}

}
