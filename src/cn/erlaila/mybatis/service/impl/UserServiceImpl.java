package cn.erlaila.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import cn.erlaila.mybatis.mapper.AdminsMapper;
import cn.erlaila.mybatis.mapper.UserMapper;
import cn.erlaila.mybatis.mapper.custom.NurseServiceContentMapperCustom;
import cn.erlaila.mybatis.mapper.custom.UserMapperCustom;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private NurseServiceContentMapperCustom NurseServiceContentMapperCustom;
	
	@Override
	public User doLogin(String openid) throws Exception {
		System.out.println("openid==============>"+openid);
		System.out.println("openid==============>"+openid);
		System.out.println("openid==============>"+openid);
		System.out.println("openid==============>"+openid);
		System.out.println("openid==============>"+openid);
	    //查询数据库是否存在该用户
	    User user=userMapperCustom.selectByOpenId(openid);
	    return user;
	}

	@Override
	public int insert(User user) {
		int num=userMapper.insert(user);
		return num;
	}


	/* (non-Javadoc)
	 * @see cn.erlaila.mybatis.service.UserService#selectTelephone(int)
	 */
	@Override
	public User selectUserOnly(int userid) throws Exception {
		User user=userMapper.selectByPrimaryKey(userid);
		return user;
	}

	@Override
	public UserCustom seleteuserByUserid(int userId) throws Exception {
		UserCustom userCustom=userMapperCustom.seleteuserByUserid(userId);
		return userCustom;
	}

	@Override
	public void updateUserByUserid(Integer userId,User use) throws Exception {
		if(userId!=null){
			userMapper.updateByPrimaryKeySelective(use);
		}
	}

	
	@Override
	public int selectCount() throws Exception {
		int count=userMapperCustom.selectCount();
		return count;
	}

	
	@Override
	public Page selectByLimit(AdminsVo adminsVo) throws Exception {
		adminsVo.setPageNum(adminsVo.getPageNum()-1);
		List<User> List= userMapperCustom.selectUserByLimit(adminsVo);
	    Page page=new Page();
	    page.setCode("0");
	    page.setCount(List.size()+"");
	    page.setData(List);
	    page.setMsg(""); 
	    return page;
	}

	@Override
	public int selectNurseCount() throws Exception {
		int count=userMapperCustom.selectNurseCount();
		return count;
	}
	@Override
	public Page selectNurseByLimit(AdminsVo adminsVo) throws Exception {
		adminsVo.setPageNum(adminsVo.getPageNum()-1);
		List<User> List= userMapperCustom.selectNurseByLimit(adminsVo);
	    Page page=new Page();
	    page.setCode("0");
	    page.setCount(List.size()+"");
	    page.setData(List);
	    page.setMsg(""); 
	    return page;
	}
}
