package cn.erlaila.mybatis.controller.wechat;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.NurseOrdersCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.NurseOrdersVo;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.NurseOrdersService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.impl.OrdersServiceImp;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/nurseOrders")
public class NurseOrdersController {
		
		private Logger logger = LoggerFactory.getLogger(NurseOrdersController.class);
	    
		@Autowired
		private NurseOrdersService nurseOrdersService;
		
		@Autowired
		private NurseDetailService nurseDetailService;
		
		@RequestMapping("/selectOrderByNurse")
		@ResponseBody
		public String selectOrderByNurse(HttpServletRequest request) throws Exception {
			
			return"";	
		}
		
		/*
		@RequestMapping("/getAllNurseOrder")		
		public @ResponseBody List<NurseOrdersCustom> getAllNurseOrder(HttpServletRequest request) throws Exception {
			User userWechat=(User) request.getSession().getAttribute("userWechat");
			Nursedetail nursedetail=nurseDetailService.selectNurseDetailByUserId(userWechat.getUserid());
			int  nurseid=nursedetail.getNursedetailid();
			List<NurseOrdersCustom> nurseOrdersList=nurseOrdersService.selectOrderByNurse(nurseid);
			return nurseOrdersList;	
		}
		*/
		
		
		/**
		 * @Title: selectOrderByNurseAndStatus
		 * @date:2018年5月18日上午11:13:33
		 * @Description: TODO 护查询的订单状态
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/selectOrderByNurseAndStatus")		
		public @ResponseBody List<NurseOrdersCustom> selectOrderByNurseAndStatus(HttpServletRequest request,NurseOrdersVo nurseOrdersVo) throws Exception {				
			User userWechat=(User) request.getSession().getAttribute("userWechat");
			nurseOrdersVo.setNurseId(userWechat.getUserid());//订单中NurseId为微信user表中的ID 来源 initOrder==》orderNurseId
			List<NurseOrdersCustom> nurseOrdersList=nurseOrdersService.selectOrderByNurseAndStatus(nurseOrdersVo);
			return nurseOrdersList;	
		}

		/**
		 * 		
		 * @Title: selectOrderDetailById
		 * @date:2018年5月22日下午3:07:10
		 * @Description: TODO 查询护工得详情
		 * @param: @param nurseOrdersVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/selectOrderDetailById")		
		public @ResponseBody NurseOrdersCustom selectOrderDetailById(NurseOrdersVo nurseOrdersVo) throws Exception {
			List<NurseOrdersCustom> nurseOrdersList=nurseOrdersService.selectOrderByNurseAndStatus(nurseOrdersVo);
			NurseOrdersCustom nurseOrdersCustom=nurseOrdersList.get(0);
			return nurseOrdersCustom;	
		}		
		
		/**
		 * 
		 * @Title: getAllNurseOrder
		 * @date:2018年5月22日下午4:45:53
		 * @Description: TODO 护工改变订单状态
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/updateNurseOrderStatus")
		@ResponseBody
		public String updateNurseOrderStatus(NurseOrdersVo nurseOrdersVo) throws Exception {
			//改变护工订单状态
			int m=nurseOrdersService.updateNurseOrdersByOrderId(nurseOrdersVo);
			
			System.out.println("已改状态=======>"+m);
			return m+"";
		}
}
