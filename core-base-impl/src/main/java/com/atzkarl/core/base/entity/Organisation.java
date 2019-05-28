package com.atzkarl.core.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.atzkarl.framework.base.entity.BaseEntity;

// @Audited
@Entity
@Table(name = "organisation")
public class Organisation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "organisation_number")
    private String organisationNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "legal_name")
    private String legalName;

    public String getOrganisationNumber() {
        return organisationNumber;
    }

    public void setOrganisationNumber(String organisationNumber) {
        this.organisationNumber = organisationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
}
