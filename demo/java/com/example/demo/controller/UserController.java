package com.example.demo.controller;

import com.example.demo.model.employeeTable;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<employeeTable> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{emId}")
    public ResponseEntity<employeeTable> get(@PathVariable Integer emId) {
        try {
        	employeeTable user = userService.getUser(emId);
            return new ResponseEntity<employeeTable>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<employeeTable>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody employeeTable user) {
        userService.saveUser(user);
    }
    @PutMapping("/{emId}")
    public ResponseEntity<?> update(@RequestBody employeeTable user, @PathVariable Integer emId) {
        try {
        	employeeTable existUser = userService.getUser(emId);
            user.setEmId(emId);            
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{emId}")
    public void delete(@PathVariable Integer emId) {

        userService.deleteUser(emId);
    }
}
