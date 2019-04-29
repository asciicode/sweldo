package com.atzkarl.core.base.rest.model;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class OrganisationModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    private String organisationNumber;
    private String name;
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
