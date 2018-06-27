package cn.erlaila.mybatis.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.CommentNMapper;
import cn.erlaila.mybatis.mapper.custom.CommentNMapperCustom;
import cn.erlaila.mybatis.po.CommentN;
import cn.erlaila.mybatis.po.WechatOrders;
import cn.erlaila.mybatis.po.custom.CommentNCustom;
import cn.erlaila.mybatis.service.CommentNService;
import cn.erlaila.mybatis.service.UserService;
import cn.erlaila.mybatis.service.WechatOrdersService;

public class CommentNServiceImpl implements CommentNService{

	@Autowired
	private CommentNMapper commentNMapper;
	
	@Autowired
	private CommentNMapperCustom commentNMapperCustom;

	@Autowired
	private WechatOrdersService wechatOrdersService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public int insertCommentN(CommentN commentN) throws Exception {
		int n=commentNMapper.insertSelective(commentN);
		int orderid=commentN.getOrderid();
		WechatOrders wechatOrders=new WechatOrders();
		wechatOrders.setOrderid(orderid);
		wechatOrders.setServicestatus(5);//用户已经评论
		//更新完评论 更新订单状态
		int l=wechatOrdersService.updateByorderIdSelective(orderid, wechatOrders);
		return n;
	}

	@Override
	public List<CommentNCustom> selectAllByNurse(Integer nurseid) throws Exception {
		List<CommentN>  list=commentNMapperCustom.selectAllByNurse(nurseid);
		List<CommentNCustom> list2=new ArrayList<CommentNCustom>();
		for (CommentN commentN : list) {
			CommentNCustom commentNCustom=new CommentNCustom();
			int nurseId=commentN.getNurseid();
			String comtenttel = userService.selectUserOnly(nurseId).getTelephone();
			commentNCustom.setComtenttel(comtenttel);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateString=simpleDateFormat.format(commentN.getCommentdate());
			commentNCustom.setComtentdate(dateString);
			commentNCustom.setCommentvalue(commentN.getCommentvalue());
			list2.add(commentNCustom);
		}
		return list2;
	}

}
