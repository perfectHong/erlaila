package cn.erlaila.mybatis.po.vo;

/**
 * ΢���û�������װ��
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
	//΢���û�id
	private Integer wechatId;
	//ϵͳ�������
	private Integer orderid;		
	//֧��״̬
	private List<Integer>  paystatusList ;
	//�����ӵ�״̬
	private Integer nurseStatus;
	//����״̬״̬
	private List<Integer> servicestatusList;	
	//��������״̬
	private Integer servicestatus;
	//΢���û�֧��״̬   paystatus
	private Integer paystatus;
	//ϵͳ����
	private Orders orders;
	//΢���û�����
	private WechatOrders wechatOrders;
	//��������������ʦ��������Ϣ
	private User user;
	//��������������ʦ����ϸ��Ϣ
	private Nursedetail nursedetail;
	//��ϵ��
	private Linkman linkman;
	//��������
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
