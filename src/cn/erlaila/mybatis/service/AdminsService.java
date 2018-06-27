package cn.erlaila.mybatis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;

/**
 * ϵͳ��̨�û�
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��3�� ����4:51:10
 * @�汾 V 1.0
 */
public interface AdminsService {
	
    /**
     * 
     * @Title: selectByPrimaryKey
     * @date:2018��5��6������8:20:28
     * @Description: TODO ���ݹ���Աid��ѯ����Ա��Ϣ
     * @param: @param adminid ����Աid
     * @param: @return ����Ա��Ϣ
     * @param: @throws Exception   
     * @return: bulesky  
     * @throws
     */
	public Admins selectByPrimaryKey(Integer adminid) throws Exception;
	
	/**
	 * 
	 * @Title: updateAdmins
	 * @date:2018��5��6������8:21:21
	 * @Description: TODO(������һ�仰�����������������)
	 * *@param: @param adminid ϵͳ����Ա��id
	 * @param: @param admins ��Ҫ�޸ĵ�ϵͳ����Ա��Ϣ
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public void updateAdmins(Integer adminid,Admins admins) throws Exception;
	
	/**
	 * 
	 * @Title: selectAll
	 * @date:2018��5��6������8:22:04
	 * @Description: TODO ��ѯ����ϵͳ�û�
	 * @param: @return ϵͳ�û�����
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<AdminsCustom> selectAll() throws Exception;
	
    /**
     * 
     * @Title: selectByLimit
     * @date:2018��5��6������8:23:57
     * @Description: TODO ��ҳ��ѯϵͳ����Ա
     * @param: @param adminsVo ϵͳ����Ա��װ�� ��ҳ��ѯ����Ҫ�Ĳ���
     * @param: @return Page laui��ܷ�ҳ��ѯ����Ҫ�����ݸ�ʽ�����ࣨ�����ݰ���layui��ҳҪ�������װ��
     * @param: @throws Exception   
     * @return: bulesky  
     * @throws
     */
	public Page selectByLimit(AdminsVo adminsVo) throws Exception;
	
	/**
	 * 
	 * @Title: selectCount
	 * @date:2018��5��6������8:22:43
	 * @Description: TODO ��ѯĿǰϵͳ�Ĺ���Ա����
	 * @param: @return Ŀǰϵͳ�Ĺ���Ա����
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int selectCount() throws Exception;
	
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO  ����ͷ��
	    * @author �Ϸ���  
	    * @date 2018��5��12�� ����12:36:37
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public int updateIcon(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO�����¼ 
	    * @author �Ϸ���  
	    * @date 2018��5��12�� ����12:37:00
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public Admins loginByPsw(Admins admins) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO�޸����� 
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����2:19:10
	    *  
	    * @param request
	    * @param adminsVo
	    * @throws Exception
	 */
	public void updatePSW(HttpServletRequest request,AdminsVo adminsVo) throws Exception;
	/**
	 * 
	    * @ClassName:   
	    * @Description: TODO   ��������Ա
	    * @author �Ϸ���  
	    * @date 2018��5��14�� ����4:33:00
	    *  
	    * @param admins
	    * @return
	    * @throws Exception
	 */
	public String insertAdmin(Admins admins) throws Exception;
}
