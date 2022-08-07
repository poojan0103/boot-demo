package com.bean;

public class SuggestionBean {
	int suggestionid;
	String membername,date,suggestion,reason,acknowledgement;
	public int getSuggestionid() {
		return suggestionid;
	}
	public void setSuggestionid(int suggestionid) {
		this.suggestionid = suggestionid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAcknowledgement() {
		return acknowledgement;
	}
	public void setAcknowledgement(String acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	

}
