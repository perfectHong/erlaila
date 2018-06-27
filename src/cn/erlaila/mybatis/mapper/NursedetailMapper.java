package cn.erlaila.mybatis.mapper;

import cn.erlaila.mybatis.po.Nursedetail;

public interface NursedetailMapper {
    int deleteByPrimaryKey(Integer nursedetailid);

    int insert(Nursedetail record);

    int insertSelective(Nursedetail record);

    Nursedetail selectByPrimaryKey(Integer nursedetailid);

    int updateByPrimaryKeySelective(Nursedetail record);

    int updateByPrimaryKey(Nursedetail record);
}