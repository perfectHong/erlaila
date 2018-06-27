package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Logs;

public interface LogsMapper {
    int deleteByPrimaryKey(Integer logsid);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer logsid);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
}