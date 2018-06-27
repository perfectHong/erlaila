package cn.erlaila.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.erlaila.mybatis.mapper.NurseServiceContentMapper;
import cn.erlaila.mybatis.mapper.custom.NurseServiceContentMapperCustom;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.service.NurseServiceContentService;

public class NurseServiceContentServiceImpl implements NurseServiceContentService{

	@Autowired
	private NurseServiceContentMapperCustom nurseServiceContentMapperCustom;
	
	@Autowired
	private NurseServiceContentMapper nurseServiceContentMapper;
	
	@Override
	public int insertServiceContent(Integer userid,List<NurseServiceContent> list) throws Exception {
		//�Ȳ�ѯ���û���ѡ��ķ�������
		List<NurseServiceContent> nsclist=nurseServiceContentMapperCustom.selectByUserId(userid);
		//ɾ����Щ����
		if(nsclist!=null){
			for (NurseServiceContent nurseServiceContent2 : nsclist) {
				nurseServiceContentMapper.deleteByPrimaryKey(nurseServiceContent2.getId());
			}
		}
		//���������ݿ���뻤���ķ�������
		for (NurseServiceContent nurseServiceContent : list) {
			nurseServiceContent.setUserid(userid);
			int n=nurseServiceContentMapper.insert(nurseServiceContent);
		}
		int n=list.size();
		return n;
	}

	@Override
	public int selectCountByServiceId(Integer serviceTypeId) throws Exception {
		int n=nurseServiceContentMapperCustom.selectCountByServiceId(serviceTypeId);
		return n;
	}
	
	
	//public User selectedUserByService(Integer servicecontentId) throws Exception {
		//nurseServiceContentMapperCustom.selectByServiceId(servicecontentId);
	// null;
	//}

}
