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



















import sun.awt.image.ImageWatched.Link;
import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.OrdersVo;
import cn.erlaila.mybatis.service.LinkManService;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.OrdersService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.impl.OrdersServiceImp;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/linkMan")
public class LinkManController {
		
		private Logger logger = LoggerFactory.getLogger(LinkManController.class);
		
		@Autowired
		private LogsService logsService;
		
		@Autowired
		private LinkManService linkManService;
		
		/**
		 * 
		 * @Title: insertLinkMan
		 * @date:2018年5月28日上午9:26:18
		 * @Description: TODO 微信用户创建联系人
		 * @param: @param request
		 * @param: @param linkman
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/insertLinkMan")
		@ResponseBody
		public  String insertLinkMan(HttpServletRequest request,Linkman linkman) throws Exception {
			//获取微信用户信息
			User userWechat=(User)request.getSession().getAttribute("userWechat");
			int userId=userWechat.getUserid();
			linkman.setUserid(userId);
			linkman.setStatus(1);//设置新加的地址为默认地址
			int n=linkManService.insertLinkMan(linkman);	
			return n+"";			
		}
		
		/**
		 * 
		 * @Title: seleteAll
		 * @date:2018年5月28日上午9:25:55
		 * @Description: TODO 查找微信用户下的所有联系人
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/seleteAll")	
		public @ResponseBody List<Linkman> seleteAll(HttpServletRequest request) throws Exception {
			//获取微信用户信息
			User userWechat=(User)request.getSession().getAttribute("userWechat");
			int userId=userWechat.getUserid();
			List<Linkman> list=linkManService.selectAll(userId);	
			return list;			
		}
		
		
		/**
		 * 
		 * @Title: deleteById
		 * @date:2018年5月28日上午8:38:04
		 * @Description: TODO 根据id删除联系人
		 * @param: @param request
		 * @param: @param linkManID
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/deleteById")
		@ResponseBody
		public String deleteById(HttpServletRequest request,Integer linkManID) throws Exception {
			int n=linkManService.deleteById(linkManID);
			return n+"";			
		}
		
		/**
		 * 
		 * @Title: updateStatusByUserId
		 * @date:2018年5月28日上午9:28:14
		 * @Description: TODO 修改微信用户的默认地址
		 * @param: @param request
		 * @param: @param linkManID
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/updateStatusByUserId")
		@ResponseBody
		public String updateStatusByUserId(HttpServletRequest request,Integer linkManID) throws Exception {
			User userWechat=(User)request.getSession().getAttribute("userWechat");
			int userId=userWechat.getUserid();
			int n=linkManService.updateStatusByUserId(userId,linkManID);
			return n+"";			
		}
		
		/**
		 * 
		 * @Title: selectLinkManById
		 * @date:2018年5月28日上午10:12:35
		 * @Description: TODO 根据联系人id查找联系人
		 * @param: @param request
		 * @param: @param linkManID
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/selectLinkManById")	
		public @ResponseBody Linkman selectLinkManById(HttpServletRequest request,Integer linkManID) throws Exception {
			Linkman linkman=linkManService.selectLinkManById(linkManID);
			return linkman;			
		}
		
		/**
		 * 
		 * @Title: updateLinkManById
		 * @date:2018年5月28日上午10:14:14
		 * @Description: TODO 修改联系人信息
		 * @param: @param request
		 * @param: @param linkMan
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/updateLinkManById")
		@ResponseBody
		public String updateLinkManById(HttpServletRequest request,Linkman linkMan) throws Exception {			
			int n=linkManService.updateLinkManById(linkMan);
			return n+"";			
		}
		
		
		
		@RequestMapping("/selectLinkManByStatus")
		public @ResponseBody Linkman selectLinkManByStatus(HttpServletRequest request) throws Exception {			
			User userWechat=(User)request.getSession().getAttribute("userWechat");
			int userId=userWechat.getUserid();
			System.out.println("userId==========>"+userId);
			Linkman linkman = linkManService.selectLinkManByStatus(userId);
			return linkman;			
		}
		
}
