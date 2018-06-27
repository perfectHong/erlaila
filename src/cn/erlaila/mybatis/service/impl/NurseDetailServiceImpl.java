package cn.erlaila.mybatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import cn.erlaila.mybatis.mapper.AdminsMapper;
import cn.erlaila.mybatis.mapper.NurseServiceAreaMapper;
import cn.erlaila.mybatis.mapper.NurseServiceContentMapper;
import cn.erlaila.mybatis.mapper.NursedetailMapper;
import cn.erlaila.mybatis.mapper.RealNameAuthenticationMapper;
import cn.erlaila.mybatis.mapper.ServiceAreaMapper;
import cn.erlaila.mybatis.mapper.ServiceTypeMapper;
import cn.erlaila.mybatis.mapper.UserMapper;
import cn.erlaila.mybatis.mapper.custom.NurseServiceAreaMapperCustom;
import cn.erlaila.mybatis.mapper.custom.NurseServiceContentMapperCustom;
import cn.erlaila.mybatis.mapper.custom.NursedetailMapperCustom;
import cn.erlaila.mybatis.mapper.custom.RealNameAuthenticationMapperCustom;
import cn.erlaila.mybatis.mapper.custom.UserMapperCustom;
import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.po.ServiceArea;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.custom.NurseCustom;
import cn.erlaila.mybatis.po.custom.UserCustom;
import cn.erlaila.mybatis.po.vo.NurseDetailVo;
import cn.erlaila.mybatis.po.vo.Page;
import cn.erlaila.mybatis.service.NurseDetailService;
import cn.erlaila.mybatis.service.UserService;

public class NurseDetailServiceImpl implements NurseDetailService{

	@Autowired
	private NursedetailMapperCustom nursedetailMapperCustom;
	
	@Autowired
	private NurseServiceAreaMapperCustom nurseServiceAreaMapperCustom ;

	@Autowired
	private NurseServiceContentMapperCustom contentMapperCustom;
	
	@Autowired
	private ServiceAreaMapper serviceAreaMapper;
	
	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	
	@Autowired
	private RealNameAuthenticationMapper realNameAuthenticationMapper;
	
	@Autowired
	private RealNameAuthenticationMapperCustom realNameAuthenticationMapperCustom;	
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private NursedetailMapper nursedetailMapper;
	
	@Override
	public String seleteRealNameByUserid(Integer userId) throws Exception {
		String realName=nursedetailMapperCustom.selectRealNameByUserId(userId);
		return realName;
	}

	@Override
	public NurseDetailVo seleteContentAndAreaByUserid(Integer userid)
			throws Exception {
		NurseDetailVo nurseDetailVo = new NurseDetailVo();
		List<String> areaNameList=new ArrayList<String>();
		List<String> contentNameList=new ArrayList<String>();
		//��ѯ���û���ѡ��ķ�������
		List<NurseServiceArea> nsalist=nurseServiceAreaMapperCustom.selectByUserid(userid);		
		for (NurseServiceArea nurseServiceArea : nsalist){
			System.out.println("=getServiceareaId=======L:"+nurseServiceArea.getServiceareaId());
			ServiceArea area=serviceAreaMapper.selectByPrimaryKey(nurseServiceArea.getServiceareaId());
			areaNameList.add(area.getServiceareaname());
		}
		//��ѯ���û����ķ�������
		List<NurseServiceContent> nsclist=contentMapperCustom.selectByUserId(userid);
		for (NurseServiceContent nurseServiceContent : nsclist) {
			ServiceType serviceType=serviceTypeMapper.selectByPrimaryKey(nurseServiceContent.getServicecontentId());
			contentNameList.add(serviceType.getServicename());
		}		
		nurseDetailVo.setAreaListString(areaNameList);
		nurseDetailVo.setContentListString(contentNameList);
		return nurseDetailVo;
	}

	@Override
	public int insertNurseValidate(NurseDetailVo nurseDetailVo)
			throws Exception {
		int n=0;
		//���»�����Ϣ
		User user = nurseDetailVo.getUser();
		Integer userid=user.getUserid();
		userMapper.updateByPrimaryKey(user);		
		
		//����������ϸ��Ϣ   ��Ҫ�ж����޸û�������ϸ��Ϣ
		Nursedetail nursedetail = nurseDetailVo.getNursedetail();	
		nursedetail.setUserid(userid);
		
		Nursedetail nursedetail2 = nursedetailMapperCustom.selectNurseDetailByUserId(userid);
		if(nursedetail2 == null){
			nursedetailMapper.insertSelective(nursedetail);			
		}else{
			int nursedetailid=nursedetail2.getNursedetailid();
			nursedetail.setNursedetailid(nursedetailid);
			nursedetailMapper.updateByPrimaryKeySelective(nursedetail);
		}
		
		//����ʵ����֤��Ϣ    ��Ҫ�ж����޸û���ʵ����֤��Ϣ
		RealNameAuthentication realNameAuthentication = nurseDetailVo.getRealNameAuthentication();
		realNameAuthentication.setUserid(userid);
		RealNameAuthentication realNameAuthentication2 = realNameAuthenticationMapperCustom.selectByUserId(userid);
		if(realNameAuthentication2 == null){ //Ϊ�� ����
			n=realNameAuthenticationMapper.insertSelective(realNameAuthentication);
		}else{//�ǿ� �޸�
			int id=realNameAuthentication2.getId();
			realNameAuthentication.setId(id);
			n=realNameAuthenticationMapper.updateByPrimaryKeySelective(realNameAuthentication);
		}		
		return n;
	}
	
	@Override
	public Page selectWaitValidateNurse() throws Exception {
		List<NurseCustom> list=nursedetailMapperCustom.selectWaitValidateNurse();
		Page page=new Page();
		page.setData(list);
		page.setCode("0");
		page.setCount(list.size()+"");
		page.setMsg("");
		return page;
	}

	@Override
	public NurseDetailVo selectNurseDetailById(Integer userid) throws Exception {
		NurseDetailVo nurseDetailVo = nursedetailMapperCustom.selectNurseDetailById(userid);	
		//���� �û�id��ѯ�������ķ�������	
		List<NurseServiceArea> areaList=nurseServiceAreaMapperCustom.selectByUserid(userid);
		List<String> areaNameList=new ArrayList<String>();		
		for (NurseServiceArea nurseServiceArea : areaList) {
			ServiceArea area=serviceAreaMapper.selectByPrimaryKey(nurseServiceArea.getServiceareaId());
			areaNameList.add(area.getServiceareaname());
		}
		//��ѯ���û����ķ�������
		List<NurseServiceContent>  contentList=contentMapperCustom.selectByUserId(userid);
		List<String> contentNameList=new ArrayList<String>();
		for (NurseServiceContent nurseServiceContent : contentList) {
			ServiceType serviceType=serviceTypeMapper.selectByPrimaryKey(nurseServiceContent.getServicecontentId());
			contentNameList.add(serviceType.getServicename());
		}	
		nurseDetailVo.setAreaListString(areaNameList);
		nurseDetailVo.setContentListString(contentNameList);
		return nurseDetailVo;
	}

	@Override
	public Nursedetail selectNurseDetailByKey(Integer nurseId) throws Exception {
		Nursedetail nursedetail=nursedetailMapper.selectByPrimaryKey(nurseId);
		return nursedetail;
	}

	@Override
	public Nursedetail selectNurseDetailByUserId(Integer userId)
			throws Exception {
		Nursedetail nNursedetail=nursedetailMapperCustom.selectNurseDetailByUserId(userId);
		return nNursedetail;
	}

	
	@Override
	public List<UserCustom> selectByLimit(NurseDetailVo nurseDetailVo) throws Exception {
		List<UserCustom> list1=new ArrayList<UserCustom>();//���ؼ���
		//�ҵ������÷�����㻤��Ա
		int numStart=nurseDetailVo.getCount()*nurseDetailVo.getPageSize();
		nurseDetailVo.setNumStart(numStart);
		System.out.println("getServiceTypeId===============>"+nurseDetailVo.getServiceTypeId());
		
		//��ҳ��ѯ���㻤��Ա
		List<NurseServiceContent> nscList = contentMapperCustom.selectByServiceIdLimit(nurseDetailVo);
		List<Integer> userIdList = new ArrayList<Integer>();//�����÷�����㻤��Ա����
		for (NurseServiceContent nurseServiceContent : nscList) {
			userIdList.add(nurseServiceContent.getUserid());
		}	
			
		if(userIdList.size()!=0){
			NurseDetailVo nursedetailVo=new NurseDetailVo();
			nursedetailVo.setUserids(userIdList);
			//����Щ��������Ϣ����ʾ����
			List<UserCustom> list=userMapperCustom.selectByLimit(nursedetailVo);
			String sexString="Ů";			
			for (UserCustom userCustom : list) {
				if(userCustom.getUsertype()){
					boolean sexfg=userCustom.getSex();//��ʱ��һ����˵������ȷ������Ӱ��ˢ��
					if(sexfg){
						sexString="��";
					}
					userCustom.setSexString(sexString);
					list1.add(userCustom);	
				}
			}			
		}
		return list1;
	}

	@Override
	public NurseDetailVo selectNurseBaseInfoById(Integer userid)
			throws Exception {
		NurseDetailVo nurseDetailVo=nursedetailMapperCustom.selectNurseBaseInfoById(userid);
		return nurseDetailVo;
	}

	@Override
	public String uodateNurseInfo(Integer userid, NurseDetailVo nurseDetailVo)
			throws Exception {
		if(userid!=null){
			//�޸�user��
			User user = nurseDetailVo.getUser();
			user.setUserid(userid);
			int p=userMapper.updateByPrimaryKeySelective(user);
			System.out.println("==dddddddddd==========>"+p);
			//�޸�nurseDetail��
			Nursedetail nursedetail = nurseDetailVo.getNursedetail();
			nursedetail.setUserid(userid);
			int n=nursedetailMapperCustom.updateByUserIdSelective(nursedetail);
			System.out.println("==dddddddddd===sssssssss=======>"+n);
		}
		return "1";
	}

	
}
