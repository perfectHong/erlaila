package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Linkman;

public interface LinkmanMapper {
    int deleteByPrimaryKey(Integer linkmanid);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    Linkman selectByPrimaryKey(Integer linkmanid);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}