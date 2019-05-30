package com.atzkarl.core.base.rest.command;

import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.model.EmployeeModel;
import com.atzkarl.core.base.service.EmployeeService;

public class CreateEmployeeCommand implements Callable<ResponseEntity<EmployeeModel>> {

    private EmployeeModel employeeModel;
    private EmployeeDTOModelConverter employeeDTOModelConverter;
    private EmployeeService employeeService;
	public CreateEmployeeCommand(EmployeeModel employeeModel, EmployeeDTOModelConverter employeeDTOModelConverter,
			EmployeeService employeeService) {
		this.employeeModel = employeeModel;
		this.employeeDTOModelConverter = employeeDTOModelConverter;
		this.employeeService = employeeService;
	}
	@Override
	public ResponseEntity<EmployeeModel> call() throws Exception {
		EmployeeDTO empDto = employeeDTOModelConverter.fromModel(employeeModel);
		EmployeeDTO empDTO = employeeService.create(empDto);
		return new ResponseEntity<EmployeeModel>(employeeDTOModelConverter.toModel(empDTO), HttpStatus.CREATED);
	}

}
