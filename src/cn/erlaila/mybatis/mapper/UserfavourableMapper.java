package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Userfavourable;

public interface UserfavourableMapper {
    int deleteByPrimaryKey(Integer ufid);

    int insert(Userfavourable record);

    int insertSelective(Userfavourable record);

    Userfavourable selectByPrimaryKey(Integer ufid);

    int updateByPrimaryKeySelective(Userfavourable record);

    int updateByPrimaryKey(Userfavourable record);
}