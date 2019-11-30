package com.example.demo.model.employe;

import java.io.Serializable;

public class EmployeModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372681549384745061L;

	private long empId;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String dateOfBrith;
	
	private String department;
	
	private boolean isActive;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(String dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
