package com.atzkarl.core.base.dto.entity.converter;

import org.springframework.stereotype.Component;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.entity.Employee;
import com.atzkarl.framework.base.dto.entity.converter.BaseDTOEntityConverter;

@Component
public class EmployeeDTOEntityConverter extends BaseDTOEntityConverter<EmployeeDTO, Employee> {
}
