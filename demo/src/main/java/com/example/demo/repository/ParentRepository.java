package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.employeeTable;

public interface ParentRepository {
	
	  int save(employeeTable user);
	  int update(employeeTable user);
	  employeeTable findById(int emId);
	  int deleteById(Long emId);
	  List<employeeTable> findAll();
	  List<employeeTable> findByName(String name);
	 

}
