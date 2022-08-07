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

import com.bean.SocietyBean;

import com.dao.Societydao;

@RestController
public class SocietyController {
	@Autowired
	Societydao societydao;

	@PostMapping("/society")
	public ResponseEntity<?> addSociety(SocietyBean societyBean) {
		boolean ans = societydao.addSociety(societyBean);
		return ResponseEntity.ok(societyBean);
	}

	@PutMapping("/society")
	public ResponseEntity<?> updateSociety(SocietyBean societyBean) {
		boolean ans = societydao.addSociety(societyBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(societyBean);
		}

	}

	@GetMapping("/society")
	public ResponseEntity<List<SocietyBean>> getAllSociety() {

		List<SocietyBean> society = societydao.getAllSociety();
		return ResponseEntity.ok(society);
	}

	@DeleteMapping("/society/{societyId}")
	public String deleteSociety(@PathVariable("societyId") int societyId) {
		societydao.deleteSociety(societyId);
		return "Deleted User";
	}
}
