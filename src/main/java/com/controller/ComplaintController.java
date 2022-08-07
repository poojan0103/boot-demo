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

import com.bean.ComplaintBean;
import com.bean.UserBean;
import com.dao.Complaintdao;

@RestController
public class ComplaintController {
	@Autowired
	Complaintdao complaintdao;
	
	@PostMapping("/complaint")
	public ResponseEntity<?> addComplaint(ComplaintBean complaintBean){
		boolean ans = complaintdao.addComplaint(complaintBean);
		return ResponseEntity.ok(complaintBean);
	}
	@PutMapping("/complaint")
	public ResponseEntity<?> updateComplaint(ComplaintBean complaintBean){
		boolean ans = complaintdao.updateComplaint(complaintBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(complaintBean);
		}
	}
	@GetMapping("/complaint")
	public ResponseEntity<List<ComplaintBean>> getAllComplaint() {

		List<ComplaintBean> complaints = complaintdao.getAllComplaint();
		return ResponseEntity.ok(complaints);
	}
	@DeleteMapping("/complaints/{userId}") 
	public String deleteComplaints(@PathVariable("userId") int userId) {
		complaintdao.deleteComplaint(userId);
		return "Deleted Complaint";
	}
}
