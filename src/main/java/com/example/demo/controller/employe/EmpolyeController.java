package com.example.demo.controller.employe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.StatusCode;
import com.example.demo.model.employe.EmployeModel;
import com.example.demo.response.ErrorObject;
import com.example.demo.response.Response;
import com.example.demo.service.employe.EmployeService;
import com.example.demo.utils.CommonUtils;

@RestController
@RequestMapping(value = "/123")
public class EmpolyeController {
	
	private static final Logger logger=LoggerFactory.getLogger(EmpolyeController.class);

	@Autowired
	EmployeService employeService;
	
	@RequestMapping(value = "create",method = RequestMethod.POST,produces = "Application/json")
	public Response create(@RequestBody EmployeModel employeModel,HttpServletResponse response,HttpServletRequest request)
	throws Exception {
		logger.info("Add Data :Request recevied " + request.getRequestURL().toString()
		+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		logger.info("creating Data: send Response : " +CommonUtils.getJson(employeModel));
		return employeService.create(employeModel);
	}
	
//	List of Data Code Start Here.
	
	@RequestMapping(value = "/listEmploye",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String listEmploye(HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		logger.info("List Data : Request recevied " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "" :"?" +request.getQueryString().toString()));
		List<EmployeModel>listEmploye=employeService.listEmploye();
		Response response2=CommonUtils.getResponseObject("List of Employe Data");
		if(listEmploye== null) {
			ErrorObject err=CommonUtils.getErrorResponse("Data Not Found", "Data Not Found ");
			response2.setError(err);
			response2.setStatusText(StatusCode.ERROR.name());
		}else {
			response2.setData(listEmploye);
		}
		logger.info("Get Data :Send request" );
		return CommonUtils.getJson(response2);
	}
	
//	getting Single Data Code Start Here.
	
	@RequestMapping(value="/employe/{id}",method = RequestMethod.GET,produces = "Application/json")
	public @ResponseBody String getEmploye(@PathVariable("id") long empId,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Send Data : Recevied request URL " + request.getRequestURL().toString()
				+((request.getQueryString()==null) ? "": "?" +request.getQueryString().toString()));
		
		EmployeModel employeModel=employeService.getEmploye(empId);
		Response res=CommonUtils.getResponseObject("Get Data");
		if(employeModel == null) {
			ErrorObject errorObject = CommonUtils.getErrorResponse("Employe Data Not Found", "Employe Data Not Found ");
			res.setError(errorObject);
			res.setStatusText(StatusCode.ERROR.name());
		}else {
			res.setData(employeModel);
		}logger.info("Get Employe Data :Send Request");
		return CommonUtils.getJson(res);
	}
	
//	Delete Code Start Here.
	
	@RequestMapping (value = "/delete/{id}",method=RequestMethod.DELETE,produces="Application/json")
	public @ResponseBody Response deleteEmploye(@PathVariable ("id")long empId,HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		logger.info("Delete Employe Data :Request recevied URL " +request.getRequestURL().toString()
				+((request.getQueryString()==null)? "":"?" +request.getQueryString().toString()));
		return employeService.deleteEmploye(empId);
	}
}
