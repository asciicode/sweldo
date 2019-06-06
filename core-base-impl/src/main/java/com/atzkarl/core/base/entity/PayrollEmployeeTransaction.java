package com.atzkarl.core.base.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Entity
@Audited
@Table(name = "payroll_employee_transaction")
public class PayrollEmployeeTransaction extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	private PayrollEmployee payrollEmployee;
	private PayElement payElement;
	@Column(name = "rate")
	private BigDecimal rate;
	@Column(name = "quantity")
	private BigDecimal quantity;
	@Column(name = "amount")
	private BigDecimal amount;
	@ManyToOne
	@JoinColumn(name = "payroll_employee_id")
	public PayrollEmployee getPayrollEmployee() {
		return payrollEmployee;
	}

	public void setPayrollEmployee(PayrollEmployee payrollEmployee) {
		this.payrollEmployee = payrollEmployee;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pay_element_id", columnDefinition = "int4")
	public PayElement getPayElement() {
		return payElement;
	}

	public void setPayElement(PayElement payElement) {
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
