package com.atzkarl.core.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.dto.entity.converter.EmployeeDTOEntityConverter;
import com.atzkarl.core.base.entity.Employee;
import com.atzkarl.core.base.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDTOEntityConverter employeeDTOEntityConverter;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO create(EmployeeDTO employeeDTO) {
		Employee emp = employeeDTOEntityConverter.toEntity(employeeDTO);
		return employeeDTOEntityConverter.fromEntity(employeeRepository.save(emp));
	}

}
