package cn.erlaila.mybatis.po.vo;

import java.util.List;

import cn.erlaila.mybatis.po.NurseOrders;
import cn.erlaila.mybatis.po.Orders;

public class NurseOrdersVo {
	
	private Integer nurseId;
	
	private Integer orderId; 
	
	private Integer status;//护工接单状态，根据这去修改护工的订单状态

	private Integer comment;//拒接订单备注
	
	private  List<Integer> nurseOrdersStatusList;

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getComment() {
		return comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public List<Integer> getNurseOrdersStatusList() {
		return nurseOrdersStatusList;
	}

	public void setNurseOrdersStatusList(List<Integer> nurseOrdersStatusList) {
		this.nurseOrdersStatusList = nurseOrdersStatusList;
	}
	
}
