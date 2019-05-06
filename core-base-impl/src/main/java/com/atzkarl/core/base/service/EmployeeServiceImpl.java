package com.atzkarl.core.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.atzkarl.core.base.dto.EmployeeDTO;
import com.atzkarl.core.base.dto.entity.converter.EmployeeDTOEntityConverter;
import com.atzkarl.core.base.entity.Employee;
import com.atzkarl.core.base.repository.EmployeeRepository;
import com.atzkarl.framework.base.event.DeletedEvent;
import com.atzkarl.framework.base.event.UpdatedEvent;
import com.atzkarl.framework.base.validation.ValidationService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeDTOEntityConverter converter;
	@Autowired
    private EmployeeRepository repository;
    @Autowired
    private ValidationService validationService;

	@Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        validationService.validate(employeeDTO);
        Employee emp = converter.toEntity(employeeDTO);
        return converter.fromEntity(repository.save(emp));
	}

    @Override
    public UpdatedEvent<EmployeeDTO> update(Long id, EmployeeDTO employeeDTO) {
		validationService.validate(employeeDTO);
        Employee entity = getEntity(id);
        if (entity != null) {
            entity = converter.toEntity(employeeDTO, entity);
            repository.flush();
        }
        EmployeeDTO updatedDTO = entity == null ? null : converter.fromEntity(entity);
        return entity == null ? new UpdatedEvent<EmployeeDTO>(employeeDTO.getId(), false, false)
                : new UpdatedEvent<EmployeeDTO>(entity.getId(), updatedDTO);
    }

    private Employee getEntity(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeDTO> findAll() {
		List<Employee> list = repository.findAll(Sort.by("surname"));
        return converter.fromEntities(list);
    }

    @Override
    public DeletedEvent<EmployeeDTO> delete(Long id) {
        Employee entity = getEntity(id);
        if (entity != null) {
            repository.delete(entity);
            repository.flush();
        }
        EmployeeDTO deletedDTO = entity == null ? null : converter.fromEntity(entity);
        return entity == null ? new DeletedEvent<EmployeeDTO>(id, false, false)
                : new DeletedEvent<EmployeeDTO>(entity.getId(), deletedDTO);
    }
}
