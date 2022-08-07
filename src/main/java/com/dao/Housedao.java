package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.HouseBean;
@Repository
public class Housedao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addHouse(HouseBean house) {
		// TODO Auto-generated method stub
		stmt.update("insert into house (title,contactnumber) values (?,?)",
				house.getTitle(),house.getContactnumber());
		return false;
	}

	public boolean updateHouse(HouseBean house) {
		// TODO Auto-generated method stub
		stmt.update("update house set title = ? where houseid = ?",house.getTitle(),house.getHouseid());
		return false;
	}

	public List<HouseBean> getAllHouse() {
		// TODO Auto-generated method stub
		List<HouseBean> houses = stmt.query("select * from house", new BeanPropertyRowMapper<HouseBean>(HouseBean.class)); 
		return houses;
	}

	public void deleteHouse(int houseId) {
		// TODO Auto-generated method stub
		stmt.update("delete from house where houseid = ?", houseId);
	}

}
