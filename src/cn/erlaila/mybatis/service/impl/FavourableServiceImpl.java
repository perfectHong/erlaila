package cn.erlaila.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.FavourableMapper;
import cn.erlaila.mybatis.po.Favourable;
import cn.erlaila.mybatis.service.FavourableService;

public class FavourableServiceImpl implements FavourableService{

	@Autowired
	private FavourableMapper favourableMapper;
	
	@Override
	public Favourable selectFavourableById(Integer favourableId)
			throws Exception {
		Favourable favourable=null;
		if(favourableId!=null){
			favourable=favourableMapper.selectByPrimaryKey(favourableId);
		}
		return favourable;
	}

}
