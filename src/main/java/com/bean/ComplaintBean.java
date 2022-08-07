package com.bean;

public class ComplaintBean {
	int userid,houseid;
	String date,complaint;
	boolean isresolved;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public boolean isIsresolved() {
		return isresolved;
	}
	public void setIsresolved(boolean isresolved) {
		this.isresolved = isresolved;
	}
	
	

}
