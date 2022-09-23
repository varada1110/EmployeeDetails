package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")

public class employeeTable {
	private String name;
	private int emId;
    private int emAdd;

    public employeeTable() {
    }

    public employeeTable(String name, int emId, int emAdd) {
    	this.name = name;
    	this.emId = emId;
        this.emAdd = emAdd;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return emId;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmId() {
		return emId;
	}

	public void setEmId(int emId) {
		this.emId = emId;
	}

	public int getEmAdd() {
		return emAdd;
	}

	public void setEmAdd(int emAdd) {
		this.emAdd = emAdd;
	}
}
