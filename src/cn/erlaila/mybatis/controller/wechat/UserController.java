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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.RealNameAuthenticationService;
import cn.erlaila.mybatis.service.ServiceTypeService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.MessageUtil;
import cn.erlaila.mybatis.util.SmsUtil;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/wechatuser")
public class UserController {
		
		private Logger logger = LoggerFactory.getLogger(UserController.class);
	    
		@Autowired
		private UserService userService;
		
		@Autowired
		private NurseDetailService nurseDetailService;
		
		@Autowired
		private LogsService logsService;
		
		@Autowired
		private ServiceTypeService serviceTypeService;
		
		@Autowired
		private RealNameAuthenticationService realNameAuthenticationService;
		
		/**
		 * 
		 * @Title: getUserMessage
		 * @date:2018年5月24日下午3:01:07
		 * @Description: TODO 获取用户基本信息
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getUserMessage")	
		public @ResponseBody User getUserMessage(HttpServletRequest request) throws Exception {
			//获取用户
			User userWechat=(User) request.getSession().getAttribute("userWechat");
			return userWechat;	
		}
		

		
		/**
		 * 
		 * @Title: 
		 * @date:2018年5月24日上午11:56:15
		 * @Description: TODO 判断用户类型 0 为客户普通微信用户 1为通过实名认证的工作人员2提交验证材料但未通过验证的微信用户
		 * @param: @param request
		 * @param: @param userId
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/validateUserType")
		@ResponseBody
		public String validateUserType(HttpServletRequest request,Integer userId) throws Exception {
			String returnString="0";
			//判断用户是否通过验证
			User user=(User) request.getSession().getAttribute("userWechat");
			//刷新服务器缓存
			
			boolean userType=user.getUsertype();
			if(userType){
				System.out.println("======>userType:"+userType);
				returnString="1";				
			}else{
				//判断用户是否已经提交过实名认证 
				RealNameAuthentication realNameAuthentication=realNameAuthenticationService.selectByUserId(user.getUserid());				
				if(realNameAuthentication!=null){
					returnString="2";
				}	
			}			
			return returnString;	
		}
				
		@RequestMapping("/seleteuserByUserid")
		public @ResponseBody UserCustom seleteuserByUserid(HttpServletRequest request,Integer userId) throws Exception {
			//List<UserCustom> list=userService.selectByLimit(serviceid);
			//System.out.println("===============>"+list.size());
			//获取用户查询的护工id,并将护工id存到session中，方便后期操作
			//request.getSession().setAttribute("NurserId", userId);
			UserCustom userCustom = userService.seleteuserByUserid(userId);
			return userCustom;	
		}
		
		@RequestMapping("/findUserTelephone")
		@ResponseBody
		public  String seleteUserTelephone(HttpServletRequest request,@RequestParam int id) throws Exception {
			//获取用户
			//User userWechat=(User) request.getSession().getAttribute("userWechat");
			//int id=userWechat.getUserid();
			User user=userService.selectUserOnly(1);
			String telephone=user.getTelephone();
			System.out.println(telephone);
			return telephone;	
		}
		
		/** 
		 * @Title: seleteAll
		 * @date:2018年5月11日上午8:02:24
		 * @Description: TODO 判断用户是否通过实名认证
		 * @param: @param request
		 * @param: @param serviceid
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/validateTel")
		@ResponseBody
		public String validateTel(HttpServletRequest request) throws Exception {
			User user=(User) request.getSession().getAttribute("userWechat");
			System.out.println(user.getNickname());
			System.out.println(user.getUserverify());
			boolean userVerify=user.getUserverify();//1代表的就是true 
			System.out.println("userVerify===============>"+userVerify);
			return userVerify+"";
		}	
			
		@RequestMapping("/sendTeleCode")
		@ResponseBody
		public String sendTeleCode(HttpServletRequest request,String telePhone) throws Exception {
			String returnString="0";
			//创建验证码
			String code=MessageUtil.createCode(6);
			request.getSession().setAttribute("MessageCode",code);
			request.getSession().setAttribute("telePhone",telePhone);
			
			//通过阿里云短信服务向手机发送验证码
			SendSmsResponse response =  MessageUtil.sendSms(telePhone, code);		
			// 发短信
			System.out.println("短信接口返回的数据----------------");
			System.out.println("Code=" + response.getCode());
			System.out.println("Message=" + response.getMessage());
			System.out.println("RequestId=" + response.getRequestId());
			System.out.println("BizId=" + response.getBizId());
			Thread.sleep(3000L);
			//查明细
			if (response.getCode() != null && response.getCode().equals("OK")) {
				QuerySendDetailsResponse querySendDetailsResponse = MessageUtil.querySendDetails(response.getBizId());
				System.out.println("短信明细查询接口返回数据----------------");
				System.out.println("Code=" + querySendDetailsResponse.getCode());
				System.out.println("Message=" + querySendDetailsResponse.getMessage());
				int i = 0;
				for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO:querySendDetailsResponse.getSmsSendDetailDTOs()){
					System.out.println("SmsSendDetailDTO[" + i + "]:");
					System.out.println("Content=" + smsSendDetailDTO.getContent());
					System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
					System.out.println("OutId=" + smsSendDetailDTO.getOutId());
					System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
					System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
					System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
					System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
					System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
				}
				System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
				System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
				returnString="1";
			}
			return returnString;
		}	
		
		
		/**
		 * 
		 * @Title: regestTele
		 * @date:2018年5月11日下午2:00:46
		 * @Description: TODO 微信用户验证手机号 
		 * @param: @param request
		 * @param: @param telePhone
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/regestTele")
		@ResponseBody
		public String regestTele(HttpServletRequest request,String code) throws Exception {
			String messageCode=(String) request.getSession().getAttribute("MessageCode");
			System.out.println("============>"+messageCode);		
			String mess="0";
			if(code.equals(messageCode)){
				String telePhone=(String) request.getSession().getAttribute("telePhone");
				System.out.println("telePhone:"+telePhone);
				User user=(User)request.getSession().getAttribute("userWechat");
				int userid=user.getUserid();
				user.setTelephone(telePhone);
				user.setUserverify(true);
				userService.updateUserByUserid(userid,user);
				//更新session中的user
				mess="1";
			}
			return mess;
		}
		
		/**
		 * 
		 * @Title: findRealName
		 * @date:2018年5月11日下午4:54:47
		 * @Description: TODO  根据微信用户id查询护工的真实姓名
		 * @param: @param request
		 * @param: @param userid 微信用户id 护工
		 * @param: @param response  护工的真实姓名
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/initOrder")
		public @ResponseBody OrdersVo initOrder(HttpServletRequest request,Integer userid,HttpServletResponse response) throws Exception {		
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			//userid 
			if(userid != 0){
				request.getSession().setAttribute("orderNurseId",userid);	
			}else{
				userid=(Integer) request.getSession().getAttribute("orderNurseId");
			}
			System.out.println("ordderNurseId================>"+userid);
			//获取护工的真实姓名
			String reanName=nurseDetailService.seleteRealNameByUserid(userid);
			//获取微信用户选择的服务类型
			Integer typeId=(Integer) request.getSession().getAttribute("typeId");
			System.out.println("=========>typeId"+typeId);
			User user=(User)request.getSession().getAttribute("userWechat");
			ServiceType serviceType = serviceTypeService.selectServiceType(typeId);
			OrdersVo ordersVo=new OrdersVo();
			ordersVo.setUser(user);
			ordersVo.setServiceType(serviceType);;
			ordersVo.setRealName(reanName);	
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			System.out.println("=========================>");
			return ordersVo;
		}
}
