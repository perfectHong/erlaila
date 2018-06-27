package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;

public interface NursedetailMapperCustom {	

	/**
	 *  
	 * @Title: selectRealNameByUserId
	 * @date:2018��5��11������3:45:25
	 * @Description: TODO ����΢���û���id��ѯ��������ʵ����
	 * @param: @param userId  ΢���û���id
	 * @param: @return ��������ʵ����
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public String selectRealNameByUserId(Integer userId) throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailByUserId
	 * @date:2018��5��15������1:38:16
	 * @Description: TODO ����΢���û�id��ѯ��������ϸ��Ϣ
	 * @param: @param userId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Nursedetail selectNurseDetailByUserId(Integer userId) throws Exception;
	
	/**
	 * 
	 * @Title: selectWaitValidateNurse
	 * @date:2018��5��16������9:03:37
	 * @Description: TODO ��ѯ������˵Ļ���
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<NurseCustom> selectWaitValidateNurse() throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailById
	 * @date:2018��5��16������4:02:15
	 * @Description: TODO �����û�id ��ѯ��������������Ϣ������΢���û�������Ϣ��������ϸ��Ϣ���������򣬷������ݣ�ʵ����֤
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseDetailById(Integer userid) throws Exception;

	/**
	 * 
	 * @Title: selectNurseBaseInfoById
	 * @date:2018��5��31������2:41:42
	 * @Description: TODO �㻤��Ա��ѯ������Ϣ
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseBaseInfoById(Integer userid) throws Exception;
	
	/**
	 * 
	 * @Title: updateByUserIdSelective
	 * @date:2018��5��31������3:40:46
	 * @Description: TODO ����userid�޸�nurseDetail��Ϣ
	 * @param: @param record
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateByUserIdSelective(Nursedetail record) throws Exception;
		
}