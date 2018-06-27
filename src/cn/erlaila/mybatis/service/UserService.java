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
	 * @date:2018年5月6日下午8:17:40
	 * @Description: TODO判断该用户是否已经在系统中注册
	 * @param: @param openid 微信用户在该公众平台下的
	 * @param: @return 用户信息，加入不存在则为null
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public User doLogin(String openid) throws Exception;
	
	/**
	 * 
	 * @Title: insert
	 * @date:2018年5月6日下午8:17:57
	 * @Description: TODO新增微信用户
	 * @param: @param user 微信用户信息
	 * @param: @return  表格中受影响的行数  
	 * @return: bulesky  
	 * @throws
	 */
	public int insert(User user) throws Exception;
	

	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO(这里用一句话描述这个类的作用)  
	    * @author 孟凡红  
	    * @date 2018年5月8日 上午10:15:51
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
	 * @date:2018年5月11日下午3:01:49
	 * @Description: TODO 更新用户信息
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
	    * @Description: TODO   查找用户总数
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午4:42:37
	    *  
	    * @return
	    * @throws Exception
	 */
	public int selectCount() throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  查找护工总数 
	    * @author 孟凡红  
	    * @date 2018年5月15日 上午10:09:11 
	    * @return
	    * @throws Exception
	 */
	public int selectNurseCount() throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   分页查找所有用户 
	    * @author 孟凡红  
	    * @date 2018年5月15日 上午10:10:19
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	public Page selectByLimit(AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   分页查找所有护工
	    * @author 孟凡红  
	    * @date 2018年5月15日 上午10:10:19
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	
	public Page selectNurseByLimit(AdminsVo adminsVo) throws Exception;
	
}
