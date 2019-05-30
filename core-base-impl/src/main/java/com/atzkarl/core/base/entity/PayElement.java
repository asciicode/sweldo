package com.atzkarl.core.base.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Audited
@Entity
//@Table(name = "pay_element", uniqueConstraints = { @UniqueConstraint(columnNames = { "organisation_id", "code" }) })
@Table(name = "pay_element")
public class PayElement extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "organisation_id")
	private Organisation organisation;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "multiplier")
	private BigDecimal multiplier;

	@Column(name = "rate")
	private BigDecimal rate;

	@ManyToOne
	@JoinColumn(name = "calculation_rule_id")
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private CalculationRule calculationRule;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public CalculationRule getCalculationRule() {
		return calculationRule;
	}

	public void setCalculationRule(CalculationRule calculationRule) {
		this.calculationRule = calculationRule;
	}

}
