package cn.erlaila.mybatis.po.custom;

import cn.erlaila.mybatis.po.Admins;

public class AdminsCustom extends Admins{
	private String down ;
	private String check;
	public AdminsCustom(){
		down="<a class=\"layui-btn layui-btn-mini users_edit\" style="+"margin-top:-5px;"+">"
		   + "<i class=\"layui-icon\">&#xe642;</i>\u7F16\u8F91</a>"
		   + "<a class=\"layui-btn layui-btn-danger layui-btn-mini users_del\" data-id=\"1\" style="+"margin-top:-5px;"+">"
		   + "<i class=\"layui-icon\">\uE640</i> \u5220\u9664</a>";
		check="<input type=\"checkbox\" name=\"checked\" lay-skin=\"primary\" lay-filter=\"choose\"><div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\"><i class=\"layui-icon\">\uE605</i></div>";				
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
	

}
