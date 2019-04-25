package com.atzkarl.framework.base.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String token;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
