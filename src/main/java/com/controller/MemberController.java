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

import com.bean.MemberBean;
import com.bean.UserBean;
import com.dao.Memberdao;

@RestController
public class MemberController {
	@Autowired
	Memberdao memberdao;

	@PostMapping("/member")
	public ResponseEntity<?> addmember(MemberBean memberBean) {
		boolean ans = memberdao.addMember(memberBean);
		return ResponseEntity.ok(memberBean);
		
	}
	@PutMapping("/member")
	public ResponseEntity<?> updateMember(MemberBean memberBean){
		boolean ans = memberdao.updateMember(memberBean);
		if(ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}else {
				return ResponseEntity.ok(memberBean);
			}
		}
	@GetMapping("/member")
	public ResponseEntity<List<MemberBean>> getAllMember() {

		List<MemberBean> members = memberdao.getAllMember();
		return ResponseEntity.ok(members);
	}

	@DeleteMapping("/member/{memberId}") 
	public String deleteMember(@PathVariable("memberId") int memberId) {
		memberdao.deleteMember(memberId);
		return "Deleted Member";
	}

}
