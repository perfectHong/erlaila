/**
 * 
 */
package cn.erlaila.mybatis.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.LinkmanMapper;
import cn.erlaila.mybatis.mapper.NursedetailMapper;
import cn.erlaila.mybatis.mapper.OrdersMapper;
import cn.erlaila.mybatis.mapper.ServiceTypeMapper;
import cn.erlaila.mybatis.mapper.UserMapper;
import cn.erlaila.mybatis.mapper.custom.OrdersMapperCustom;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.service.LinkManService;
import cn.erlaila.mybatis.service.OrdersService;

    /**  
 * @ClassName: OrdersServiceImp  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author 孟凡红  
 * @date 2018年5月8日  下午5:38:54
 *    
 */
public class OrdersServiceImp implements OrdersService{

	@Autowired
	private OrdersMapper orderMapper;
	
	@Autowired
	private OrdersMapperCustom orderMapperCustom;
	
	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	
	@Autowired
	private NursedetailMapper nursedetailMapper;
	
	@Autowired
	private LinkmanMapper linkmanMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insertOrder(Orders orders) throws Exception {
		Date date=new Date();
		orders.setOrderTime(date);//订单生成时间
		orders.setOrderStatus(0);	
		int n=orderMapper.insertSelective(orders);
		int orderid=orders.getOrderid();
		return orderid;
	}

	@Override
	public OrdersVo selectOrderMess(Integer orderid) throws Exception {
		OrdersVo ordersVo=new OrdersVo();
		Orders orders = orderMapper.selectByPrimaryKey(orderid);
		int servicetypeId=orders.getServicetypeId();
		ServiceType serviceType = serviceTypeMapper.selectByPrimaryKey(servicetypeId);
		int nurseid=orders.getNurseId();
		Nursedetail nursedetail = nursedetailMapper.selectByPrimaryKey(nurseid);
		int linkmanId = orders.getLinkmanId();
		Linkman linkman = linkmanMapper.selectByPrimaryKey(linkmanId);
		int userid=orders.getUserId();
		User user= userMapper.selectByPrimaryKey(userid);
		ordersVo.setLinkman(linkman);
		ordersVo.setOrders(orders);
		ordersVo.setServiceType(serviceType);
		ordersVo.setNursedetail(nursedetail);
		ordersVo.setUser(user);
		return ordersVo;
	}

	@Override
	public Orders selectOrdersById(Integer orderid) throws Exception {
		Orders order=orderMapper.selectByPrimaryKey(orderid);
		return order;
	}

	@Override
	public int updateOrdersById(Integer orderid,Orders orders) throws Exception {
		int n=0;
		if(orderid!=null){
			n=orderMapper.updateByPrimaryKeySelective(orders);			
		}		
		return n;
	}

	@Override
	public int updateByOuttradenoSelective(String orderWechat, Orders orders)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orders selectOrderBytradeNo(String orderWechat) throws Exception {
		Orders  order=orderMapperCustom.selectOrderBytradeNo(orderWechat);
		return order;
	}


}
