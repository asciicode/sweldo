package com.atzkarl.core.base.dto;

import java.math.BigDecimal;

import com.atzkarl.framework.base.dto.BaseDTO;

public class PayrollEmployeeTransactionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private PayrollEmployeeDTO payrollEmployee;
	private PayElementDTO payElement;
	private BigDecimal rate;
	private BigDecimal quantity;
	private BigDecimal amount;

	public PayrollEmployeeDTO getPayrollEmployee() {
		return payrollEmployee;
	}

	public void setPayrollEmployee(PayrollEmployeeDTO payrollEmployee) {
		this.payrollEmployee = payrollEmployee;
	}

	public PayElementDTO getPayElement() {
		return payElement;
	}

	public void setPayElement(PayElementDTO payElement) {
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
