package com.atzkarl.framework.base.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long id;

	private String token;

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
