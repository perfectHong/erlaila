package cn.erlaila.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.NurseServiceAreaMapper;
import cn.erlaila.mybatis.mapper.NurseServiceContentMapper;
import cn.erlaila.mybatis.mapper.custom.NurseServiceAreaMapperCustom;
import cn.erlaila.mybatis.mapper.custom.NurseServiceContentMapperCustom;
import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.service.ServiceAreaService;

public class ServiceAreaServiceImpl implements ServiceAreaService{

	@Autowired
	private NurseServiceAreaMapper nurseServiceAreaMapper;
	
	@Autowired
	private NurseServiceAreaMapperCustom nurseServiceAreaMapperCustom ;
	
	@Override
	public int insertServiceArea(Integer userid, List<NurseServiceArea> list)
			throws Exception {
		//先查询出该护工选择的服务区域
		List<NurseServiceArea> nsalist=nurseServiceAreaMapperCustom.selectByUserid(userid);
		//删除这些数据
		if(nsalist!=null){
			for (NurseServiceArea nurseServiceArea : nsalist) {
				nurseServiceAreaMapper.deleteByPrimaryKey(nurseServiceArea.getId());
			}
		}
		//重新向数据库插入护工的服务区域
		for (NurseServiceArea nurseServiceArea : list) {
			nurseServiceArea.setUserid(userid);
			int n=nurseServiceAreaMapper.insert(nurseServiceArea);
		}
		int n=list.size();
		return n;
	}

}
