package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Linkman;

public interface LinkmanMapperCustom {
	
	/**
	 * 
	 * @Title: selectAll
	 * @date:2018��5��28������8:42:27
	 * @Description: TODO �����û�������������ϵ��
	 * @param: @param userid
	 * @param: @return   
	 * @return: bulesky  
	 * @throws
	 */
    List<Linkman> selectAll(Integer userid);
    
    
    /**
     * 
     * @Title: getLinkManByStatus
     * @date:2018��5��28������12:51:37
     * @Description: TODO ѡ���û�������Ĭ�ϵĵ�ַ
     * @param: @param userid
     * @param: @return   
     * @return: bulesky  
     * @throws
     */
    Linkman selectLinkManByStatus(Integer userid);
   
}