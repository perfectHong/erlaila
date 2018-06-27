package cn.erlaila.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.FavourableMapper;
import cn.erlaila.mybatis.mapper.UserfavourableMapper;
import cn.erlaila.mybatis.mapper.custom.UserfavourableMapperCustom;
import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.po.Userfavourable;
import cn.erlaila.mybatis.service.UserfavourableService;



public class UserfavourableIServicempl implements UserfavourableService {

	@Autowired
	private FavourableMapper favourableMapper;
	
	@Autowired
	private UserfavourableMapper userfavourableMapper;
	
	@Autowired
	private UserfavourableMapperCustom userfavourableMapperCustom;
	
	@Override
	public List<Favourable>  selectFavourableByUser(Integer userid) throws Exception {
		List<Favourable> favourableList=new ArrayList<Favourable>();
		//获取用户的优惠卷集合
		 List<Userfavourable> list=userfavourableMapperCustom.selectByUserid(userid);
		 if(list!=null){
			 for (Userfavourable userfavourable : list) {
				 int favourableid=userfavourable.getFavourableid();
				 Favourable favourable = favourableMapper.selectByPrimaryKey(favourableid);
				 favourableList.add(favourable);		 
			}
		 }
		return favourableList;
	}

	@Override
	public int updateFavourableByUIdAndFId(Userfavourable userFavourable) throws Exception {
		int n=userfavourableMapperCustom.updateFavourableByUIdAndFId(userFavourable);
		return n;
	}
	
}
