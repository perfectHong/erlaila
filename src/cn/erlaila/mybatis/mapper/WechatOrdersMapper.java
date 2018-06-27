package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.WechatOrders;

public interface WechatOrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WechatOrders record);

    int insertSelective(WechatOrders record);

    WechatOrders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WechatOrders record);

    int updateByPrimaryKey(WechatOrders record);
}