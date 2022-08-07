package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.MemberBean;
import com.bean.UserBean;
@Repository
public class Memberdao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addMember(MemberBean member) {
		// TODO Auto-generated method stub
		stmt.update("insert into member (membername,dob,age,contactnumber) values (?,?,?,?)",
				member.getMembername(),
				member.getContactnumber(),
				member.getAge(),
				member.getDob());
		return false;
	}

	public boolean updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		stmt.update("update member set  membername =   ? where memberid = ? ", member.getMembername(),member.getMemberid());
		return false;
	}

	public List<MemberBean> getAllMember() {
		// TODO Auto-generated method stub
		List<MemberBean> members = stmt.query("select * from member", new BeanPropertyRowMapper<MemberBean>(MemberBean.class));
		return null;
	}

	public void deleteMember(int memberId) {
		// TODO Auto-generated method stub
		stmt.update("delete from member where memberid = ?", memberId);
		
		
	}

}
