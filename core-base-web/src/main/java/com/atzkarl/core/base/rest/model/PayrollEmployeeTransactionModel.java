package com.atzkarl.core.base.rest.model;

import java.math.BigDecimal;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class PayrollEmployeeTransactionModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private PayrollEmployeeModel payrollEmployee;
	private PayElementModel payElement;
	private BigDecimal rate;
	private BigDecimal quantity;
	private BigDecimal amount;

	public PayrollEmployeeModel getPayrollEmployee() {
		return payrollEmployee;
	}

	public void setPayrollEmployee(PayrollEmployeeModel payrollEmployee) {
		this.payrollEmployee = payrollEmployee;
	}

	public PayElementModel getPayElement() {
		return payElement;
	}

	public void setPayElement(PayElementModel payElement) {
		this.payElement = payElement;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
