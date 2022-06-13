package com.tyss.dashboard.admin.data.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(value = "Student")
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = -7112002801660307144L;

	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private String phone;
	@NonNull
	private String batchCode;
	@NonNull
	private String branch;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
