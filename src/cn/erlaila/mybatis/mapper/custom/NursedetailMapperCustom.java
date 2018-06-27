package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;

public interface NursedetailMapperCustom {	

	/**
	 *  
	 * @Title: selectRealNameByUserId
	 * @date:2018年5月11日下午3:45:25
	 * @Description: TODO 根据微信用户的id查询护工的真实姓名
	 * @param: @param userId  微信用户的id
	 * @param: @return 护工的真实姓名
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public String selectRealNameByUserId(Integer userId) throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailByUserId
	 * @date:2018年5月15日下午1:38:16
	 * @Description: TODO 根据微信用户id查询护工的详细信息
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
	 * @date:2018年5月16日上午9:03:37
	 * @Description: TODO 查询出待审核的护工
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public List<NurseCustom> selectWaitValidateNurse() throws Exception;
	
	/**
	 * 
	 * @Title: selectNurseDetailById
	 * @date:2018年5月16日下午4:02:15
	 * @Description: TODO 根据用户id 查询出护工的所有信息，包括微信用户基本信息，护工详细信息，服务区域，服务内容，实名认证
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public NurseDetailVo selectNurseDetailById(Integer userid) throws Exception;

	/**
	 * 
	 * @Title: selectNurseBaseInfoById
	 * @date:2018年5月31日下午2:41:42
	 * @Description: TODO 陪护人员查询基本信息
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
	 * @date:2018年5月31日下午3:40:46
	 * @Description: TODO 根据userid修改nurseDetail信息
	 * @param: @param record
	 * @param: @return
	 * @param: @throws Exception   
	 * @return: bulesky  
	 * @throws
	 */
	public int updateByUserIdSelective(Nursedetail record) throws Exception;
		
}