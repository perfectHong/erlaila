package cn.erlaila.mybatis.service;

import java.util.List;

import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.po.vo.Page;

public interface NurseDetailService{	
	
	/**
	 * 
	 * @Title: uodateNurseInfo
	 * @date:2018��5��31������3:32:42
	 * @Description: TODO �޸��㻤��Ա��Ϣ
	 * @param: @param userid
	 * @param: @param nurseDetailVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public String uodateNurseInfo(Integer userid,NurseDetailVo nurseDetailVo) throws Exception;
	
	/**
	 * 
	 * @Title: seleteRealNameByUserid
	 * @date:2018��5��11������3:35:37
	 * @Description: TODO ����΢���û�id��ѯ��������ʵ����
	 * @param: @param userid ΢���û�id
	 * @param: @return ��������ϸ��Ϣ
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public String seleteRealNameByUserid(Integer userid) throws Exception;

	/**
	 * 
	 * @Title: seleteContentAndAreaByUserid
	 * @date:2018��5��15������10:58:26
	 * @Description: TODO ���ݻ���id��ѯ��������ѡ�ķ��������Լ�����
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo seleteContentAndAreaByUserid(Integer userid) throws Exception;
	
	/**
	 * 
	 * @Title: updateNurseValidate
	 * @date:2018��5��15������12:48:23
	 * @Description: TODO ���뻤��ʵ����֤
	 * @param: @param nurseDetailVo
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int insertNurseValidate(NurseDetailVo nurseDetailVo) throws Exception;

	/**
	 * 
	 * @Title: selectWaitValidateNurse
	 * @date:2018��5��16������9:01:14
	 * @Description: TODO ��ѯ����˵Ļ���
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Page  selectWaitValidateNurse() throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailById
	 * @date:2018��5��16������4:04:58
	 * @Description: TODO �����û�id��ѯ�û�����ϸ��Ϣ������΢���û�������Ϣ��������ϸ��Ϣ���������򣬷������ݣ�ʵ����֤
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseDetailById(Integer userid) throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailByKey
	 * @date:2018��5��20������6:14:06
	 * @Description: TODO ���ݻ�������id ��ѯ������Ϣ
	 * @param: @param nursrId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Nursedetail selectNurseDetailByKey(Integer nurseId) throws Exception;
	
	
	/**
	 * 
	 * @Title: selectNurseDetailByUserId
	 * @date:2018��5��22������3:14:52
	 * @Description: TODO �����û�id��ѯ������ϸ��Ϣ
	 * @param: @param userId
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Nursedetail selectNurseDetailByUserId(Integer userId) throws Exception;
	
	/**
	 * 
	 * @Title: selectByLimit
	 * @date:2018��5��7������9:48:26
	 * @Description: TODO ����������ҳ��ѯ������ϸ��Ϣ
	 * @param: @return List<UserCustom>������ϸ��Ϣ����
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<UserCustom> selectByLimit(NurseDetailVo nurseDetailVo) throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseBaseInfoById
	 * @date:2018��5��31������2:43:16
	 * @Description: TODO �㻤��Ա��ѯ������Ϣ
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseBaseInfoById(Integer userid) throws Exception;
}
