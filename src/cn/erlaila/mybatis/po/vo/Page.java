package cn.erlaila.mybatis.po.vo;

import java.util.List;

public class Page {
	private String code;
	private String msg;
	private String count;
	private List<Object> data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
}
