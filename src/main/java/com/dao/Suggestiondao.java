package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SuggestionBean;

@Repository
public class Suggestiondao {
	@Autowired
	JdbcTemplate stmt;

	public boolean addSuggestion(SuggestionBean suggestion) {
		// TODO Auto-generated method stub
		stmt.update("insert into suggestion(membername,date,suggestion,reason,acknowledgement) values (?,?,?,?,?)",
				suggestion.getMembername(), suggestion.getDate(), suggestion.getReason(),
				suggestion.getAcknowledgement(), suggestion.getSuggestion());
		return false;
	}

	public boolean updateSuggestion(SuggestionBean suggestion) {
		// TODO Auto-generated method stub
		stmt.update("update suggestion set membername = ? where suggestionid = ?", suggestion.getMembername(),
				suggestion.getSuggestionid());
		return false;
	}

	public List<SuggestionBean> getAllSuggestion() {
		// TODO Auto-generated method stub
		List<SuggestionBean> suggestion = stmt.query("select * from suggestion",
				new BeanPropertyRowMapper<SuggestionBean>(SuggestionBean.class));
		return suggestion;
	}

	public void deleteSuggestion(int suggestionId) {
		// TODO Auto-generated method stub
		stmt.update("delete from suggestion where suggestionid = ?", suggestionId);

	}

}
