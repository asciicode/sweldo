package com.atzkarl.core.base.rest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class PayrollEmployeeModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private PayrollModel payroll;
	private EmployeeModel employee;
	private Date payPeriodEndDate;
	private Date payPeriodStartDate;

	private List<PayrollEmployeeTransactionModel> transactions = new ArrayList<>();

	public PayrollModel getPayroll() {
		return payroll;
	}

	public void setPayroll(PayrollModel payroll) {
		this.payroll = payroll;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
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

	public List<PayrollEmployeeTransactionModel> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<PayrollEmployeeTransactionModel> transactions) {
		this.transactions = transactions;
	}
}
