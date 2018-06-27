package cn.erlaila.mybatis.po.custom;

import java.util.List;

import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;

public class UserCustom extends User{
	
	/*护工详细信息*/
	private Nursedetail nursedetail;
	
	/*护工服务范围*/
	private List<ServiceType> contentList;
    
	/*新增性别字段*/
	private String sexString;
	
	public Nursedetail getNursedetail(){
		return nursedetail;
	}
	public void setNursedetail(Nursedetail nursedetail) {
		this.nursedetail = nursedetail;
	}
	public List<ServiceType> getContentList() {
		return contentList;
	}
	public void setContentList(List<ServiceType> contentList) {
		this.contentList = contentList;
	}
	public String getSexString() {
		return sexString;
	}
	public void setSexString(String sexString) {
		this.sexString = sexString;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	private String down ;
	private String check;
	public UserCustom(){
		down="<a class=\"layui-btn layui-btn-mini users_edit\" style="+"margin-top:-5px;"+">"
				   + "<i class=\"layui-icon\">&#xe642;</i>\u7F16\u8F91</a>"
				   + "<a class=\"layui-btn layui-btn-danger layui-btn-mini users_del\" data-id=\"1\" style="+"margin-top:-5px;"+">"
				   + "<i class=\"layui-icon\">\uE640</i> \u5220\u9664</a>";
		check="<input type=\"checkbox\" name=\"checked\" lay-skin=\"primary\" lay-filter=\"choose\">"
				+ "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\">"
				+ "<i class=\"layui-icon\">\uE605</i>"
				+ "</div>";				
	}


}
