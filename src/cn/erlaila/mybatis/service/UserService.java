package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;

public interface UserService{	
	
	/**
	 * 
	 * @Title: doLogin
	 * @date:2018��5��6������8:17:40
	 * @Description: TODO�жϸ��û��Ƿ��Ѿ���ϵͳ��ע��
	 * @param: @param openid ΢���û��ڸù���ƽ̨�µ�
	 * @param: @return �û���Ϣ�����벻������Ϊnull
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public User doLogin(String openid) throws Exception;
	
	/**
	 * 
	 * @Title: insert
	 * @date:2018��5��6������8:17:57
	 * @Description: TODO����΢���û�
	 * @param: @param user ΢���û���Ϣ
	 * @param: @return  �������Ӱ�������  
	 * @return: bulesky  
	 * @throws
	 */
	public int insert(User user) throws Exception;
	

	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO(������һ�仰��������������)  
	    * @author �Ϸ���  
	    * @date 2018��5��8�� ����10:15:51
	    *  
	    * @param user
	    * @return
	    * @throws Exception
	 */
	public User selectUserOnly(int userId) throws Exception;
	
	public UserCustom seleteuserByUserid(int userId) throws Exception;
	
	/**
	 * 
	 * @Title: updateUserByUserid
	 * @date:2018��5��11������3:01:49
	 * @Description: TODO �����û���Ϣ
	 * @param: @param User
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public void updateUserByUserid(Integer userId,User use) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   �����û�����
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����4:42:37
	    *  
	    * @return
	    * @throws Exception
	 */
	public int selectCount() throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  ���һ������� 
	    * @author �Ϸ���  
	    * @date 2018��5��15�� ����10:09:11 
	    * @return
	    * @throws Exception
	 */
	public int selectNurseCount() throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   ��ҳ���������û� 
	    * @author �Ϸ���  
	    * @date 2018��5��15�� ����10:10:19
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	public Page selectByLimit(AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   ��ҳ�������л���
	    * @author �Ϸ���  
	    * @date 2018��5��15�� ����10:10:19
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	
	public Page selectNurseByLimit(AdminsVo adminsVo) throws Exception;
	
}
