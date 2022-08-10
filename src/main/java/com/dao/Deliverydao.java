package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bean.DeliveryBean;

@Repository
public class Deliverydao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addDelivery(DeliveryBean delivery) {
		// TODO Auto-generated method stub
		stmt.update("insert into delivery(couriertype,isallowed,status) values (?,?,?)", delivery.getCouriertype(),

				delivery.isIsallowed(), delivery.getStatus());
		return false;
	}

	public boolean updateDelivery(DeliveryBean delivery) {
		// TODO Auto-generated method stub
		stmt.update("update delivery set couriertype = ? where deliveryid = ?", delivery.getCouriertype(),
				delivery.getDeliveryid());

		return false;

	}

	public List<DeliveryBean> getAllDelivery() {
		// TODO Auto-generated method stub
		List<DeliveryBean> delivery = stmt.query("select * from delivery",
				new BeanPropertyRowMapper<DeliveryBean>(DeliveryBean.class));
		return delivery;
	}

	public void deleteDelivery(int deliveryId) {
		// TODO Auto-generated method stub
		stmt.update("delete from delivery where deliveryid = ?", deliveryId);

	}

	public int updateDeliveryForUser(int userId, int houseId, int deliveryId) {
		// TODO Auto-generated method stub
		return stmt.update("update delivery set  userid =   ?,houseid = ? where deliveryid = ?", deliveryId, userId,houseId);
	}

}
