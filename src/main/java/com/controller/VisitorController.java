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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bean.VisitorBean;
import com.dao.Visitordao;

@RestController
public class VisitorController {
	@Autowired
	Visitordao visitordao;
	@PostMapping("/visitor")
	public ResponseEntity<?> addVisitor(VisitorBean visitorBean){
		boolean ans = visitordao.addVisitor(visitorBean);
		return ResponseEntity.ok(visitorBean);
	}
	@PutMapping("/visitor")
	public ResponseEntity<?> updateVisitor(VisitorBean visitorBean){
		boolean ans = visitordao.updateVisitor(visitorBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(visitorBean);
		}
	}
	@GetMapping("/visitor")
	public ResponseEntity<List<VisitorBean>> getAllVisitor() {

		List<VisitorBean> visitors = visitordao.getAllVisitor();
		return ResponseEntity.ok(visitors);
	}
	@DeleteMapping("/visitors/{visitorId}") 
	public String deletevisitors(@PathVariable("visitorId") int visitorId) {
		visitordao.deleteVisitor(visitorId);
		return "Deleted Visitor";
	}
	@PostMapping("/mapvisitor")
	public ResponseEntity<?> mapvisitor(@RequestParam("visitorid") int visitorId, @RequestParam("userid") int userId, @RequestParam("houseid") int houseId) {
		System.out.println(userId);
		System.out.println(houseId);
		visitordao.updateVisitorForUser(userId, houseId,visitorId);
		return ResponseEntity.ok("Visitor mapped");
}
	}
