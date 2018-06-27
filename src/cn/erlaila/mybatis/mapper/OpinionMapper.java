package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Opinion;

public interface OpinionMapper {
    int deleteByPrimaryKey(Integer opinionid);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    Opinion selectByPrimaryKey(Integer opinionid);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKeyWithBLOBs(Opinion record);

    int updateByPrimaryKey(Opinion record);
}