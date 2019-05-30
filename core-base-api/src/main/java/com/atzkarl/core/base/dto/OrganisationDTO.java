package com.atzkarl.core.base.dto;

import javax.validation.constraints.NotNull;

import com.atzkarl.core.base.constraint.validator.ValidOrganisationId;
import com.atzkarl.framework.base.dto.BaseDTO;

public class OrganisationDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private String organisationNumber;
    private String name;
    private String legalName;

    @ValidOrganisationId
    @NotNull(message = "{javax.validation.constraints.NotNull.message}") 
    public Long getId() {
        return super.getId();
    }
    
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
