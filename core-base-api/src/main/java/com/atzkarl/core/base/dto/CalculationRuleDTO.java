package com.atzkarl.core.base.dto;

import com.atzkarl.framework.base.dto.BaseDTO;

public class CalculationRuleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String code;

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
