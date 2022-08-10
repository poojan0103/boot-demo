package com.bean;

public class DeliveryBean {
	int deliveryid,userid,houseid;
	String couriertype,status;
	boolean isallowed;
	
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public int getDeliveryid() {
		return deliveryid;
	}
	public void setDeliveryid(int deliveryid) {
		this.deliveryid = deliveryid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCouriertype() {
		return couriertype;
	}
	public void setCouriertype(String couriertype) {
		this.couriertype = couriertype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isIsallowed() {
		return isallowed;
	}
	public void setIsallowed(boolean isallowed) {
		this.isallowed = isallowed;
	}
	
	

}
