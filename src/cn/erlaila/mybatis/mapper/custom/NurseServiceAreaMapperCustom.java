package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceArea;

public interface NurseServiceAreaMapperCustom {

	public List<NurseServiceArea> selectByUserid(Integer userid);
     
}