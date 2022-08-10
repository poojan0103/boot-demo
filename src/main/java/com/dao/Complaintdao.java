package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ComplaintBean;

@Repository
public class Complaintdao {
	@Autowired
	JdbcTemplate stmt;

	public boolean updateComplaint(ComplaintBean complaint) {
		stmt.update("update complaint set complaint = ? where complainid = ?",complaint.getComplaint(),complaint.getUserid());
		return false;
	}

	public boolean addComplaint(ComplaintBean complaint) {
		// TODO Auto-generated method stub
		stmt.update("insert into complaint(date,complaint,isresolved) values (?,?,?)",complaint.getDate(),
				complaint.getComplaint(), complaint.isIsresolved());

		return false;
	}

	public List<ComplaintBean> getAllComplaint() {
		// TODO Auto-generated method stub
		List<ComplaintBean> complaint = stmt.query("select * from complaint",
				new BeanPropertyRowMapper<ComplaintBean>(ComplaintBean.class));
		return complaint;
		
	}

	public void deleteComplaint(int userId) {
		// TODO Auto-generated method stub
		stmt.update("delete complaint where userid = ?", userId);
	}

	public int updateComplaintForUser(int userID, int complainId,int houseId) {
		// TODO Auto-generated method stub
		return stmt.update("update complaint set  userid =   ?,houseid = ? where complainid = ?", complainId, userID,houseId);
	}
	}


