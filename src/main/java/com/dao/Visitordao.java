package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bean.VisitorBean;

@Repository
public class Visitordao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addVisitor(VisitorBean visitor) {
		// TODO Auto-generated method stub
		stmt.update("insert into visitor(visitorname,arrivingtime,isallowed) values (?,?,?)", visitor.getVisitorname(),
				visitor.getArrivingtime(), visitor.isIsallowed());

		return false;
	}

	public boolean updateVisitor(VisitorBean visitor) {
		// TODO Auto-generated method stub
		stmt.update("update visitor set visitorname = ? where visitorid = ?", visitor.getVisitorid(),
				visitor.getVisitorname());
		return false;
	}

	public List<VisitorBean> getAllVisitor() {
		// TODO Auto-generated method stub
		List<VisitorBean> visitor = stmt.query("select * from visitor",
				new BeanPropertyRowMapper<VisitorBean>(VisitorBean.class));
		return visitor;
	}

	public void deleteVisitor(int visitorId) {
		// TODO Auto-generated method stub
		stmt.update("delete visitor where visitorid = ?",visitorId);


	}

}
