package com.atzkarl.core.base.rest.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.command.FindAllEmployeeQuery;
import com.atzkarl.core.base.rest.model.EmployeeModel;
import com.atzkarl.core.base.service.EmployeeService;

@RestController
@RequestMapping(API.VERSIONED_PATH + "/{orgNumber}/employee")
public class EmployeeQueryController {
	@Autowired
	private EmployeeDTOModelConverter employeeDTOModelConverter;
    @Autowired
    private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Callable<ResponseEntity<?>> findOne(@PathVariable String id) {
		System.out.println(employeeDTOModelConverter);
		return new Callable<ResponseEntity<?>>() {
			@Override
			public ResponseEntity<?> call() throws Exception {
				return new ResponseEntity<String>("hi walter", HttpStatus.OK);
			}
		};
	}

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Callable<ResponseEntity<List<EmployeeModel>>> findAll() {
        return new FindAllEmployeeQuery(employeeDTOModelConverter, employeeService);
    }
}
