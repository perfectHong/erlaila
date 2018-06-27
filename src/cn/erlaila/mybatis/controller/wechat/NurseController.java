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
 * 工作人员操作类
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月25日 上午9:25:37
 * @版本 V 1.0
 */
@Controller
@RequestMapping("/nurse")
public class NurseController {
		// 图片库物理路径
		private final String imgRealPath = WechatResource.getProperty("wechat.imgRealPath");	
		// 图片服务器虚拟路径
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
		 * @date:2018年5月31日下午2:29:09
		 * @Description: TODO 医护人员查找自己的基本资料
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
		 * @date:2018年5月29日上午11:16:40
		 * @Description: TODO 获取用户储存选择的服务类型
		 * @param: @param request
		 * @param: @param serviceTypeId
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/getTypeId")
		@ResponseBody
		public String getTypeId(HttpServletRequest request) throws Exception {
			Integer servicetypeId = (Integer) request.getSession().getAttribute("typeId");//存储后期使用
			return servicetypeId+"";
		}
			
		/**
		 * 
		 * @Title: setTypeId
		 * @date:2018年5月29日上午11:16:40
		 * @Description: TODO 储存用户选择的服务类型
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
				request.getSession().setAttribute("typeId",serviceTypeId);//存储后期使用
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
		 * @date:2018年5月25日下午4:20:33
		 * @Description: TODO 查找满足条件的陪护人员
		 * @param: @param request
		 * @param: @param serviceTypeId 服务类型
		 * @param: @param count  加载第几次
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
		 * @date:2018年5月24日下午7:05:30
		 * @Description: TODO 工作人员完善信息第一步
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
			//页面传过来数据  user:头像   所在城市     nursedetail:姓名  婚姻状况  身高  体重    文化程度
			//获取数据库中user的最新信息
			User user=(User) request.getSession().getAttribute("userWechat");
			//头像
			String  usericon=nurseDetailVo.getUser().getUsericon();
			if(usericon!=null && usericon!=""){
				user.setUsericon(usericon);	
			}
			//城市
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
		 * @date:2018年5月15日上午10:42:03
		 * @Description: TODO 临时存储护工详细信息
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
			//adress(地址)  detailAdress(详细地址)   experience(工作经验)  synopsis(自我简介) begoodat(擅长)
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
		 * @date:2018年5月15日上午10:44:02
		 * @Description: TODO 初始化保存护工信息第二步
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
			//查询护工选择的服务范围以及服务区域
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
		 * @date:2018年5月15日下午12:35:45
		 * @Description: TODO 获取第三部提交的身份验证的图片，并将前两步的信息提交到数据库
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
			
			//取出第二步中的数据
			String adress=nurseDetailVoLast2.getNursedetail().getAdress();	
			String adressdetail=nurseDetailVoLast2.getNursedetail().getAdressdetail();
			String experience=nurseDetailVoLast2.getNursedetail().getExperience();
			String begoodat=nurseDetailVoLast2.getNursedetail().getBegoodat();
			String synopsis=nurseDetailVoLast2.getNursedetail().getSynopsis();

			Nursedetail nursedetail = nurseDetailVoLast.getNursedetail();//第一步保存了很多数据 姓名  婚姻状况  身高  体重    文化程度
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
		 * @date:2018年5月15日上午8:46:46
		 * @Description: TODO 向数据库中插入或者修改护工服务内容
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
		 * @date:2018年5月15日上午8:46:46
		 * @Description: TODO 向数据库中插入或者修改护工服务区域
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
