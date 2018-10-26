package com.github.igmfilho.challenge.itlean.dao.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1211063129734425400L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String email;
	
	private String password;
	
	private Calendar created;
	
	private Calendar modified;
	
	private Calendar lastSignin;
	
	private String token;

	@OneToMany
	private List<PhoneEntity> phones;

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

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}
	
	public String toString(){
	    StringBuilder builder = new StringBuilder();
	    builder.append(this.getId()).append(", ")
	      .append(this.getName()).append(", ")
	      .append(this.getPassword()).append(", ")
	      .append(this.getToken()).append(", ")
	      .append(this.getCreated()).append(", ")
	      .append(this.getModified()).append(", ")
	      .append(this.getLastSignin());

	    return builder.toString();
	}
}