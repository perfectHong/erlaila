package cn.erlaila.mybatis.mapper.custom;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;

public interface NurseServiceContentMapperCustom {  
	
    public List<NurseServiceContent> selectByServiceIdLimit(NurseDetailVo nurseDetailVo);	
    
    public List<NurseServiceContent> selectByUserId(Integer userid);	
    
    public int selectCountByServiceId(Integer serviceTypeId);
    
}