package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.DayAccount;

public interface DayAccountMapper {
    int deleteByPrimaryKey(Integer dayaccountid);

    int insert(DayAccount record);

    int insertSelective(DayAccount record);

    DayAccount selectByPrimaryKey(Integer dayaccountid);

    int updateByPrimaryKeySelective(DayAccount record);

    int updateByPrimaryKey(DayAccount record);
}