package com.atzkarl.core.base.rest.model;

import com.atzkarl.framework.base.rest.model.BaseModel;

public class CalculationRuleModel extends BaseModel {

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
