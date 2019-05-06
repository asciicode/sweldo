package com.atzkarl.core.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atzkarl.core.base.entity.Employee;

@Repository
public interface EmployeeRepository extends EmployeeRepositoryCustom<Employee>, JpaRepository<Employee, Long> {

}
