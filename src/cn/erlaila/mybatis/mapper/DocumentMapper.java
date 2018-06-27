package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Document;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer documentid);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer documentid);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
}