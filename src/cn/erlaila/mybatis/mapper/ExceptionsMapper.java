package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Exceptions;

public interface ExceptionsMapper {
    int deleteByPrimaryKey(Integer exceptionid);

    int insert(Exceptions record);

    int insertSelective(Exceptions record);

    Exceptions selectByPrimaryKey(Integer exceptionid);

    int updateByPrimaryKeySelective(Exceptions record);

    int updateByPrimaryKey(Exceptions record);
}