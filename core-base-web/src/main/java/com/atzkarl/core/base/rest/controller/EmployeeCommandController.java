package com.atzkarl.core.base.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.command.CreateEmployeeCommand;
import com.atzkarl.core.base.rest.command.DeleteEmployeeCommand;
import com.atzkarl.core.base.rest.command.UpdateEmployeeCommand;
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
	
    @PutMapping(value = "/{id}")
    public UpdateEmployeeCommand update(@PathVariable final Long id, @RequestBody EmployeeModel model) {
        return new UpdateEmployeeCommand(id, model, employeeDTOModelConverter, employeeService);
    }

    @DeleteMapping(value = "/{id}")
    public DeleteEmployeeCommand delete(@PathVariable final Long id) {
        return new DeleteEmployeeCommand(id, employeeService);
    }
}
