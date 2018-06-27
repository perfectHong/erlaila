package cn.erlaila.mybatis.mapper.custom;



import java.util.List;

import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;


public interface AdminsMapperCustom {
	
	public List<AdminsCustom> selectAll() throws Exception;
	
	/**
	 * 
	 * @Title: selectByLimit
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param adminsVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @au: bulesky  
	 * @throws
	 */
	public List<AdminsCustom> selectByLimit(AdminsVo adminsVo) throws Exception;
	
	public int selectCount() throws Exception;

	    /**  
	    * @ClassName:   
	    * @Description: TODO(这里用一句话描述这个类的作用)  
	    * @author 孟凡红  
	    * @date 2018年5月10日 下午1:11:48
	    *  
	    * @param icon
	    * @return  
	    */  
	public int updateIcon(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO登录时用的查找密码  
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午2:42:18
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public Admins selectAdminsPsw(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO    更改密码 
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午2:42:42
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	public int updatePSW(AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO 新增管理员
	    * @author 孟凡红  
	    * @date 2018年5月14日 下午2:53:54
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public int insertAdmin(Admins admins) throws Exception;
}