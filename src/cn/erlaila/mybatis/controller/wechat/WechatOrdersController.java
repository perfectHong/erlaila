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
	 * @date:2018年5月23日上午10:18:32
	 * @Description: TODO 获取微信用户的订单，当设置好系统订单Id时 只会返回一个值 
	 * @param: @param request
	 * @param: @param wechatOrdersVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/getOrdersByWechat")		
	public @ResponseBody List<WechatOrdersVo> getOrdersByWechat(HttpServletRequest request,WechatOrdersVo wechatOrdersVo) throws Exception {
		//获取微信用户信息
		User userWechat=(User)request.getSession().getAttribute("userWechat");
		int wechatUserId=userWechat.getUserid();
		wechatOrdersVo.setWechatId(wechatUserId);
		List<WechatOrdersVo> wovList=new ArrayList<WechatOrdersVo>();
		List<WechatOrders> list=wechatOrdersService.selectByWechat(wechatOrdersVo);	
		for (WechatOrders wechatOrders : list){
			int  serviceStatus=wechatOrders.getDelestatus();//排除掉用户删除的订单
			if(serviceStatus==0){
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				System.out.println("=============================>"+serviceStatus);
				WechatOrdersVo wechatOrdersVo2=new WechatOrdersVo();
				wechatOrdersVo2.setWechatOrders(wechatOrders);//设置微信用户订单信息
				//查找护工（陪聊师）基本信息
				int ordersid=wechatOrders.getOrderid();
				Orders orders=ordersService.selectOrdersById(ordersid);//系统订单信息
				wechatOrdersVo2.setOrders(orders);//设置订单信息
				int servicetypeId = orders.getServicetypeId();
				ServiceType serviceType=serviceTypeService.selectServiceType(servicetypeId);
				wechatOrdersVo2.setServiceType(serviceType);//设置护工详细信息订单服务类型
				int linkmanId=orders.getLinkmanId();	
				Linkman linkman =linkManService.selectLinkManById(linkmanId);
				wechatOrdersVo2.setLinkman(linkman);//设置护工详细信息
				int nurseId=orders.getNurseId();//存的是user表id
				System.out.println("=================>"+nurseId);
				Nursedetail nursedetail = nurseDetailService.selectNurseDetailByUserId(nurseId);
			
				wechatOrdersVo2.setNursedetail(nursedetail);//设置护工详细信息
				int userid=nursedetail.getUserid();
				User user=userService.seleteuserByUserid(userid);
				wechatOrdersVo2.setUser(user);//设置护工基本详细信息
				wovList.add(wechatOrdersVo2);
			}
		}
		return wovList;	
	}
	
	/**
	 * 
	 * @Title: finishWechatOrder
	 * @date:2018年5月23日上午11:03:41
	 * @Description: TODO 微信用户确认订单完成
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
