package com.github.igmfilho.challenge.itlean.api.model;

import java.io.Serializable;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = -7193979373653488488L;

	private Long id;

	private Integer ddd;

	private Integer number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}