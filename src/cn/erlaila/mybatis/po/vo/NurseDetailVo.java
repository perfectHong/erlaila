package cn.erlaila.mybatis.po.vo;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.po.User;

public class NurseDetailVo {
	
	private  List<Integer> userids;
	//΢���û���������������Ϣ
	private User user;	
	//����������Ϣ
	private Nursedetail nursedetail;
	//ʵ����֤
	private RealNameAuthentication realNameAuthentication;
	//������������
	private List<NurseServiceArea> areaList; 
	//������������
	private List<NurseServiceContent>  contentList;
	//����������������
	private List<String> areaListString; 
	//����������������
	private List<String> contentListString;
	//��������
	private Integer serviceTypeId;
	//���ҵڼ�ҳ
	private Integer count;
	//ҳ���С
	private Integer pageSize;
	//�ӵڼ�����ʼ��
	private Integer numStart;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getNumStart() {
		return numStart;
	}

	public void setNumStart(Integer numStart) {
		this.numStart = numStart;
	}

	public Integer getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<String> getAreaListString() {
		return areaListString;
	}

	public void setAreaListString(List<String> areaListString) {
		this.areaListString = areaListString;
	}

	public List<String> getContentListString() {
		return contentListString;
	}

	public void setContentListString(List<String> contentListString) {
		this.contentListString = contentListString;
	}

	public List<NurseServiceArea> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<NurseServiceArea> areaList) {
		this.areaList = areaList;
	}

	public List<NurseServiceContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<NurseServiceContent> contentList) {
		this.contentList = contentList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Nursedetail getNursedetail() {
		return nursedetail;
	}

	public void setNursedetail(Nursedetail nursedetail) {
		this.nursedetail = nursedetail;
	}

	public RealNameAuthentication getRealNameAuthentication() {
		return realNameAuthentication;
	}

	public void setRealNameAuthentication(
			RealNameAuthentication realNameAuthentication) {
		this.realNameAuthentication = realNameAuthentication;
	}

	public List<Integer> getUserids() {
		return userids;
	}

	public void setUserids(List<Integer> userids) {
		this.userids = userids;
	}
	
}
