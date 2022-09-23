package com.example.demo.model;



public class employeeTable {
	private String name;
	private int emId;
    private String emAdd;

    public employeeTable() {
    }

    public employeeTable(String name, int emId, String emAdd) {
    	this.name = name;
    	this.emId = emId;
        this.emAdd = emAdd;
    }
    
    public employeeTable(String name,String emAdd) {
    	this.name = name;
    	
        this.emAdd = emAdd;
    }

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

	public String getEmAdd() {
		return emAdd;
	}

	public void setEmAdd(String emAdd) {
		this.emAdd = emAdd;
	}
	@Override
	 public String toString() {
	    return "employeeTable [name=" + name + " ,emId=" + emId + ", emAdd= " + emAdd +" ]";
	 }
	
	public static employeeTable create(String name, int emId, String emAdd) {
        employeeTable employee = new employeeTable();
        employee.setName(name);
        employee.setEmId(emId);
        employee.setEmAdd(emAdd);
        return employee;
    }
}
