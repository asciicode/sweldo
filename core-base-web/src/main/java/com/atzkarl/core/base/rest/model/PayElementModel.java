package com.atzkarl.core.base.rest.model;

import java.math.BigDecimal;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class PayElementModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private String code;
	private String description;
	private OrganisationModel organisation;
	private Integer priority;
	private BigDecimal multiplier;
	private BigDecimal rate;

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

	public OrganisationModel getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationModel organisation) {
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

}
