package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.NurseServiceContent;

public interface NurseServiceContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NurseServiceContent record);

    int insertSelective(NurseServiceContent record);

    NurseServiceContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NurseServiceContent record);

    int updateByPrimaryKey(NurseServiceContent record);
}