package com.example.demo.mapper.employe;

import org.springframework.stereotype.Component;

import com.example.demo.domain.employe.EmployeDomain;
import com.example.demo.mapper.AbstractMapper;
import com.example.demo.model.employe.EmployeModel;

@Component
public class EmployeMapper extends AbstractMapper <EmployeModel,EmployeDomain>{

	@Override
	public Class<EmployeModel> entityType() {
		return EmployeModel.class;
	}

	@Override
	public Class<EmployeDomain> modelType() {
		return EmployeDomain.class;
	}

}
