package cn.erlaila.mybatis.controller.pc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.erlaila.mybatis.controller.wechat.WeiXinController;
import cn.erlaila.mybatis.exception.CustomException;
import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.AdminsService;
import cn.erlaila.mybatis.util.WechatResource;

@Controller
@RequestMapping("/admins")
public class AdminsController {
	static private String imgRealPath = WechatResource.getProperty("wechat.imgRealPath");
	
	static private String imgViPath = WechatResource.getProperty("wechat.imgViPath");
	
	@Autowired
	private AdminsService adminsService;
	
	private Logger logger = LoggerFactory.getLogger(WeiXinController.class);
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO(������һ�仰��������������)  
	    * @author �Ϸ���  
	    * @date 2018��5��11�� ����1:11:09
	    *  
	    * @param admins
	    * @param request
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/dologin")
	public String  dologin(Admins admins,HttpServletRequest request) throws Exception {	
		logger.info("����Ա��½");    
		Admins admins1=adminsService.loginByPsw(admins);
		if(admins1!=null){
			request.getSession().setAttribute("admins", admins1);
			System.out.println("�ɹ�===================");
			return "redirect:/pcAdmin/index.html";
		}
		else{
			return "error";
		}
	}
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  �˳���¼
	    * @author �Ϸ���  
	    * @date 2018��5��12�� ����5:07:24
	    *  
	    * @param request
	    * @param response
	    * @throws IOException
	 */
	@RequestMapping("/checkExit")
	public String adminsExit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Admins admins = (Admins) session.getAttribute("admins");
		System.out.println(admins+"==============");
		
		//session.removeAttribute("admins");
		session.invalidate();
		//if (session.getAttribute("admins")==null) {
			System.out.println(admins.getTelphon()+"�˳��ɹ�");
			return "redirect:/pcAdmin/login.html";
		//}
		//return "";
		
	}
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO ��������Ա 
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����6:41:04
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/addAdmin")
	public String insertAdmin(Admins admins) throws Exception{
		adminsService.insertAdmin(admins);
		return "error";
	}
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  ���ҹ���Ա��������
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����6:41:56
	    *  
	    * @param request
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/findAdmin")
	public @ResponseBody Admins findAdmin(HttpServletRequest request) throws Exception {		
		HttpSession session = request.getSession();
		Admins admins = (Admins) session.getAttribute("admins");
		System.out.println(admins.getAdminid()+".................................");
		admins = adminsService.selectByPrimaryKey(admins.getAdminid());			
		return admins;
	}
	
	/**
	 * @Title: findAllAdmin
	 * @Description: TODO ��ҳ
	 * @param: @param adminsVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */

	@RequestMapping("/findAllAdmin")
	public @ResponseBody Page findAdmins(AdminsVo adminsVo) throws Exception {
        Page page=adminsService.selectByLimit(adminsVo);
        System.out.println(adminsVo);
        System.out.println("======================>pagesize"+page.getCount());
        return page;
	}
		
	@RequestMapping("/findCount")
	public @ResponseBody String findCount(HttpServletRequest request) throws Exception {
		int count=adminsService.selectCount();
		System.out.println("======================>"+count);
        return count+"";
	}
	
	/*
	 * �޸�admin��������
	 * */
	@RequestMapping("/updateAdmin")
	public @ResponseBody Admins updateAdmin(Integer adminid,Admins admins) throws Exception {
		adminsService.updateAdmins(adminid,admins);
		admins = adminsService.selectByPrimaryKey(1);
		return admins;		
	}
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO�޸�����
	    * @author �Ϸ���  
	    * @date 2018��5��12�� ����12:32:15
	    *  
	    * @param adminid
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	@RequestMapping("/updatePSW")
	public @ResponseBody int updatePSW(HttpServletRequest request,  AdminsVo adminsVo) throws Exception {	
		HttpSession session = request.getSession();
		Admins admins = (Admins) session.getAttribute("admins");
		adminsVo.setAdminid(admins.getAdminid());  
		adminsService.updatePSW(request,adminsVo);
		return 1;
	}
	
	@RequestMapping("/seleteAll")
	public @ResponseBody List<AdminsCustom> seleteAll() throws Exception {
		List<AdminsCustom> list=adminsService.selectAll();
		System.out.println("===============>"+list.size());
		AdminsCustom adminsCustom=new AdminsCustom();
		return list;	
	}
	
		/**
		 * ͷ��ͼƬ�ϴ�
		 * @throws IOException 
		 */
		@RequestMapping(value = "/saveHeaderPic", method = RequestMethod.POST)
		public @ResponseBody Admins saveHeaderPic(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		        String resMsg = "";
		    try {
		        long  startTime=System.currentTimeMillis();
		        System.out.println("fileName��"+file.getOriginalFilename());
		        String fileName=new Date().getTime()+file.getOriginalFilename();
		        
		        HttpSession session = request.getSession();
				Admins admins = (Admins) session.getAttribute("admins");
				
		        String path=imgRealPath+fileName;
		        String viPath=imgViPath+fileName;
		        admins.setIcon(viPath);
		        adminsService.updateIcon(admins);
		        System.out.println("path::::::::::" + viPath);
		        
		        File newFile=new File(path);
		        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ� 
		        file.transferTo(newFile);
		        long  endTime=System.currentTimeMillis();
		        System.out.println("����ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
		        resMsg = fileName;
		    } catch (IllegalStateException e) {		    
		        e.printStackTrace();
		        resMsg = "0";
		    }
		       // response.getWriter().write(resMsg);
		        
				Admins admins = adminsService.selectByPrimaryKey(1);
				admins.setIcon(resMsg);
				return admins;
		    }
}
