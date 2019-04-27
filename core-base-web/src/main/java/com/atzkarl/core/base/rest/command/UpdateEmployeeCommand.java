package com.atzkarl.core.base.rest.command;

import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.dto.model.converter.EmployeeDTOModelConverter;
import com.atzkarl.core.base.rest.model.EmployeeModel;
import com.atzkarl.core.base.service.EmployeeService;
import com.atzkarl.framework.base.event.UpdatedEvent;
import com.atzkarl.framework.base.spring.web.ResourceNotFoundResponse;

public class UpdateEmployeeCommand implements Callable<ResponseEntity<?>> {

    private Long id;
    private EmployeeModel employeeModel;
    private EmployeeDTOModelConverter employeeDTOModelConverter;
    private EmployeeService employeeService;

    public UpdateEmployeeCommand(Long id, EmployeeModel employeeModel, EmployeeDTOModelConverter employeeDTOModelConverter,
            EmployeeService employeeService) {
        this.id = id;
        this.employeeModel = employeeModel;
        this.employeeDTOModelConverter = employeeDTOModelConverter;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<?> call() throws Exception {
        UpdatedEvent<EmployeeDTO> event = employeeService.update(id, employeeDTOModelConverter.fromModel(employeeModel));
        return event.isEntityFound() ? new ResponseEntity<EmployeeModel>(employeeDTOModelConverter.toModel(event.getDTO()), HttpStatus.OK)
                : new ResponseEntity<ResourceNotFoundResponse>(new ResourceNotFoundResponse(), HttpStatus.NOT_FOUND);
    }

}
