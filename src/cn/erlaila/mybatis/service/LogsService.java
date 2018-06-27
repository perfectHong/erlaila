package cn.erlaila.mybatis.service;

import javax.servlet.http.HttpServletRequest;

import cn.erlaila.mybatis.po.Logs;
import cn.erlaila.mybatis.po.User;

/**
 * 
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��6�� ����8:08:03
 * @�汾 V 1.0
 */
public interface LogsService {
	
    /**
     * @Title: insertLogs
     * @date:2018��5��6������8:17:57
	 * @Description: TODO ϵͳ������־��¼
	 * @param: @param userid �û�id
	 * @param: @param classname  ����������
	 * @param: @param method   �����ķ�����
	 * @param: @param operationname ����������
	 * @param: @param operationip �����˵���ʵIP��ַ
	 * @param: @param iswechatuser �ǲ���΢���û���΢���û���true,��̨�����û���false
	 * @param: @return �������ݿ�����Ӱ�������
	 * @param: @throws Exception   
	 * @return: bulesky 
     */
	public int insertLogs(int userid,String classname,String method,String operationname,String operationip,boolean iswechatuser) throws Exception;
}
