package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.UserCustom;

public interface ServiceAreaService{	
	
	/**
	 * 
	 * @Title: insertServiceArea
	 * @date:2018��5��15������9:29:52
	 * @Description: TODO ���»�����������
	 * @param: @param userid ����id
	 * @param: @param list
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertServiceArea(Integer userid,List<NurseServiceArea> list) throws Exception;
	
}
