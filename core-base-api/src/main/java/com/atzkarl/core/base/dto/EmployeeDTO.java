package com.atzkarl.core.base.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.atzkarl.framework.base.dto.BaseDTO;

public class EmployeeDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
	private Long organisationId;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @Size(min = 1, message = "{javax.validation.constraints.NotNull.message}")
	private String firstNames;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    @Size(min = 1, message = "{javax.validation.constraints.NotNull.message}")
	private String surname;
    private String jobDescription;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    private BigDecimal rate;
    @NotNull(message = "{javax.validation.constraints.NotNull.message}")
    private BigDecimal otmultiplier;
    private BigDecimal sss;
    private BigDecimal philhealth;

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
