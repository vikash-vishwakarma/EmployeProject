package com.example.demo.domain.employe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8165975687785791568L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String gender;
	
	@Column
	private String dataOfBirth;
	
	@Column
	private String department;
	
	@Column
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

	public String getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(String dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
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
