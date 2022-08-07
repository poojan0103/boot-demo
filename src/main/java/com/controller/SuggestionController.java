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
import com.bean.SuggestionBean;
import com.dao.Suggestiondao;

@RestController
public class SuggestionController {
	@Autowired
	Suggestiondao suggestiondao;
	@PostMapping("/suggestion")
	public ResponseEntity<?> addSuggestion(SuggestionBean suggestionBean){
		boolean ans = suggestiondao.addSuggestion(suggestionBean);
		return ResponseEntity.ok(suggestionBean);
	}
	@PutMapping("/suggestion")
	public ResponseEntity<?> updateSuggestion(SuggestionBean suggestionBean){
		boolean ans = suggestiondao.updateSuggestion(suggestionBean);

		if (ans == false) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(suggestionBean);
		}
	}
	@GetMapping("/suggestion")
	
	public ResponseEntity<List<SuggestionBean>> getAllSuggestion() {

		List<SuggestionBean> suggestions = suggestiondao.getAllSuggestion();
		return ResponseEntity.ok(suggestions);
	}
	@DeleteMapping("/suggestions/{suggestionId}") 
	public String deleteSuggestions(@PathVariable("suggestionId") int suggestionId) {
		suggestiondao.deleteSuggestion(suggestionId);
		return "Deleted Suggestion";
	}
	

}

