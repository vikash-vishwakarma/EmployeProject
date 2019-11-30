package com.example.demo.service.employe;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.StatusCode;
import com.example.demo.dao.employe.EmployeDAO;
import com.example.demo.domain.employe.EmployeDomain;
import com.example.demo.mapper.employe.EmployeMapper;
import com.example.demo.model.employe.EmployeModel;
import com.example.demo.response.Response;
import com.example.demo.utils.CommonUtils;

@Service
public class EmployeServiceImpl implements EmployeService {

	private static final Logger logger=LoggerFactory.getLogger(EmployeServiceImpl.class);
	
	@Autowired
	EmployeDAO employeDAO;
	
	@Autowired
	EmployeMapper employeMapper;

	@Override
	public Response create(EmployeModel employeModel) throws Exception {
		Response response=CommonUtils.getResponseObject("Created Employe Data ");
		try {
			EmployeDomain employeDoamin= new EmployeDomain();
			BeanUtils.copyProperties(employeModel, employeDoamin);
			response =employeDAO.create(employeDoamin);
		}catch(Exception e) {
			logger.info("Exception in Creating Data of Employee" + e.getMessage());
			response.setStatusText(StatusCode.ERROR.name());
		}
		return response;
	}

	@Override
	public List<EmployeModel> listEmploye() throws Exception {
		try {
			List<EmployeDomain>list=employeDAO.listEmploye();
			return employeMapper.entityList(list);
		}catch(Exception e) {
			logger.info("Exception in Getting List Data" +e.getMessage());
		}
		return null;
	}

	@Override
	public EmployeModel getEmploye(long empId) throws Exception {
		try {
			EmployeModel employeModel=new EmployeModel();
			EmployeDomain employeDomain=employeDAO.getEmploye(empId);
			BeanUtils.copyProperties(employeDomain,employeModel);
			return employeModel;
		}catch(Exception e) {
			logger.info("Exception in Getting EmployeServiceImpl",e);
		}
		return null;
	}

	@Override
	public Response deleteEmploye(long empId) throws Exception {
		try {
			employeDAO.deleteEmploye(empId);
			return CommonUtils.getResponseObject("Deleted Employe Data" +empId);
		}catch(Exception e) {
			logger.info("Exception in Deleting Bank Data" +e.getMessage());
			return null;
		}
	}
}
