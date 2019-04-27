package com.atzkarl.core.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Audited
@Entity
@Table(name = "employee")
public class Employee extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "internal_id")
	private String internalId;
	@Column(name = "organisation_id")
	private Long organisationId;
	@Column(name = "first_names")
	private String firstNames;
	@Column(name = "surname")
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
