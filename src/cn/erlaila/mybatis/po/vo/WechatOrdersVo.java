package cn.erlaila.mybatis.po.vo;

/**
 * 微信用户订单包装类
 */
import java.util.List;

import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;
import cn.erlaila.mybatis.po.WechatOrders;

public class WechatOrdersVo {
	//微信用户id
	private Integer wechatId;
	//系统订单编号
	private Integer orderid;		
	//支付状态
	private List<Integer>  paystatusList ;
	//护工接单状态
	private Integer nurseStatus;
	//服务状态状态
	private List<Integer> servicestatusList;	
	//护工服务状态
	private Integer servicestatus;
	//微信用户支付状态   paystatus
	private Integer paystatus;
	//系统订单
	private Orders orders;
	//微信用户订单
	private WechatOrders wechatOrders;
	//护工（或者陪聊师）基本信息
	private User user;
	//护工（或者陪聊师）详细信息
	private Nursedetail nursedetail;
	//联系人
	private Linkman linkman;
	//服务类型
	private ServiceType serviceType;
	
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getWechatId() {
		return wechatId;
	}
	public void setWechatId(Integer wechatId) {
		this.wechatId = wechatId;
	}
	public List<Integer> getPaystatusList() {
		return paystatusList;
	}
	public void setPaystatusList(List<Integer> paystatusList) {
		this.paystatusList = paystatusList;
	}
	public Integer getNurseStatus() {
		return nurseStatus;
	}
	public void setNurseStatus(Integer nurseStatus) {
		this.nurseStatus = nurseStatus;
	}
	public List<Integer> getServicestatusList() {
		return servicestatusList;
	}
	public void setServicestatusList(List<Integer> servicestatusList) {
		this.servicestatusList = servicestatusList;
	}
	public Integer getServicestatus() {
		return servicestatus;
	}
	public void setServicestatus(Integer servicestatus) {
		this.servicestatus = servicestatus;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public WechatOrders getWechatOrders() {
		return wechatOrders;
	}
	public void setWechatOrders(WechatOrders wechatOrders) {
		this.wechatOrders = wechatOrders;
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
	public Linkman getLinkman() {
		return linkman;
	}
	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
