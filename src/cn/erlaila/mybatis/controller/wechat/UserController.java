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
		 * @date:2018��5��24������3:01:07
		 * @Description: TODO ��ȡ�û�������Ϣ
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getUserMessage")	
		public @ResponseBody User getUserMessage(HttpServletRequest request) throws Exception {
			//��ȡ�û�
			User userWechat=(User) request.getSession().getAttribute("userWechat");
			return userWechat;	
		}
		

		
		/**
		 * 
		 * @Title: 
		 * @date:2018��5��24������11:56:15
		 * @Description: TODO �ж��û����� 0 Ϊ�ͻ���ͨ΢���û� 1Ϊͨ��ʵ����֤�Ĺ�����Ա2�ύ��֤���ϵ�δͨ����֤��΢���û�
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
			//�ж��û��Ƿ�ͨ����֤
			User user=(User) request.getSession().getAttribute("userWechat");
			//ˢ�·���������
			
			boolean userType=user.getUsertype();
			if(userType){
				System.out.println("======>userType:"+userType);
				returnString="1";				
			}else{
				//�ж��û��Ƿ��Ѿ��ύ��ʵ����֤ 
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
			//��ȡ�û���ѯ�Ļ���id,��������id�浽session�У�������ڲ���
			//request.getSession().setAttribute("NurserId", userId);
			UserCustom userCustom = userService.seleteuserByUserid(userId);
			return userCustom;	
		}
		
		@RequestMapping("/findUserTelephone")
		@ResponseBody
		public  String seleteUserTelephone(HttpServletRequest request,@RequestParam int id) throws Exception {
			//��ȡ�û�
			//User userWechat=(User) request.getSession().getAttribute("userWechat");
			//int id=userWechat.getUserid();
			User user=userService.selectUserOnly(1);
			String telephone=user.getTelephone();
			System.out.println(telephone);
			return telephone;	
		}
		
		/** 
		 * @Title: seleteAll
		 * @date:2018��5��11������8:02:24
		 * @Description: TODO �ж��û��Ƿ�ͨ��ʵ����֤
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
			boolean userVerify=user.getUserverify();//1����ľ���true 
			System.out.println("userVerify===============>"+userVerify);
			return userVerify+"";
		}	
			
		@RequestMapping("/sendTeleCode")
		@ResponseBody
		public String sendTeleCode(HttpServletRequest request,String telePhone) throws Exception {
			String returnString="0";
			//������֤��
			String code=MessageUtil.createCode(6);
			request.getSession().setAttribute("MessageCode",code);
			request.getSession().setAttribute("telePhone",telePhone);
			
			//ͨ�������ƶ��ŷ������ֻ�������֤��
			SendSmsResponse response =  MessageUtil.sendSms(telePhone, code);		
			// ������
			System.out.println("���Žӿڷ��ص�����----------------");
			System.out.println("Code=" + response.getCode());
			System.out.println("Message=" + response.getMessage());
			System.out.println("RequestId=" + response.getRequestId());
			System.out.println("BizId=" + response.getBizId());
			Thread.sleep(3000L);
			//����ϸ
			if (response.getCode() != null && response.getCode().equals("OK")) {
				QuerySendDetailsResponse querySendDetailsResponse = MessageUtil.querySendDetails(response.getBizId());
				System.out.println("������ϸ��ѯ�ӿڷ�������----------------");
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
		 * @date:2018��5��11������2:00:46
		 * @Description: TODO ΢���û���֤�ֻ��� 
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
				//����session�е�user
				mess="1";
			}
			return mess;
		}
		
		/**
		 * 
		 * @Title: findRealName
		 * @date:2018��5��11������4:54:47
		 * @Description: TODO  ����΢���û�id��ѯ��������ʵ����
		 * @param: @param request
		 * @param: @param userid ΢���û�id ����
		 * @param: @param response  ��������ʵ����
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
			//��ȡ��������ʵ����
			String reanName=nurseDetailService.seleteRealNameByUserid(userid);
			//��ȡ΢���û�ѡ��ķ�������
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
