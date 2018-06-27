package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.RealNameAuthentication;

public interface RealNameAuthenticationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RealNameAuthentication record);

    int insertSelective(RealNameAuthentication record);

    RealNameAuthentication selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RealNameAuthentication record);

    int updateByPrimaryKey(RealNameAuthentication record);
}