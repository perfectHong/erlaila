package cn.erlaila.mybatis.controller.wechat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.erlaila.mybatis.po.CommentN;
import cn.erlaila.mybatis.po.Opinion;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.CommentNCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.service.CommentNService;
import cn.erlaila.mybatis.service.OpinionService;

@Controller
@RequestMapping("/commentN")
public class CommentNController{
	
	@Autowired
	private CommentNService commentNService;
	
	@RequestMapping("/insertCommentN")
	@ResponseBody
	public String insertCommentN(HttpServletRequest request,CommentN commentN) throws Exception {
		//获取微信用户信息
		User userWechat=(User)request.getSession().getAttribute("userWechat");
		int userId=userWechat.getUserid();
		commentN.setUserid(userId);
		int n=commentNService.insertCommentN(commentN);
		return n+"";	
	}
	
	/**
	 * 
	 * @Title: selectCommentNByNurse
	 * @date:2018年6月1日下午6:09:19
	 * @Description: TODO 获取护工的评论
	 * @param: @param request
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	@RequestMapping("/selectCommentNByNurse")
	public @ResponseBody List<CommentNCustom> selectCommentNByNurse(HttpServletRequest request,Integer nurseId) throws Exception {
		System.out.println("nurseId=========>"+nurseId);
		List<CommentNCustom> list=new ArrayList<CommentNCustom>();
		list=commentNService.selectAllByNurse(nurseId);//userId就是护工的user表中的id 
		return list;	
	}
	
}
