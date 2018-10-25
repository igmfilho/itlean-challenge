package com.github.igmfilho.challenge.itlean.api.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -2090113393122073232L;

	private Long id;

	private String name;
	
	private String email;
	
	private String password;
	
	private Calendar created;
	
	private Calendar modified;
	
	private Calendar lastSignin;
	
	private String token;

	private List<PhoneDTO> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Calendar getModified() {
		return modified;
	}

	public void setModified(Calendar modified) {
		this.modified = modified;
	}

	public Calendar getLastSignin() {
		return lastSignin;
	}

	public void setLastSignin(Calendar lastSignin) {
		this.lastSignin = lastSignin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
}