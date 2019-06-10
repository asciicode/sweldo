package com.atzkarl.core.base.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class PayrollModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private String payrollNumber;
	private OrganisationModel organisation;
	private String payrollStatus;
	private Date payDate;
	private Date confirmDate;
	private Boolean overtime;
	private List<PayrollEmployeeModel> payrollEmployees = new ArrayList<>();

	public String getPayrollNumber() {
		return payrollNumber;
	}

	public void setPayrollNumber(String payrollNumber) {
		this.payrollNumber = payrollNumber;
	}

	public OrganisationModel getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationModel organisation) {
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

	public List<PayrollEmployeeModel> getPayrollEmployees() {
		return payrollEmployees;
	}

	public void setPayrollEmployees(List<PayrollEmployeeModel> payrollEmployees) {
		this.payrollEmployees = payrollEmployees;
	}
}
