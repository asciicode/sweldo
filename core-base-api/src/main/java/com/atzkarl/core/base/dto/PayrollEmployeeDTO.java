package com.atzkarl.core.base.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atzkarl.framework.base.dto.BaseDTO;

public class PayrollEmployeeDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private PayrollDTO payroll;
	private EmployeeDTO employee;
	private Date payPeriodEndDate;
	private Date payPeriodStartDate;

	private List<PayrollEmployeeTransactionDTO> transactions = new ArrayList<>();

	public PayrollDTO getPayroll() {
		return payroll;
	}

	public void setPayroll(PayrollDTO payroll) {
		this.payroll = payroll;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public Date getPayPeriodEndDate() {
		return payPeriodEndDate;
	}

	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}

	public Date getPayPeriodStartDate() {
		return payPeriodStartDate;
	}

	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}

	public List<PayrollEmployeeTransactionDTO> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<PayrollEmployeeTransactionDTO> transactions) {
		this.transactions = transactions;
	}
}
