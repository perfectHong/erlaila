package cn.erlaila.mybatis.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.AdminsMapper;
import cn.erlaila.mybatis.mapper.custom.AdminsMapperCustom;
import cn.erlaila.mybatis.po.Admins;
import cn.erlaila.mybatis.po.custom.AdminsCustom;
import cn.erlaila.mybatis.po.vo.AdminsVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.AdminsService;

public class AdminsServiceImpl implements AdminsService {

	@Autowired
	private AdminsMapper adminsMapper;
	
	@Autowired
	private AdminsMapperCustom adminsMapperCustom;
	
	@Override
	public Admins selectByPrimaryKey(Integer adminid) throws Exception {
		Admins admins=null;
		if(adminid==null){
			
		}else{
			admins=adminsMapper.selectByPrimaryKey(adminid);
		}
		return admins;
	}

	@Override
	public void updateAdmins(Integer adminid,Admins admins) throws Exception {
		if(adminid!=null){
			adminsMapper.updateByPrimaryKeySelective(admins);
		}else{
			
		}			
	}

	@Override
	public List<AdminsCustom> selectAll() throws Exception {
		List<AdminsCustom> list=adminsMapperCustom.selectAll();
		return list;
	}
    
	
	@Override
	public Page selectByLimit(AdminsVo adminsVo) throws Exception {
		adminsVo.setPageNum(adminsVo.getPageNum()-1);
		List<AdminsCustom> List= adminsMapperCustom.selectByLimit(adminsVo);
	    Page page=new Page();
	    page.setCode("0");
	    page.setCount(List.size()+"");
	    page.setData(List);
	    page.setMsg(""); 
	    return page;
	}

	@Override
	public int selectCount() throws Exception {
		int count=adminsMapperCustom.selectCount();
		return count;
	}

	
	
	
	

	
	@Override
	public int updateIcon(Admins admins) throws Exception {
		int i=adminsMapperCustom.updateIcon(admins);
		return 0;
	}

	
	@Override
	public Admins loginByPsw(Admins admins) throws Exception {
		Admins admins1=adminsMapperCustom.selectAdminsPsw(admins);
		return admins1;
		//System.out.println(admins.getPassword());
		//if(admins1!=null){
		//	return admins1;
		//}
		
	}
	
	@Override
	public void updatePSW(HttpServletRequest request,AdminsVo adminsVo) throws Exception {
		HttpSession session = request.getSession();
		Admins admins = (Admins) session.getAttribute("admins");
		if(adminsVo.getPsw().equals(admins.getPassword())){
			adminsMapperCustom.updatePSW(adminsVo);	
		}
	}

	
	@Override
	public String insertAdmin(Admins admins) throws Exception {
		adminsMapperCustom.insertAdmin(admins);	
		return null;
	}
}
