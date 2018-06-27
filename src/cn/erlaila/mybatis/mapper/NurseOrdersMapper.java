package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.NurseOrders;

public interface NurseOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NurseOrders record);

    int insertSelective(NurseOrders record);

    NurseOrders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NurseOrders record);

    int updateByPrimaryKey(NurseOrders record);
}