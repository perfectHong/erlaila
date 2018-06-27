package cn.erlaila.mybatis.po.vo;

import java.util.List;

import cn.erlaila.mybatis.po.NurseServiceArea;
import cn.erlaila.mybatis.po.NurseServiceContent;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.RealNameAuthentication;
import cn.erlaila.mybatis.po.User;

public class NurseDetailVo {
	
	private  List<Integer> userids;
	//微信用户（护工）基本信息
	private User user;	
	//护工基本信息
	private Nursedetail nursedetail;
	//实名认证
	private RealNameAuthentication realNameAuthentication;
	//护工服务区域
	private List<NurseServiceArea> areaList; 
	//护工服务内容
	private List<NurseServiceContent>  contentList;
	//护工服务区域名称
	private List<String> areaListString; 
	//护工服务内容名称
	private List<String> contentListString;
	//服务类型
	private Integer serviceTypeId;
	//查找第几页
	private Integer count;
	//页面大小
	private Integer pageSize;
	//从第几条开始查
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
