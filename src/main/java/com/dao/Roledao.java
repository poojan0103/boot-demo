package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository

public class Roledao {

	@Autowired
	JdbcTemplate stmt;

	public boolean addRole(RoleBean role) {
		stmt.update("insert into roles (rolename) values (?)", role.getRoleName());
	   return false;
	}

	public List<RoleBean> getAllRole() {
		List<RoleBean> roles = stmt.query("select * from roles", new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roles;
	}

	public void deleteRole(int roleId) {
		stmt.update("delete from roles where roleid = ?", roleId);

	}

	public boolean updateRole(RoleBean role) {
		stmt.update("update  roles set  rolename =   ? where roleid = ? ", role.getRoleName(),role.getRoleId());

		return false;
	}
}
