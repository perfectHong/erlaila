 package cn.erlaila.mybatis.controller.wechat;

import java.io.IOException;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.service.LogsService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.util.DloadImgUtil;
import cn.erlaila.mybatis.util.GetRealIp;
import cn.erlaila.mybatis.util.Sha1;
import cn.erlaila.mybatis.util.WechatResource;
@Controller
@RequestMapping("/wechat")
public class WeiXinController {
		// 开发者ID
		private final String appid = WechatResource.getProperty("wechat.appId");
		// 开发者密码
		private final String secret = WechatResource.getProperty("wechat.secret");
		//微信用户授权回调地址
		//这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
		
		private final String backUrl = WechatResource.getProperty("wechat.backUrl");
		// 图片库物理路径
		private final String imgRealPath = WechatResource.getProperty("wechat.imgRealPath");	
		// 图片服务器虚拟路径
		private final String imgViPath = WechatResource.getProperty("wechat.imgViPath");
		private Logger logger = LoggerFactory.getLogger(WeiXinController.class);	    
		@Autowired
		private UserService userService;		
		@Autowired
		private LogsService logsService;
		
		/**
		 * 
		 * @Title: wxLogin
		 * @date:2018年5月10日上午11:35:30
		 * @Description: TODO 向用户获取授权
		 * @param: @param request
		 * @param: @param response
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/wxLogin")
		public String wxLogin(HttpServletRequest request, HttpServletResponse response,String state) throws Exception {					
			String redirectUrl="";
			String operationip=GetRealIp.getIpAddr(request);
			//判断用户是否已经登陆	
			User userWechat=(User) request.getSession().getAttribute("userWechat");	
			if(userWechat!=null){
				String openid=userWechat.getOpenid();				
				if(openid!=null||openid!=""){
					//判断点击类型
					if("service".equals(state)){
						redirectUrl= "redirect:/wechat/customer/index.html";				
					}else if("orders".equals(state)){
						redirectUrl= "redirect:/wechat/customer/myOrders.html";
					}else{
						redirectUrl= "redirect:/wechat/customer/info.html";						
					}										
				}
			}else{
				//第一步：用户同意授权，获取code
				String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid
						+ "&redirect_uri="+URLEncoder.encode(backUrl)
						+ "&response_type=code"
						+ "&scope=snsapi_userinfo"
						+ "&state="+state
						+ "#wechat_redirect";
				redirectUrl= "redirect:"+url;
			}
			return redirectUrl;
		}
		 
		/**
		 * 
		 * @Title: auth
		 * @date:2018年5月10日上午11:36:27
		 * @Description: TODO 微信回调地址，获取用户的基本信息，并保存到session
		 * @param: @param code
		 * @param: @param req
		 * @param: @param response
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping("/callBack")
		public String auth(@RequestParam("code") String code, String state ,HttpServletRequest req,HttpServletResponse response) throws Exception {			
			//第二步：通过code换取网页授权access_token
			String access_tokenUrl="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code="+ code + "&grant_type=authorization_code";
			RestTemplate restTemplate = new RestTemplate();
			String respose = restTemplate.getForObject(access_tokenUrl, String.class);			
			JSONObject jsonObject = JSONObject.fromObject(respose);
		    String openid = jsonObject.getString("openid");
		    String access_token = jsonObject.getString("access_token");   
		    String refresh_token = jsonObject.getString("refresh_token");
		    // 第四步：拉取用户信息(需scope为 snsapi_userinfo)	     
		    String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
		    String infoString = restTemplate.getForObject(infoUrl, String.class);
		    System.out.println("infoString:"+infoString);		   
		    infoString=new String(infoString.getBytes("iso8859-1"), "utf-8"); 
		    System.out.println("infoString:"+infoString);	
		    JSONObject userInfo = JSONObject.fromObject(infoString);
		    System.out.println("infoString:"+infoString);	
		        //设置用户信息并存储到session中
		     	User userWechat=new User();
		        userWechat.setOpenid(openid);
		        userWechat.setNickname(userInfo.getString("nickname"));
		        userWechat.setUsericon(userInfo.getString("headimgurl"));
		        System.out.println(userInfo.getString("headimgurl"));
		        int sexWechat=Integer.parseInt(userInfo.getString("sex"));
		        boolean sexFg=sexWechat==0?true:false;
		        userWechat.setSex(sexFg);
		        userWechat.setUserverify(false);
		        userWechat.setUsertype(false);
		        userWechat.setCountry(userInfo.getString("country"));
		        userWechat.setProvince(userInfo.getString("province")); 
		        userWechat.setCity(userInfo.getString("city"));
		        userWechat.setUsertype(false);
		        req.getSession().setAttribute("userWechat", userWechat);
		        String redirectUrl="";
		        System.out.println("infoString:"+infoString);	
		        //判断点击类型
				if("service".equals(state)){
					System.out.println("========>"+state);
					redirectUrl= "redirect:/wechat/customer/index.html";			
				}else if("orders".equals(state)){
					System.out.println("========>"+state);
					redirectUrl= "redirect:/wechat/customer/myOrders.html";					
				}else{
					System.out.println("========>"+state);
					redirectUrl= "redirect:/wechat/customer/info.html";						
				}	
				return redirectUrl;
				//return response.sendRedirect(redirectUrl);
		}
		
		
		/**
		 * 
		 * @Title: getUserMessage
		 * @date:2018年5月23日下午3:55:33
		 * @Description: TODO 获取微信用户信息
		 * @param: @param request
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value="/getUserMessage")
		public @ResponseBody User getUserMessage(HttpServletRequest request) throws Exception {					
			//获取用户信息
			HttpSession session=request.getSession();
			User userWechat=(User)session.getAttribute("userWechat");
			return userWechat;
		}	
		
		
		/** 
		 * @Title: userinit
		 * @date:2018年5月6日下午9:13:26
		 * @Description: TODO微信用户登陆验证
		 * @param: @param request
		 * @param: @param response
		 * @param: @return
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/userinit")
		@ResponseBody
		public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {					
			//获取用户信息
			HttpSession session=request.getSession();
			User userWechat=(User)session.getAttribute("userWechat");
			System.out.println("userWechat.getOpenid()========>:"+userWechat.getOpenid());
			User user = userService.doLogin(userWechat.getOpenid());
			request.getSession().removeAttribute("userWechat");
			request.getSession().setAttribute("userWechat", user);
			String operationip=GetRealIp.getIpAddr(request);
			String stringFg="";
			if(user!=null){
				//日志记录
				int userid = user.getUserid();
				//判断用户类型
				boolean userType=user.getUsertype();
				if(userType){
					stringFg= "1";
				}else{
					stringFg= "0";
				}
				int num=logsService.insertLogs(userid,"WeiXinController","userLogin","用户登陆",operationip,false);			
			}else{
			    int n= userService.insert(userWechat);
			    User user2 = userService.doLogin(userWechat.getOpenid());
				request.getSession().removeAttribute("userWechat");
				request.getSession().setAttribute("userWechat", user2);
			    int num=logsService.insertLogs(0,"WeiXinController","userLogin","用户注册",operationip,false);			
			    stringFg="0";
			}
			return stringFg;
		}	
	
		@RequestMapping(value = "/wxConfig")
		public @ResponseBody Map<String,String> wxConfig(HttpServletRequest request,String windowHref) throws Exception {					
			RestTemplate restTemplate = new RestTemplate();
			//获取access_token，有效期两个小时
			String access_token=(String) request.getSession().getAttribute("access_token");
			System.out.println("access_token============>"+access_token);
			if(access_token==null){
				String urel="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
				String s = restTemplate.getForObject(urel, String.class);
				System.out.println("返回结果==============>"+s);
				String [] b = s.split("\"access_token\":\"");
				String [] c=b[1].split("\",\"");
				access_token=c[0];		
				System.out.println("11111111+++++++>"+access_token);
				request.getSession().setAttribute("access_token", access_token);
			} 
			System.out.println("===========>access_token:"+access_token);
			String ticket=(String) request.getSession().getAttribute("ticket");
			if(access_token!=null&&ticket==null){
				String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";		
				String infoString = restTemplate.getForObject(url, String.class);
				System.out.println("========>infoString:"+infoString);
				String [] b = infoString.split("\"ticket\":\"");
				String [] c=b[1].split("\",\"");
				ticket=c[0];
				System.out.println("====>ticket"+ticket);
				request.getSession().setAttribute("ticket", ticket);
			}
			ticket=(String) request.getSession().getAttribute("ticket");
			System.out.println("ticket:"+ticket);
			//"ticketkgt8ON7yVITDhtdwci0qeUuOO-0frCuRs04DHRAenTjNrybn4PyxBb0He20tyToV2qY8z0qRelME2ana5-4n1A";
			String noncestr="Wm3WZYTPz0wzccnW";
			long timestamp=System.currentTimeMillis();
			System.out.println("timestamp:"+timestamp);
			//String shexiaoURL="http://erlaile.nat300.top/erlaila/wechat/nurse/editInfo_1.html";
			String str="jsapi_ticket="+ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+windowHref;		
			String signature=Sha1.SHA1(str);
			System.out.println("signature:"+signature);
			Map<String,String> map=new HashMap<String, String>();
			map.put("appId", appid);
			map.put("noncestr", noncestr);
			map.put("timestamp",timestamp+"" );
			map.put("ticket", ticket);
			map.put("signature",signature);
			return map;
		}
		
		/**
		 * 
		 * @Title: uploadImg
		 * @date:2018年5月14日上午10:05:47
		 * @Description: TODO 将用户上传的图片从微信服务器下载到本地服务器 （微信服务器只保存3天）
		 * @param: @param request
		 * @param: @param mediaId 需要下载的图片的微信服务器端ID，由uploadImage接口获得
		 * @param: @throws Exception   
		 * @return: bulesky  
		 * @throws
		 */
		@RequestMapping(value = "/downloadImgFromWx")
		@ResponseBody
		public String  uploadImg(HttpServletRequest request ,String mediaId) throws Exception {
			String access_token=(String)request.getSession().getAttribute("access_token");
			User userWechat=(User)request.getSession().getAttribute("userWechat");	
			int userid=userWechat.getUserid();
			String path=imgRealPath+"user"+userid;
			//用户上传图片存放策略 
			//所有图片统一存放到系统配置的存放路径下，在该路径下为每个用户创建一个独立的文件夹用以存放该用户图片，
			//文件夹的命名策略为："user"+userid
			//图片的命令策略为 时间戳+文件格式 
			//例如 用户id为1的用户  imgRealPath+“user”+"1"+"12454543"+".jpg"			
			String FileName=DloadImgUtil.downloadMedia(access_token, mediaId, path);
			String userIconFileName=imgViPath+"user"+userid+"/"+FileName;
			System.out.println("userIconFileName:"+userIconFileName);
			//创建一个临时的user，存储基本信息，存储到session,便宜后期操作
			User temporaryUser=new User();
			temporaryUser.setUsericon(userIconFileName);
			request.getSession().setAttribute("temporaryUser",temporaryUser);			
			return userIconFileName;
		}
}
