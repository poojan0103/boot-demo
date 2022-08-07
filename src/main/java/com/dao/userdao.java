package com.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.UserBean;


@Repository
public class userdao {

  // db query
  @Autowired
  JdbcTemplate stmt;

  public boolean addUser(UserBean user) {
 
	stmt.update("insert into users (firstname,lastname,email,password,dob) values (?,?,?,?,?)", 
        user.getFirstName(), 
        user.getLastName(),
        user.getEmail(),
        user.getPassword(),
        user.getDob()
        );
	return false;
    
  }

public List<UserBean> getAllUsers() {
	// TODO Auto-generated method stub
	List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	return users;
}

public void deleteUser(int userId) {
	// TODO Auto-generated method stub
	stmt.update("delete from users where userid = ?", userId);
	
}

public boolean updateUser(UserBean user) {
	// TODO Auto-generated method stub
	stmt.update("update users set  firstname =   ? where userid = ? ", user.getFirstName(),user.getUserid());
	

	return false;
}


 

}

