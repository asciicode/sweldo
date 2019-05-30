package com.atzkarl.core.base.rest.model;

import java.math.BigDecimal;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class EmployeeModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private OrganisationModel organisation;
	private String firstNames;
	private String surname;
    private String jobDescription;
    private BigDecimal rate;
    private BigDecimal otmultiplier;
    private BigDecimal sss;
    private BigDecimal philhealth;

	public OrganisationModel getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationModel organisationModel) {
		this.organisation = organisationModel;
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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getOtmultiplier() {
        return otmultiplier;
    }

    public void setOtmultiplier(BigDecimal otmultiplier) {
        this.otmultiplier = otmultiplier;
    }

    public BigDecimal getSss() {
        return sss;
    }

    public void setSss(BigDecimal sss) {
        this.sss = sss;
    }

    public BigDecimal getPhilhealth() {
        return philhealth;
    }

    public void setPhilhealth(BigDecimal philhealth) {
        this.philhealth = philhealth;
    }
}
