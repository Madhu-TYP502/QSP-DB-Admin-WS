package com.flinko.listner.data.model;

import java.util.List;

public class Batches {

	private String liceneceName;

	private String batchCode;

	private String branch;

	private String trainer;

	private String licenseId;

	private List<Projects> projects;

	public void setLiceneceName(String liceneceName) {
		this.liceneceName = liceneceName;
	}

	public String getLiceneceName() {
		return this.liceneceName;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getBatchCode() {
		return this.batchCode;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainer() {
		return this.trainer;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getLicenseId() {
		return this.licenseId;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public List<Projects> getProjects() {
		return this.projects;
	}
}
