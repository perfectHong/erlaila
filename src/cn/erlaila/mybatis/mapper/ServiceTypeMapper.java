package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.ServiceType;

public interface ServiceTypeMapper {
    int deleteByPrimaryKey(Integer serviceid);

    int insert(ServiceType record);

    int insertSelective(ServiceType record);

    ServiceType selectByPrimaryKey(Integer serviceid);

    int updateByPrimaryKeySelective(ServiceType record);

    int updateByPrimaryKey(ServiceType record);
}