package com.atzkarl.core.base.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.atzkarl.framework.base.entity.AuditableEntity;

@Audited
@Entity
@Table(name = "employee")
public class Employee extends AuditableEntity {

	private static final long serialVersionUID = 1L;

	private Organisation organisation;
	@Column(name = "first_names")
	private String firstNames;
	@Column(name = "surname")
	private String surname;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "rate")
    private BigDecimal rate;
    @Column(name = "otmultiplier")
    private BigDecimal otmultiplier;
    @Column(name = "sss")
    private BigDecimal sss;
    @Column(name = "philhealth")
    private BigDecimal philhealth;

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

	@ManyToOne
    @JoinColumn(name = "organisation_id")
	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

}
