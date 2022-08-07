package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.DeliveryBean;
import com.dao.Deliverydao;
@RestController
public class DeliveryController {
	@Autowired
	Deliverydao deliverydao;
	
	@PostMapping("/delivery")
	public ResponseEntity<?> addDelivery(DeliveryBean deliveryBean){
		boolean ans = deliverydao.addDelivery(deliveryBean);
		return ResponseEntity.ok(deliveryBean);
	}
	@PutMapping("/delivery")
	public ResponseEntity<?> updateDelivery(DeliveryBean deliveryBean){
		boolean ans = deliverydao.updateDelivery(deliveryBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(deliveryBean);
		}
	}
	@GetMapping("/delivery")
	
	public ResponseEntity<List<DeliveryBean>> getAllDelivery() {

		List<DeliveryBean> deliverys = deliverydao.getAllDelivery();
		return ResponseEntity.ok(deliverys);
	}
	@DeleteMapping("/deliverys/{deliveryId}") 
	public String deleteDeliverys(@PathVariable("deliveryId") int deliveryId) {
		deliverydao.deleteDelivery(deliveryId);
		return "Deleted Delivery";
	}
	

}
