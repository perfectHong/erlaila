package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.NurseServiceArea;

public interface NurseServiceAreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NurseServiceArea record);

    int insertSelective(NurseServiceArea record);

    NurseServiceArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NurseServiceArea record);

    int updateByPrimaryKey(NurseServiceArea record);
}