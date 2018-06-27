package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Documentcomment;

public interface DocumentcommentMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Documentcomment record);

    int insertSelective(Documentcomment record);

    Documentcomment selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(Documentcomment record);

    int updateByPrimaryKey(Documentcomment record);
}