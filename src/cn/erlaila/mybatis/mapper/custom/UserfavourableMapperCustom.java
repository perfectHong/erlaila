package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Userfavourable;

public interface UserfavourableMapperCustom {
 
   public List<Userfavourable> selectByUserid(Integer userid);
   
   public int updateFavourableByUIdAndFId(Userfavourable userFavourable);

}