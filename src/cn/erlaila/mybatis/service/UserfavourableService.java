package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Userfavourable;

public interface UserfavourableService {
	
	/**
	 * 
	 * @Title: selectFavourableByUser
	 * @date:2018��5��19������9:37:01
	 * @Description: TODO ͨ���û�id ��ȡ΢���û�����ʹ�õ��Żݾ�
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<Favourable>  selectFavourableByUser(Integer userid) throws Exception; 
	
	/**
	 * 
	 * @Title: updateFavourableById
	 * @date:2018��5��21������6:31:12
	 * @Description: TODO ͨ��id�����û��Żݾ���Ϣ
	 * @param: @param favourableId
	 * @param: @param userFavourable
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateFavourableByUIdAndFId(Userfavourable userFavourable) throws Exception;
}
