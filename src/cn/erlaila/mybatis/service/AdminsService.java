package cn.erlaila.mybatis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;

/**
 * 系统后台用户
 * <p>Company:株洲老年人看护服务 </p>
 * @author buleshy
 * @date 2018年5月3日 下午4:51:10
 * @版本 V 1.0
 */
public interface AdminsService {
	
    /**
     * 
     * @Title: selectByPrimaryKey
     * @date:2018年5月6日下午8:20:28
     * @Description: TODO 根据管理员id查询管理员信息
     * @param: @param adminid 管理员id
     * @param: @return 管理员信息
     * @param: @throws Exception   
     * @return: bulesky  
     * @throws
     */
	public Admins selectByPrimaryKey(Integer adminid) throws Exception;
	
	/**
	 * 
	 * @Title: updateAdmins
	 * @date:2018年5月6日下午8:21:21
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * *@param: @param adminid 系统管理员的id
	 * @param: @param admins 需要修改的系统管理员信息
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public void updateAdmins(Integer adminid,Admins admins) throws Exception;
	
	/**
	 * 
	 * @Title: selectAll
	 * @date:2018年5月6日下午8:22:04
	 * @Description: TODO 查询所有系统用户
	 * @param: @return 系统用户集合
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<AdminsCustom> selectAll() throws Exception;
	
    /**
     * 
     * @Title: selectByLimit
     * @date:2018年5月6日下午8:23:57
     * @Description: TODO 分页查询系统管理员
     * @param: @param adminsVo 系统管理员包装类 分页查询所需要的参数
     * @param: @return Page laui框架分页查询所需要的数据格式处理类（将数据按照layui分页要求进行组装）
     * @param: @throws Exception   
     * @return: bulesky  
     * @throws
     */
	public Page selectByLimit(AdminsVo adminsVo) throws Exception;
	
	/**
	 * 
	 * @Title: selectCount
	 * @date:2018年5月6日下午8:22:43
	 * @Description: TODO 查询目前系统的管理员总数
	 * @param: @return 目前系统的管理员总数
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int selectCount() throws Exception;
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  更换头像
	    * @author 孟凡红  
	    * @date 2018年5月12日 下午12:36:37
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public int updateIcon(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO密码登录 
	    * @author 孟凡红  
	    * @date 2018年5月12日 下午12:37:00
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public Admins loginByPsw(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO修改密码 
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午2:19:10
	    *  
	    * @param request
	    * @param adminsVo
	    * @throws Exception
	 */
	public void updatePSW(HttpServletRequest request,AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   新增管理员
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午4:33:00
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public String insertAdmin(Admins admins) throws Exception;
}
