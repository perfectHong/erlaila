package cn.erlaila.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.FavourableMapper;
import cn.erlaila.mybatis.po.Favourable;

/**
 * 
 * <p>Company:���������˿������� </p>
 * @author buleshy
 * @date 2018��5��19�� ����9:21:36
 * @�汾 V 1.0
 */
public interface FavourableService {
	
	/**
	 * 
	 * @Title: selectFavourableByUser
	 * @date:2018��5��19������9:24:22
	 * @Description: TODO ͨ���Żݾ�id��ȡ���Żݾ���Ϣ
	 * @param: @param favourableId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Favourable selectFavourableById(Integer favourableId) throws Exception; 
	
}
