package cn.erlaila.mybatis.po.custom;

import java.util.Date;

import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.User;

public class NurseCustom extends Nursedetail {
	private String down ;
	private User user;
	
	private String nickname;
	private String telephone;
	private Boolean sex;
	private Date birthday;
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public NurseCustom(){
		down="<a class=\"layui-btn layui-btn-mini users_edit\" style="+"margin-top:-5px;"+">"
				   + "<i class=\"layui-icon\">&#xe642;</i>\u7F16\u8F91</a>"
				   + "<a class=\"layui-btn layui-btn-danger layui-btn-mini users_del\" data-id=\"1\" style="+"margin-top:-5px;"+">"
				   + "<i class=\"layui-icon\">\uE640</i> \u5220\u9664</a>";			
	}
	
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
