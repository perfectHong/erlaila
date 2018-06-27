package cn.erlaila.mybatis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.erlaila.mybatis.controller.wechat.CommentNController;
import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.CommentN;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.CommentNCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;

/**
 * 
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月27日 下午2:03:52
 * @版本 V 1.0
 */
public interface CommentNService {
	
   /**
    * 
    * @Title: insertCommentN
    * @date:2018年5月27日下午2:04:54
    * @Description: TODO 插入护工评论
    * @param: @param commentN
    * @param: @return
    * @param: @throws Exception   
    * @return: bulesky  
    * @throws
    */
	public int insertCommentN(CommentN commentN) throws Exception;
	
	/** 
	 * @Title: selectAllByNurse
	 * @date:2018年6月1日下午6:19:33
	 * @Description: TODO 查询护工所以的评论
	 * @param: @param nurseid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<CommentNCustom> selectAllByNurse(Integer nurseid) throws Exception;
	
}
