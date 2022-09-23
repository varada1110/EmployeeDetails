package com.example.demo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.employeeTable;

@Repository

public class UserRepository implements ParentRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int save(employeeTable user) {
	    return jdbcTemplate.update("INSERT INTO users (name,emId,emAdd) VALUES(?,?,?)",
	        new Object[] { user.getName(), user.getEmId(), user.getEmAdd() });
	 }
	@Override
	public int update(employeeTable user) {
	   return jdbcTemplate.update("UPDATE users SET name=? ,emAdd=? WHERE emId=?",
	        new Object[] { user.getName(),  user.getEmAdd(),user.getEmId() });
	}
	@Override
	public employeeTable findById(int emId) {
	   try {
	      employeeTable user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE emId=?", BeanPropertyRowMapper.newInstance(employeeTable.class), emId);
	      System.out.println(user);
	      return user;
	    }
	   catch (IncorrectResultSizeDataAccessException e) {
	      return null;
	    }
	}
	@Override
	public int deleteById(Long emId) {
	    return jdbcTemplate.update("DELETE FROM users WHERE emId=?", emId);
	}
	@Override
	public List<employeeTable> findAll() {
	    return jdbcTemplate.query("SELECT * from users", BeanPropertyRowMapper.newInstance(employeeTable.class));
	}
	

	@Override
	 public List<employeeTable> findByName(String name) {
	    String q = "SELECT * from users WHERE name=?";
	    return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(employeeTable.class));
	 }
	 
	 public JdbcTemplate getJdbcTemplate() {
	        return jdbcTemplate;
	    }
	
}

