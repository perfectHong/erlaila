/**
 * 
 */
package cn.erlaila.mybatis.po.vo;

import cn.erlaila.mybatis.po.Linkman;
import cn.erlaila.mybatis.po.Nursedetail;
import cn.erlaila.mybatis.po.Orders;
import cn.erlaila.mybatis.po.ServiceType;
import cn.erlaila.mybatis.po.User;

    /**  
 * @ClassName: OrdersVo  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author 孟凡红  
 * @date 2018年5月8日  下午5:06:14
 *    
 */
public class OrdersVo {
      private Orders orders;
      private Linkman linkman;
      private User user;
      private ServiceType serviceType ;
      private Nursedetail nursedetail;
      public Nursedetail getNursedetail() {
		return nursedetail;
	}
	public void setNursedetail(Nursedetail nursedetail) {
		this.nursedetail = nursedetail;
	}
	//护工真实心姓名
      private String realName;
      
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the orders
	 */
	public Orders getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	/**
	 * @return the linkman
	 */
	public Linkman getLinkman() {
		return linkman;
	}
	/**
	 * @param linkman the linkman to set
	 */
	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
}
