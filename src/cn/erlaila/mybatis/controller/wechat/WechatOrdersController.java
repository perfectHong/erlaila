package cn.erlaila.mybatis.controller.wechat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;
import cn.erlaila.mybatis.po.custom.WechatOrdersCustom;
import cn.erlaila.mybatis.po.vo.WechatOrdersVo;
import cn.erlaila.mybatis.service.LinkManService;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.service.ServiceTypeService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.WechatOrdersService;


@Controller
@RequestMapping("/wechatOrders")
public class WechatOrdersController {
	
	@Autowired
	private WechatOrdersService wechatOrdersService; 
	
	@Autowired
	private OrdersService  ordersService;
	
	@Autowired
	private NurseDetailService nurseDetailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LinkManService linkManService;
	
	@Autowired
	private ServiceTypeService serviceTypeService;
	
	
	/**
	 * 
	 * @Title: getOrdersByWechat
	 * @date:2018��5��23������10:18:32
	 * @Description: TODO ��ȡ΢���û��Ķ����������ú�ϵͳ����Idʱ ֻ�᷵��һ��ֵ 
	 * @param: @param request
	 * @param: @param wechatOrdersVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/getOrdersByWechat")		
	public @ResponseBody List<WechatOrdersVo> getOrdersByWechat(HttpServletRequest request,WechatOrdersVo wechatOrdersVo) throws Exception {
		//��ȡ΢���û���Ϣ
		User userWechat=(User)request.getSession().getAttribute("userWechat");
		int wechatUserId=userWechat.getUserid();
		wechatOrdersVo.setWechatId(wechatUserId);
		List<WechatOrdersVo> wovList=new ArrayList<WechatOrdersVo>();
		List<WechatOrders> list=wechatOrdersService.selectByWechat(wechatOrdersVo);	
		for (WechatOrders wechatOrders : list){
			int  serviceStatus=wechatOrders.getDelestatus();//�ų����û�ɾ���Ķ���
			if(serviceStatus==0){
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				WechatOrdersVo wechatOrdersVo2=new WechatOrdersVo();
				wechatOrdersVo2.setWechatOrders(wechatOrders);//����΢���û�������Ϣ
				//���һ���������ʦ��������Ϣ
				int ordersid=wechatOrders.getOrderid();
				Orders orders=ordersService.selectOrdersById(ordersid);//ϵͳ������Ϣ
				wechatOrdersVo2.setOrders(orders);//���ö�����Ϣ
				int servicetypeId = orders.getServicetypeId();
				ServiceType serviceType=serviceTypeService.selectServiceType(servicetypeId);
				wechatOrdersVo2.setServiceType(serviceType);//���û�����ϸ��Ϣ������������
				int linkmanId=orders.getLinkmanId();	
				Linkman linkman =linkManService.selectLinkManById(linkmanId);
				wechatOrdersVo2.setLinkman(linkman);//���û�����ϸ��Ϣ
				int nurseId=orders.getNurseId();//�����user��id
				System.out.println("=================>"+nurseId);
				Nursedetail nursedetail = nurseDetailService.selectNurseDetailByUserId(nurseId);
			
				wechatOrdersVo2.setNursedetail(nursedetail);//���û�����ϸ��Ϣ
				int userid=nursedetail.getUserid();
				User user=userService.seleteuserByUserid(userid);
				wechatOrdersVo2.setUser(user);//���û���������ϸ��Ϣ
				wovList.add(wechatOrdersVo2);
			}
		}
		return wovList;	
	}
	
	/**
	 * 
	 * @Title: finishWechatOrder
	 * @date:2018��5��23������11:03:41
	 * @Description: TODO ΢���û�ȷ�϶������
	 * @param: @param request
	 * @param: @param wechatOrders
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/finishWechatOrder")
	@ResponseBody 
	public String finishWechatOrder(HttpServletRequest request,WechatOrders wechatOrders) throws Exception {
		int orderid=wechatOrders.getOrderid();
		int n=wechatOrdersService.updateByorderIdSelective(orderid, wechatOrders);
		return n+"";
	}
	
	
	@RequestMapping("/deleWechatOrder")
	@ResponseBody 
	public String deleWechatOrder(HttpServletRequest request,Integer orderid) throws Exception {
		int n=wechatOrdersService.deleWechatOrder(orderid);
		return ""+n;
	}
}
