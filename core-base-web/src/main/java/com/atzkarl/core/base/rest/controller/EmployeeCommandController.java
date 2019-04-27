package com.atzkarl.core.base.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.command.CreateEmployeeCommand;
import com.atzkarl.core.base.rest.model.EmployeeModel;
import com.atzkarl.core.base.service.EmployeeService;

@RestController
@RequestMapping(API.VERSIONED_PATH + "/{orgNumber}/employee")
public class EmployeeCommandController {
	@Autowired
	private EmployeeDTOModelConverter employeeDTOModelConverter;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	public CreateEmployeeCommand create(@RequestBody EmployeeModel model) {
		return new CreateEmployeeCommand(model, employeeDTOModelConverter, employeeService);
	}
}
