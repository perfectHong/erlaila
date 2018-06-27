package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.CommentN;

public interface CommentNMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(CommentN record);

    int insertSelective(CommentN record);

    CommentN selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(CommentN record);

    int updateByPrimaryKeyWithBLOBs(CommentN record);

    int updateByPrimaryKey(CommentN record);
}