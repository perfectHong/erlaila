package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Favourable;

public interface FavourableMapper {
    int deleteByPrimaryKey(Integer favourableid);

    int insert(Favourable record);

    int insertSelective(Favourable record);

    Favourable selectByPrimaryKey(Integer favourableid);

    int updateByPrimaryKeySelective(Favourable record);

    int updateByPrimaryKey(Favourable record);
}