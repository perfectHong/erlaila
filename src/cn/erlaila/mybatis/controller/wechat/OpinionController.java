package cn.erlaila.mybatis.controller.wechat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.Opinion;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.service.OpinionService;

@Controller
@RequestMapping("/opinion")
public class OpinionController{
	
	@Autowired
	private OpinionService opinionService;
	
	@RequestMapping("/insertOpinion")
	@ResponseBody
	public String insertOpinion(HttpServletRequest request,Opinion opinion) throws Exception {
		//获取微信用户信息
		User userWechat=(User)request.getSession().getAttribute("userWechat");
		int userId=userWechat.getUserid();
		opinion.setUserid(userId);
		int n=opinionService.insertOpinion(opinion);
		return n+"";	
	}
	
	
}
