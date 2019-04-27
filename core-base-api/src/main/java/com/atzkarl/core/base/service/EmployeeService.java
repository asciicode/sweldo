package com.atzkarl.core.base.service;

import java.util.List;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.framework.base.event.DeletedEvent;
import com.atzkarl.framework.base.event.UpdatedEvent;

public interface EmployeeService {
	EmployeeDTO create(EmployeeDTO employeeDTO);

    UpdatedEvent<EmployeeDTO> update(Long id, EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();

    DeletedEvent<EmployeeDTO> delete(Long id);
}
