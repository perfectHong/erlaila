package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Journalaccount;

public interface JournalaccountMapper {
    int deleteByPrimaryKey(Integer journalaccountid);

    int insert(Journalaccount record);

    int insertSelective(Journalaccount record);

    Journalaccount selectByPrimaryKey(Integer journalaccountid);

    int updateByPrimaryKeySelective(Journalaccount record);

    int updateByPrimaryKey(Journalaccount record);
}