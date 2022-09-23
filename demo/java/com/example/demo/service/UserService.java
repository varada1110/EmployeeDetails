package com.example.demo.service;

import com.example.demo.model.employeeTable;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<employeeTable> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(employeeTable user) {
        userRepository.save(user);
    }

    public employeeTable getUser(Integer emId) {
        return userRepository.findById(emId).get();
    }

    public void deleteUser(Integer emId) {
        userRepository.deleteById(emId);
    }
}