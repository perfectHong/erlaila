package cn.erlaila.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.LinkmanMapper;
import cn.erlaila.mybatis.mapper.NurseOrdersMapper;
import cn.erlaila.mybatis.mapper.ServiceTypeMapper;
import cn.erlaila.mybatis.mapper.UserMapper;
import cn.erlaila.mybatis.mapper.custom.NurseOrdersMapperCustom;
import cn.erlaila.mybatis.mapper.custom.WechatOrdersMapperCustom;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;
import cn.erlaila.mybatis.po.vo.NurseOrdersVo;
import cn.erlaila.mybatis.service.NurseOrdersService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.po.vo.OrdersVo;

public class NurseOrdersServiceImpl implements NurseOrdersService{

	@Autowired
	private NurseOrdersMapper nurseOrdersMapper;
	
	@Autowired
	private NurseOrdersMapperCustom nurseOrdersMapperCustom;
	
	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private LinkmanMapper linkmanMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private WechatOrdersMapperCustom wechatOrdersMapperCustom;
	
	@Override
	public int insertNurseOrder(Orders order) throws Exception {
		//向护工订单插入数据库
		int nurseid=order.getNurseId();
		int orderid=order.getOrderid();
		Integer servicetypeid=order.getServicetypeId();
		ServiceType serviceType = serviceTypeMapper.selectByPrimaryKey(servicetypeid);
		int Nursegetmoney=serviceType.getNursegetmoney();
		int orderDuring=Integer.parseInt(order.getOrderDuring());
		int money=Nursegetmoney*orderDuring;
		NurseOrders nurseOrders = new NurseOrders();
		nurseOrders.setNurseId(nurseid);
		nurseOrders.setOrderid(orderid);
		nurseOrders.setMoney(money);
		nurseOrders.setMoneyStatus(0);
		nurseOrders.setStatus(0);//护工接单状况
		int n= nurseOrdersMapper.insertSelective(nurseOrders);
		return n;
	}
	
	/*
	@Override
	public List<NurseOrdersCustom> selectOrderByNurse(Integer nurseid) throws Exception {
		NurseOrdersCustom nurseOrdersCustom	=new NurseOrdersCustom();
		List<NurseOrdersCustom> nurseOrdersList = nurseOrdersMapperCustom.selectOrderByNurseId(nurseid);
		//返回的集合
		List<NurseOrdersCustom> nurseOrdersList2 = new ArrayList<>();
		for (NurseOrdersCustom nurseOrdersCustom2 : nurseOrdersList) {
			int ordersId=nurseOrdersCustom2.getOrderid();
			Orders orders=ordersService.selectOrdersById(ordersId);
			nurseOrdersCustom2.setOrders(orders);
			nurseOrdersList2.add(nurseOrdersCustom2);
		}
		return nurseOrdersList;
	}
   */
	
	@Override
	public List<NurseOrdersCustom> selectOrderByNurseAndStatus(NurseOrdersVo nurseOrdersVo) throws Exception {
		List<NurseOrdersCustom> list=nurseOrdersMapperCustom.selectOrderByNurseAndStatus(nurseOrdersVo);
		
		List<NurseOrdersCustom> nurseOrdersList2 = new ArrayList<>();
		for (NurseOrdersCustom nurseOrdersCustom2 : list) {
			//更新订单
			int ordersId=nurseOrdersCustom2.getOrderid();
			Orders orders=ordersService.selectOrdersById(ordersId);
			nurseOrdersCustom2.setOrders(orders);

			//更新订单创造者信息
			int userId=orders.getUserId();
			System.out.println("userId============>"+userId);
			User user=userMapper.selectByPrimaryKey(userId);
			nurseOrdersCustom2.setUser(user);
			
			//更新联系人信息
			int linkmanId=orders.getLinkmanId();
			Linkman linkman = linkmanMapper.selectByPrimaryKey(linkmanId);
			nurseOrdersCustom2.setLinkman(linkman);
			
			//更新服务类型
			int servicetypeId=orders.getServicetypeId();
			ServiceType  serviceType = serviceTypeMapper.selectByPrimaryKey(servicetypeId);
			nurseOrdersCustom2.setServiceType(serviceType);
			
			nurseOrdersList2.add(nurseOrdersCustom2);
		}
		return nurseOrdersList2;
	}

	@Override
	public int updateNurseOrdersByOrderId(
			NurseOrdersVo nurseOrdersVo) throws Exception {
		//修改护工订单状态
		int n=nurseOrdersMapperCustom.updateNurseOrdersByOrderId(nurseOrdersVo);
		//修改客户订单状态
		WechatOrders wechatOrders=new WechatOrders();
		int orderId=nurseOrdersVo.getOrderId();//系统订单id
		wechatOrders.setOrderid(orderId);
		int Status=nurseOrdersVo.getStatus();//护工接单状态 ，0为待接单，1为已接单，2为正在服务，3为服务已完成,4为已拒接
		//服务状态，0为未服务，1为正在服务，2为服务完成
		System.out.println("=========护工接单状态=========>"+Status);
		System.out.println("=========护工接单状态=========>"+Status);
		System.out.println("=========护工接单状态=========>"+Status);
		if(Status==1){//护工接单
			wechatOrders.setNursestatus(1);
		}
		if(Status==4){//护工拒接
			wechatOrders.setNursestatus(4);
		}
		if(Status==2){//护工正在服务
			wechatOrders.setServicestatus(1);
		}
		if(Status==3){//护工服务完成
			wechatOrders.setServicestatus(2);
		}		
		wechatOrdersMapperCustom.updateByorderIdSelective(wechatOrders);
		return n;
	}

}
