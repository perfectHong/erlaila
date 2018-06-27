package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.po.vo.UserVo;

public interface UserMapperCustom {
	
	 User selectByOpenId(String openId);
	 
	 /**
	  * 
	  * @Title: selectByLimit
	  * @date:2018年5月7日下午7:46:42
	  * @Description: TODO 分页查询护工的详细信息
	  * @param: @param userVo 包含分页所需的参数 第几页和页面显示条数
	  * @param: @return
	  * @param: @throws Exception   
	  * @return: bulesky  
	  * @throws
	  */
	 List<UserCustom> selectByLimit(NurseDetailVo nursedetailVo) throws Exception;
	 
	 UserCustom seleteuserByUserid(Integer userid) throws Exception;
	 
	 int selectCount() throws Exception;
	 
	 int selectNurseCount() throws Exception;
	 
	 public List<User> selectUserByLimit(AdminsVo adminsVo) throws Exception;
	 
	 public List<User> selectNurseByLimit(AdminsVo adminsVo) throws Exception;
}