package com.github.igmfilho.challenge.itlean.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneEntity implements Serializable {

	private static final long serialVersionUID = -1441995683388502293L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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