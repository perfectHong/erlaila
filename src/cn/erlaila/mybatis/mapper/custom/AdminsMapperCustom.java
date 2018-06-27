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
	 * @Description: TODO(������һ�仰�����������������)
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
	    * @Description: TODO(������һ�仰��������������)  
	    * @author �Ϸ���  
	    * @date 2018��5��10�� ����1:11:48
	    *  
	    * @param icon
	    * @return  
	    */  
	public int updateIcon(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO��¼ʱ�õĲ�������  
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����2:42:18
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public Admins selectAdminsPsw(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO    �������� 
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����2:42:42
	    *  
	    * @param adminsVo
	    * @return
	    * @throws Exception
	 */
	public int updatePSW(AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO ��������Ա
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����2:53:54
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public int insertAdmin(Admins admins) throws Exception;
}