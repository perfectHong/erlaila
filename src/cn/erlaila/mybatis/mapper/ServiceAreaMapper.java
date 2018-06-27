package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.ServiceArea;

public interface ServiceAreaMapper {
    int deleteByPrimaryKey(Integer serviceareaid);

    int insert(ServiceArea record);

    int insertSelective(ServiceArea record);

    ServiceArea selectByPrimaryKey(Integer serviceareaid);

    int updateByPrimaryKeySelective(ServiceArea record);

    int updateByPrimaryKey(ServiceArea record);
}