package com.atzkarl.core.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Entity
@Audited
@Table(name = "payroll_employee")
public class PayrollEmployee extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	private Payroll payroll;
	private Employee employee;
	@Column(name = "pay_period_end_date")
	private Date payPeriodEndDate;
	@Column(name = "pay_period_start_date")
	private Date payPeriodStartDate;

	private List<PayrollEmployeeTransaction> transactions = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "payroll_id")
	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

	@ManyToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
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

	@OneToMany(mappedBy = "payrollEmployee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@BatchSize(size = 50)
	public List<PayrollEmployeeTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<PayrollEmployeeTransaction> transactions) {
		this.transactions = transactions;
	}
}
