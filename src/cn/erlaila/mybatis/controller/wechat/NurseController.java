 package cn.erlaila.mybatis.controller.wechat;

import java.awt.geom.Area;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.NurseServiceContentService;
import cn.erlaila.mybatis.service.ServiceAreaService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.util.DloadImgUtil;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.Sha1;
import cn.erlaila.mybatis.util.WechatResource;

/**
 * ������Ա������
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��25�� ����9:25:37
 * @�汾 V 1.0
 */
@Controller
@RequestMapping("/nurse")
public class NurseController {
		// ͼƬ������·��
		private final String imgRealPath = WechatResource.getProperty("wechat.imgRealPath");	
		// ͼƬ����������·��
		private final String imgViPath = WechatResource.getProperty("wechat.imgViPath");
		
		private Logger logger = LoggerFactory.getLogger(NurseController.class);	 
		
		@Autowired
		private UserService userService;	
		
		@Autowired
		private ServiceAreaService serviceAreaService;
		
		@Autowired
		private NurseDetailService detailService; 
		
		@Autowired
		private NurseDetailService nurseDetailService;
		
		@Autowired
		private NurseServiceContentService nurseServiceContentService;
		
		
		@RequestMapping("/uodateNurseInfo")
		@ResponseBody
		public String uodateNurseInfo(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {
			User userWechat=(User) request.getSession().getAttribute("userWechat");	
			Integer userId=userWechat.getUserid();
			String m= nurseDetailService.uodateNurseInfo(8,nurseDetailVo);
			System.out.println("========>");
			return "";	
		}
		
		/**
		 * 
		 * @Title: getNurseBaseInfo
		 * @date:2018��5��31������2:29:09
		 * @Description: TODO ҽ����Ա�����Լ��Ļ�������
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getNurseBaseInfo")	
		public @ResponseBody NurseDetailVo getNurseBaseInfo(HttpServletRequest request) throws Exception {
			User userWechat=(User) request.getSession().getAttribute("userWechat");	
			Integer userId=userWechat.getUserid();
			NurseDetailVo nurseDetailVo = nurseDetailService.selectNurseBaseInfoById(userId);
			return nurseDetailVo;	
		}
		
		
		/**
		 * 
		 * @Title: setTypeId
		 * @date:2018��5��29������11:16:40
		 * @Description: TODO ��ȡ�û�����ѡ��ķ�������
		 * @param: @param request
		 * @param: @param serviceTypeId
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getTypeId")
		@ResponseBody
		public String getTypeId(HttpServletRequest request) throws Exception {
			Integer servicetypeId = (Integer) request.getSession().getAttribute("typeId");//�洢����ʹ��
			return servicetypeId+"";
		}
			
		/**
		 * 
		 * @Title: setTypeId
		 * @date:2018��5��29������11:16:40
		 * @Description: TODO �����û�ѡ��ķ�������
		 * @param: @param request
		 * @param: @param serviceTypeId
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/setTypeId")
		@ResponseBody
		public String setTypeId(HttpServletRequest request,Integer serviceTypeId) throws Exception {
			System.out.println("serviceTypeId=======>"+serviceTypeId);
			if(serviceTypeId!=null){
				request.getSession().setAttribute("typeId",serviceTypeId);//�洢����ʹ��
			}
			return "1";
		}
		
		
		@RequestMapping("/selectCountByServiceId")
		@ResponseBody
		public  String selectCountByServiceId(HttpServletRequest request) throws Exception {
			Integer serviceTypeId =(Integer) request.getSession().getAttribute("typeId");
			int n=nurseServiceContentService.selectCountByServiceId(serviceTypeId);
			System.out.println("m==============>"+n);
			return n+"";	
		}
		
		/**
		 * 
		 * @Title: seleteNurseBylimt
		 * @date:2018��5��25������4:20:33
		 * @Description: TODO ���������������㻤��Ա
		 * @param: @param request
		 * @param: @param serviceTypeId ��������
		 * @param: @param count  ���صڼ���
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/seleteNurseBylimt")
		public @ResponseBody List<UserCustom> seleteNurseBylimt(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {
			Integer serviceTypeId =(Integer) request.getSession().getAttribute("typeId");
			nurseDetailVo.setServiceTypeId(serviceTypeId);
			//nurseDetailVo.setServiceTypeId(1);
			//nurseDetailVo.setCount(0);
			//nurseDetailVo.setPageSize(1);
			List<UserCustom> list=nurseDetailService.selectByLimit(nurseDetailVo);
			return list;	
		}		
		
		/**
		 * 
		 * @Title: getUserMess1
		 * @date:2018��5��24������7:05:30
		 * @Description: TODO ������Ա������Ϣ��һ��
		 * @param: @param request
		 * @param: @param nurseDetailVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/getUserMess1")
		@ResponseBody
		public String getUserMess1(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {
			//ҳ�洫��������  user:ͷ��   ���ڳ���     nursedetail:����  ����״��  ���  ����    �Ļ��̶�
			//��ȡ���ݿ���user��������Ϣ
			User user=(User) request.getSession().getAttribute("userWechat");
			//ͷ��
			String  usericon=nurseDetailVo.getUser().getUsericon();
			if(usericon!=null && usericon!=""){
				user.setUsericon(usericon);	
			}
			//����
			String city=nurseDetailVo.getUser().getCity();
			if(city!="" && city!=""){				
				user.setCity(city);
			}	
			nurseDetailVo.setUser(user);			
			request.getSession().setAttribute("temNurseDetailVo",nurseDetailVo);
			return "1";
		}
		
		/**
		 * 
		 * @Title: getUserMess2
		 * @date:2018��5��15������10:42:03
		 * @Description: TODO ��ʱ�洢������ϸ��Ϣ
		 * @param: @param request
		 * @param: @param nurseDetailVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value="/getUserMess2")
		@ResponseBody
		public String getUserMess2(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {								
			//adress(��ַ)  detailAdress(��ϸ��ַ)   experience(��������)  synopsis(���Ҽ��) begoodat(�ó�)
			NurseDetailVo nurseDetailVoLast=(NurseDetailVo) request.getSession().getAttribute("temNurseDetailVo2");
			String adress=nurseDetailVo.getNursedetail().getAdress();	
			String adressdetail=nurseDetailVo.getNursedetail().getAdressdetail();
			String experience=nurseDetailVo.getNursedetail().getExperience();
			String begoodat=nurseDetailVo.getNursedetail().getBegoodat();
			String synopsis=nurseDetailVo.getNursedetail().getSynopsis();
			if(nurseDetailVoLast!=null){
				if(adress!=null&&adress!=""){
					nurseDetailVoLast.getNursedetail().setAdress(adress);
				}
				if(adressdetail!=null&&adress!=""){
					nurseDetailVoLast.getNursedetail().setAdressdetail(adressdetail);
				}
				if(experience!=null&&adress!=""){
					nurseDetailVoLast.getNursedetail().setExperience(experience);
				}
				if(begoodat!=null&&begoodat!=""){
					nurseDetailVoLast.getNursedetail().setBegoodat(begoodat);
				}
				if(synopsis!=null&&synopsis!=""){
					nurseDetailVoLast.getNursedetail().setSynopsis(synopsis);
				}
			}else{
				nurseDetailVoLast=nurseDetailVo;
			}
			request.getSession().setAttribute("temNurseDetailVo2", nurseDetailVoLast);
			return "1";
		}
		
		/**
		 * 
		 * @Title: initUserMess2
		 * @date:2018��5��15������10:44:02
		 * @Description: TODO ��ʼ�����滤����Ϣ�ڶ���
		 * @param: @param request
		 * @param: @param nurseDetailVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/initUserMess2")		
		public @ResponseBody NurseDetailVo initUserMess2(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {								
			//
			NurseDetailVo nurseDetailVoLast=(NurseDetailVo) request.getSession().getAttribute("temNurseDetailVo2");
			//��ѯ����ѡ��ķ���Χ�Լ���������
			User user=(User) request.getSession().getAttribute("userWechat");
			Integer userid=user.getUserid();
			NurseDetailVo nurseDetailVoLast2 = detailService.seleteContentAndAreaByUserid(userid);
			if(nurseDetailVoLast!=null){
				if(nurseDetailVoLast.getNursedetail()!=null){
					nurseDetailVoLast2.setNursedetail(nurseDetailVoLast.getNursedetail());
				}
				if(nurseDetailVoLast.getUser()!=null){
					nurseDetailVoLast2.setUser(nurseDetailVoLast.getUser());
				}	
			}
			return nurseDetailVoLast2;
		}
		
		/**
		 * 
		 * @Title: getUserMess3
		 * @date:2018��5��15������12:35:45
		 * @Description: TODO ��ȡ�������ύ�������֤��ͼƬ������ǰ��������Ϣ�ύ�����ݿ�
		 * @param: @param request
		 * @param: @param realNameAuthentication
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/getUserMess3")
		@ResponseBody
		public String getUserMess3(HttpServletRequest request,RealNameAuthentication realNameAuthentication) throws Exception {			
			NurseDetailVo nurseDetailVoLast=(NurseDetailVo) request.getSession().getAttribute("temNurseDetailVo");		
			NurseDetailVo nurseDetailVoLast2=(NurseDetailVo) request.getSession().getAttribute("temNurseDetailVo2");
			
			//ȡ���ڶ����е�����
			String adress=nurseDetailVoLast2.getNursedetail().getAdress();	
			String adressdetail=nurseDetailVoLast2.getNursedetail().getAdressdetail();
			String experience=nurseDetailVoLast2.getNursedetail().getExperience();
			String begoodat=nurseDetailVoLast2.getNursedetail().getBegoodat();
			String synopsis=nurseDetailVoLast2.getNursedetail().getSynopsis();

			Nursedetail nursedetail = nurseDetailVoLast.getNursedetail();//��һ�������˺ܶ����� ����  ����״��  ���  ����    �Ļ��̶�
			nursedetail.setAdress(adress);
			nursedetail.setAdressdetail(adressdetail);
			nursedetail.setExperience(experience);
			nursedetail.setBegoodat(begoodat);
			nursedetail.setSynopsis(synopsis);
			nurseDetailVoLast.setNursedetail(nursedetail);
			
			nurseDetailVoLast.setRealNameAuthentication(realNameAuthentication);
			nurseDetailService.insertNurseValidate(nurseDetailVoLast);
			return "1";
		}
		
		/**
		 * 
		 * @Title: insertNurseContent
		 * @date:2018��5��15������8:46:46
		 * @Description: TODO �����ݿ��в�������޸Ļ�����������
		 * @param: @param request
		 * @param: @param nurseDetailVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/insertNurseContent")
		@ResponseBody
		public String insertNurseContent(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {					
			List<NurseServiceContent> list=nurseDetailVo.getContentList();
			User user=(User) request.getSession().getAttribute("userWechat");
			Integer userid=user.getUserid();
			nurseServiceContentService.insertServiceContent(userid, list);
			return "1";
		}
			
		/**
		 * 
		 * @Title: insertNurseArea
		 * @date:2018��5��15������8:46:46
		 * @Description: TODO �����ݿ��в�������޸Ļ�����������
		 * @param: @param request
		 * @param: @param nurseDetailVo
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/insertNurseArea")
		@ResponseBody
		public String insertNurseArea(HttpServletRequest request,NurseDetailVo nurseDetailVo) throws Exception {					
			List<NurseServiceArea> list=nurseDetailVo.getAreaList();
			User user=(User) request.getSession().getAttribute("userWechat");
			Integer userid=user.getUserid();
			serviceAreaService.insertServiceArea(userid, list);
			return "1";
		}
		
}
