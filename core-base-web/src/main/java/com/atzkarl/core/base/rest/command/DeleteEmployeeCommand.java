package com.atzkarl.core.base.rest.command;

import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.service.EmployeeService;
import com.atzkarl.framework.base.event.DeletedEvent;
import com.atzkarl.framework.base.spring.web.ResourceNotFoundResponse;

public class DeleteEmployeeCommand implements Callable<ResponseEntity<?>> {

    private Long id;
    private EmployeeService employeeService;

    public DeleteEmployeeCommand(Long id, EmployeeService employeeService) {
        this.id = id;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<?> call() throws Exception {
        DeletedEvent<EmployeeDTO> deletedEvent = employeeService.delete(id);
        return deletedEvent.isEntityFound() ? new ResponseEntity<Void>(HttpStatus.OK)
                : new ResponseEntity<ResourceNotFoundResponse>(new ResourceNotFoundResponse(), HttpStatus.NOT_FOUND);
    }

}
