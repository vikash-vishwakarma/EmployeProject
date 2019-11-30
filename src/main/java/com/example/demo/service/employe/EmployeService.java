package com.example.demo.service.employe;

import java.util.List;

import com.example.demo.model.employe.EmployeModel;
import com.example.demo.response.Response;

public interface EmployeService {

	public Response create(EmployeModel employeModel)throws Exception;
	
	public List<EmployeModel>listEmploye()throws Exception;
	
	public EmployeModel getEmploye(long empId)throws Exception;
	
	public Response deleteEmploye(long empId)throws Exception;
}
