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
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��27�� ����2:03:52
 * @�汾 V 1.0
 */
public interface CommentNService {
	
   /**
    * 
    * @Title: insertCommentN
    * @date:2018��5��27������2:04:54
    * @Description: TODO ���뻤������
    * @param: @param commentN
    * @param: @return
    * @param: @throws Exception   
    * @return: bulesky  
    * @throws
    */
	public int insertCommentN(CommentN commentN) throws Exception;
	
	/** 
	 * @Title: selectAllByNurse
	 * @date:2018��6��1������6:19:33
	 * @Description: TODO ��ѯ�������Ե�����
	 * @param: @param nurseid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<CommentNCustom> selectAllByNurse(Integer nurseid) throws Exception;
	
}
