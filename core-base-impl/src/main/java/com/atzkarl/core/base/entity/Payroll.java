package com.atzkarl.core.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Audited
@Entity
@Table(name = "payroll")
public class Payroll extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "payroll_number")
	private String payrollNumber;
	private Organisation organisation;
	@Column(name = "payroll_status")
	private String payrollStatus;
	@Column(name = "pay_date")
	private Date payDate;
	@Column(name = "confirm_date")
	private Date confirmDate;
	@Column(name = "overtime")
	private Boolean overtime;
	private List<PayrollEmployee> payrollEmployees = new ArrayList<>();
	public String getPayrollNumber() {
		return payrollNumber;
	}

	public void setPayrollNumber(String payrollNumber) {
		this.payrollNumber = payrollNumber;
	}

	@ManyToOne
	@JoinColumn(name = "organisation_id")
	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
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

	@OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL, orphanRemoval = true)
	@BatchSize(size = 50)
	@OrderBy("id")
	public List<PayrollEmployee> getEmployees() {
		return payrollEmployees;
	}

	public void setEmployees(List<PayrollEmployee> employees) {
		this.payrollEmployees = employees;
	}
}
