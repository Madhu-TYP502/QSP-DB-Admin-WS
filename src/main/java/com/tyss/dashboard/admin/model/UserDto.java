package com.tyss.dashboard.admin.model;

import java.util.List;

public class UserDto {

	private String name;

	private String email;

	private String phone;

	private String role;
	
	private String status;

	private List<String> branchesAssigned;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getBranchesAssigned() {
		return branchesAssigned;
	}

	public void setBranchesAssigned(List<String> branchesAssigned) {
		this.branchesAssigned = branchesAssigned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
