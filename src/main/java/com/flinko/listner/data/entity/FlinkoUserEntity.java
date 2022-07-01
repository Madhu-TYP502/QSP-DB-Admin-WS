package com.flinko.listner.data.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.flinko.listner.data.model.Batches;

@Document(value = "FlinkoUsers")
public class FlinkoUserEntity {

	private String name;

	private String email;

	private String phone;

	private boolean isRegistered;

	private List<Batches> batches;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public boolean getIsRegistered() {
		return this.isRegistered;
	}

	public void setBatches(List<Batches> batches) {
		this.batches = batches;
	}

	public List<Batches> getBatches() {
		return this.batches;
	}

}
