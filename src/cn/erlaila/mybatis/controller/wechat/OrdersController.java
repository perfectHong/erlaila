package cn.erlaila.mybatis.controller.wechat;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;





























import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.service.FavourableService;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.NurseOrdersService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.service.ServiceTypeService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.WechatOrdersService;
import cn.erlaila.mybatis.service.impl.OrdersServiceImp;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/orders")
public class OrdersController {
		
		private Logger logger = LoggerFactory.getLogger(OrdersController.class);
	    
		@Autowired
		private UserService userService;
		
		@Autowired
		private LogsService logsService;
		
		@Autowired
		private OrdersService ordersService;
		
		@Autowired
		private NurseOrdersService nurseOrdersService;
		
		@Autowired
		private WechatOrdersService wechatOrdersService;
		
		@Autowired
		private FavourableService favourableService;
		
		@Autowired
		private ServiceTypeService serviceTypeService;

		/**
		 * 
		 * @Title: insertOrder
		 * @date:2018��5��12������10:04:58
		 * @Description: TODO ���ɶ���
		 * @param: @param orders
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/insertOrder")
		@ResponseBody
		public  String insertOrder(Orders orders,Integer payStatus,HttpServletRequest request) throws Exception {			
			System.out.println("payStatus=======================>"+payStatus);
			int typeId=(Integer) request.getSession().getAttribute("typeId");
			User user=(User)request.getSession().getAttribute("userWechat");
			int nurseId=(Integer) request.getSession().getAttribute("orderNurseId");//
			orders.setNurseId(nurseId);
			orders.setServicetypeId(typeId);
			orders.setUserId(user.getUserid());			
			int favourableId=orders.getFavourableid();//�Żݾ���
			String orderDuring=orders.getOrderDuring();//����ʱ��
			int servicetypeId=orders.getServicetypeId();//�������ͱ��
			//���㶩���۸�
			System.out.println("favourableId=====================>"+favourableId);
			int favourablemoney=0;//�Żݾ��Żݼ۸�
			if(favourableId!=0 && payStatus==1){//�����û����ڸ��Ż݄�,����ʹȫ��֧��
				favourablemoney=favourableService.selectFavourableById(favourableId).getFavourablemoney();					
			}
			System.out.println("favourablemoney=====================>"+favourablemoney);
			ServiceType serviceType=serviceTypeService.selectServiceType(servicetypeId);//��������
			
			int servicemu=serviceType.getPrice();//���񵥼�
			int orderDuringInt=Integer.parseInt(orderDuring);//����ʱ�� ������߼�Сʱ
			int orderPrice=servicemu*orderDuringInt-favourablemoney;
			System.out.println("orderPrice=====================>"+orderPrice);
			orders.setOrderMoney(orderPrice);
			//����֧��ģʽ  ȫ��֧��   ����֧�������ޣ�
			orders.setOrderMoneypay(orderPrice);//ȫ��֧��
			//orders.setOrderMoneypay((int) (orderPrice*0.2));//����֧��֧��
			//����ϵͳ����
			int orderid=ordersService.insertOrder(orders);
			//����΢���û�����
			WechatOrders wechatOrders=new WechatOrders();
			wechatOrders.setOrderid(orderid);
			wechatOrders.setWechatId(user.getUserid());
			int momey=orders.getOrderMoney();
			wechatOrders.setMoney(momey);
			int momeyPay=orders.getOrderMoneypay();
			wechatOrders.setMoneypay(momeyPay);
			wechatOrders.setPaystatus(0);
			wechatOrders.setServicestatus(0);
			wechatOrders.setNursestatus(0);
			int num1=wechatOrdersService.insertWechatOrders(wechatOrders);
			System.out.println("�Ѳ���΢���û�����=======>"+num1);
			System.out.println("����id:"+orderid);		
			//���뻤��������Ϣ
			nurseOrdersService.insertNurseOrder(orders);
			
			return orderid+"";	
		}
		
		/**
		 * 
		 * @Title: getOrderMess
		 * @date:2018��5��17������9:11:58
		 * @Description: TODO ��ȡ��������ϸ��Ϣ
		 * @param: @param orderid
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getOrderMess")		
		public @ResponseBody OrdersVo getOrderMess(Integer orderid) throws Exception {
			OrdersVo ordersVo=ordersService.selectOrderMess(orderid);
			return ordersVo;	
		}

}
