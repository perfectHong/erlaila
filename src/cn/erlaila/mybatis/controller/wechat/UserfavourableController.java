package cn.erlaila.mybatis.controller.wechat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.service.UserfavourableService;

/**
 * 
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��19�� ����9:13:52
 * @�汾 V 1.0
 */
@Controller
@RequestMapping("/userfavourable")
public class UserfavourableController {
	
	@Autowired
	private UserfavourableService userfavourableService;
	/**
	 * 
	 * @Title: getUserFavourable
	 * @date:2018��5��19������9:18:28
	 * @Description: TODO ��ȡ΢���û�����ʹ�õ��Żݾ�
	 * @param: @param 
	 * @param: @return 
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/getUserFavourable")
	public  @ResponseBody List<Favourable> getUserFavourable(HttpServletRequest request) throws Exception {
		//User user=(User)request.getSession().getAttribute("userWechat");
		int userid=8;//user.getUserid();
		List<Favourable> list=userfavourableService.selectFavourableByUser(userid);
		return list;
	}
}
