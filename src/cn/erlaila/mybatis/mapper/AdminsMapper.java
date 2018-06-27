package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Admins;

public interface AdminsMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);
}