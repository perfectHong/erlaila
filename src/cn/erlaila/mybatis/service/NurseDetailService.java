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
	 * @date:2018年5月31日下午3:32:42
	 * @Description: TODO 修改陪护人员信息
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
	 * @date:2018年5月11日下午3:35:37
	 * @Description: TODO 根据微信用户id查询护工的真实姓名
	 * @param: @param userid 微信用户id
	 * @param: @return 护工的详细信息
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public String seleteRealNameByUserid(Integer userid) throws Exception;

	/**
	 * 
	 * @Title: seleteContentAndAreaByUserid
	 * @date:2018年5月15日上午10:58:26
	 * @Description: TODO 根据护工id查询出护工所选的服务区域以及内容
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
	 * @date:2018年5月15日下午12:48:23
	 * @Description: TODO 插入护工实名认证
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
	 * @date:2018年5月16日上午9:01:14
	 * @Description: TODO 查询待审核的护工
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public Page  selectWaitValidateNurse() throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailById
	 * @date:2018年5月16日下午4:04:58
	 * @Description: TODO 根据用户id查询用户的详细信息，包括微信用户基本信息，护工详细信息，服务区域，服务内容，实名认证
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
	 * @date:2018年5月20日下午6:14:06
	 * @Description: TODO 根据护工详情id 查询护工信息
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
	 * @date:2018年5月22日下午3:14:52
	 * @Description: TODO 根据用户id查询护工详细信息
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
	 * @date:2018年5月7日下午9:48:26
	 * @Description: TODO 根据条件分页查询护工详细信息
	 * @param: @return List<UserCustom>护工详细信息集合
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<UserCustom> selectByLimit(NurseDetailVo nurseDetailVo) throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseBaseInfoById
	 * @date:2018年5月31日下午2:43:16
	 * @Description: TODO 陪护人员查询基本信息
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseBaseInfoById(Integer userid) throws Exception;
}
