package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.CommentN;

public interface CommentNMapperCustom {
   
    List<CommentN> selectAllByNurse(Integer nurseid);

}