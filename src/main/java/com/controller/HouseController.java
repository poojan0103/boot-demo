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

import com.bean.HouseBean;

import com.dao.Housedao;

@RestController
public class HouseController {
	@Autowired
	Housedao housedao;
	//@PostMapping("/login")
	//public ResponseEntity<?> login(){
		//return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	//}
	@PostMapping("/house")
	public ResponseEntity<?> addHouse(HouseBean houseBean){
		boolean ans = housedao.addHouse(houseBean);
		return ResponseEntity.ok(houseBean);
		
	}
	@PutMapping("/house")
	public ResponseEntity<?> updateHouse(HouseBean houseBean){
		boolean ans = housedao.updateHouse(houseBean);
		if(ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}else {
				return ResponseEntity.ok(houseBean);
			}
		}
	@GetMapping("/house")
	public ResponseEntity<List<HouseBean>> getAllHouse(){
		List<HouseBean> houses = housedao.getAllHouse();
		return ResponseEntity.ok(houses);
		
	}
	@DeleteMapping("/house/{houseId}")
	public String deleteHouse(@PathVariable("houseId")int houseId)
	{
		housedao.deleteHouse(houseId);
		return "Deleted House";
	}
	
}	


