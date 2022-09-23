package com.example.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.example.demo.model.employeeTable;
import com.example.demo.repository.UserRepository;


@SpringBootTest

class DemoClassTest {

	

	@Autowired
    private UserRepository employee;
    @Test
    void loadAll() {
    	
    	//get all employees
    	
    	List<employeeTable> list = employee.findAll();
	    System.out.println("All loaded: " + list);
	    Assert.assertTrue(list.size() == 1);
    }
    
    @Test
    void insert() {
    	
    	
	    //insert employee
	    try {
	    	employeeTable user = employeeTable.create("Adi", 161, "Berlin");
		    long generatedId = employee.save(user);
		    System.out.println("Generated Id: " + generatedId);
	    }
	    catch (Exception e){
	    	 System.out.println("Employee Id should be unique");
	    }
    	
	   
	    
    }
    
    @Test
    void getById() {
	    
	    //get employee by id
	    
	    employeeTable getById = employee.findById(122);;
	    System.out.println(getById);
	    
    
    }
    
    @Test
    void TableNotFound() {
    	
    	try {
    		JdbcTestUtils.deleteFromTables(employee.getJdbcTemplate(), "Table_Name");
//          
    	}
    	catch (Exception e) {
    		System.out.println("Table not found");
    	}
    }
    
//    @Test
//    public void exception() throws NullPointerException {
//        employeeTable employee = new employeeTable(null, 133 , "Workingto");
//        assertThrows(exception.class, () -> account.withdraw(10),
//                "Balance must be greater than amount of withdrawal");
//    }
    
}


//import org.junit.Test;
//
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.jdbc.JdbcTestUtils;
//
//import com.example.demo.model.employeeTable;
//import com.example.demo.repository.UserRepository;
//
//
//
//@SpringBootTest
//class DemoApplicationTests {
//	
//
//	@Autowired
//    private UserRepository employee;
//
//	@Test
//	public void testCrudOperations() {
//		System.out.println("x");
//        JdbcTestUtils.deleteFromTables(employee.getJdbcTemplate(), "users");
//        
//        
//	    List<employeeTable> list = employee.findAll();
//	    System.out.println("All loaded: " + list);
//	    Assert.assertTrue(list.size() == 1);
//		
//		employeeTable user = employeeTable.create("Dana", 152, "Portugal");
//	    long generatedId = employee.save(user);
//	    System.out.println("Generated Id: " + generatedId);
//	    
//	    
//	    employeeTable toBeUpdated = employeeTable.create("Dana", 152 , "Berlin");
//	    toBeUpdated.setEmId(152);
//	    int updated = employee.update(toBeUpdated);
//	    Assert.assertTrue(updated==1);
//
//}
//}
