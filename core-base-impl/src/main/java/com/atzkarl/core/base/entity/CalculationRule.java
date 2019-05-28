package com.atzkarl.core.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.atzkarl.framework.base.entity.BaseEntity;

@Entity
@Table(name = "calculation_rule")
public class CalculationRule extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

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

}
