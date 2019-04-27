package com.atzkarl.core.base.rest.command;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.model.EmployeeModel;
import com.atzkarl.core.base.service.EmployeeService;

public class FindAllEmployeeQuery implements Callable<ResponseEntity<List<EmployeeModel>>> {

    private EmployeeDTOModelConverter employeeDTOModelConverter;
    private EmployeeService employeeService;

    public FindAllEmployeeQuery(EmployeeDTOModelConverter employeeDTOModelConverter, EmployeeService employeeService) {
        this.employeeDTOModelConverter = employeeDTOModelConverter;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<List<EmployeeModel>> call() throws Exception {
        List<EmployeeDTO> dtos = employeeService.findAll();
        return new ResponseEntity<>(employeeDTOModelConverter.toModels(dtos), HttpStatus.OK);
    }

}
