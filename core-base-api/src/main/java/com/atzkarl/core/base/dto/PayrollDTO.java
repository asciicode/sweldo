package com.atzkarl.core.base.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atzkarl.framework.base.dto.BaseDTO;

public class PayrollDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String payrollNumber;
	private OrganisationDTO organisation;
	private String payrollStatus;
	private Date payDate;
	private Date confirmDate;
	private Boolean overtime;
	private List<PayrollEmployeeDTO> payrollEmployees = new ArrayList<>();

	public String getPayrollNumber() {
		return payrollNumber;
	}

	public void setPayrollNumber(String payrollNumber) {
		this.payrollNumber = payrollNumber;
	}

	public OrganisationDTO getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationDTO organisation) {
		this.organisation = organisation;
	}

	public String getPayrollStatus() {
		return payrollStatus;
	}

	public void setPayrollStatus(String payrollStatus) {
		this.payrollStatus = payrollStatus;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public Boolean getOvertime() {
		return overtime;
	}

	public void setOvertime(Boolean overtime) {
		this.overtime = overtime;
	}

	public List<PayrollEmployeeDTO> getPayrollEmployees() {
		return payrollEmployees;
	}

	public void setPayrollEmployees(List<PayrollEmployeeDTO> payrollEmployees) {
		this.payrollEmployees = payrollEmployees;
	}
}
