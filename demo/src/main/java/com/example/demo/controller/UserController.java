package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.employeeTable;
import com.example.demo.repository.ParentRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class UserController {
	@Autowired
	ParentRepository parentRepository;
	@GetMapping("/users" )
	public ResponseEntity<List<employeeTable>> getAllEmployees(@RequestParam(required = false) String name) {
	    try {
	        List<employeeTable> users = new ArrayList<employeeTable>();
	        if (name == null)
	            parentRepository.findAll().forEach(users::add);
	        else
	        	parentRepository.findByName(name).forEach(users::add);
	        
	        
	        if (users.isEmpty()) {
	          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        else {
	          return new ResponseEntity<>(users, HttpStatus.OK);
	        }
	       
	      }
	    catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	 }
	
	@GetMapping("/users/{emId}")
	  public ResponseEntity<employeeTable> getByEmId(@PathVariable("emId") int emId) {
		employeeTable users = parentRepository.findById(emId);
	    if (users != null) {
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@PostMapping("/users")
	public ResponseEntity<String> createEmployee(@RequestBody employeeTable user) {
	   try {
	      parentRepository.save(new employeeTable(user.getName(), user.getEmId(), user.getEmAdd()));
	      return new ResponseEntity<>("Employee was created successfully.", HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 }
	@DeleteMapping("/users/{emId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("emId") long emId) {
	    try {
	      int result = parentRepository.deleteById(emId);
	      if (result == 0) {
	        return new ResponseEntity<>("Cannot find employee with id=" + emId, HttpStatus.OK);
	      }
	      return new ResponseEntity<>("Employee was deleted successfully.", HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>("Cannot delete employee.", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	 @PutMapping("/users/{emId}")
	 public ResponseEntity<employeeTable> updateByEmId(@PathVariable("emId") int emId,@RequestBody  employeeTable user) {
	    employeeTable users = parentRepository.findById(emId);
	    if (users != null) {
	      users.setEmId(emId);
	      users.setName(user.getName());
	      users.setEmAdd(user.getEmAdd());
	      parentRepository.update(user);
	      return new ResponseEntity<>(users, HttpStatus.OK);
	    } else {
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
