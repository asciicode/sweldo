package com.atzkarl.core.base.dto;

import com.atzkarl.framework.base.dto.BaseDTO;

public class EmployeeDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String internalId;
	private Long organisationId;
	private String firstNames;
	private String surname;
	public String getInternalId() {
		return internalId;
	}
	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}
	public Long getOrganisationId() {
		return organisationId;
	}
	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}
	public String getFirstNames() {
		return firstNames;
	}
	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
