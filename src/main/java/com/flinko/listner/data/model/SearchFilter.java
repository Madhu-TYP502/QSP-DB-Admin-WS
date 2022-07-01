package com.flinko.listner.data.model;

import java.util.List;

public class SearchFilter {

	private List<String> trainer;
	private List<String> branch;
	private List<String> batchCode;
	private List<String> project;
	private List<String> platform;
	private List<String> dateRange;

	public SearchFilter() {

	}

	public SearchFilter(List<String> trainer, List<String> branch, List<String> batchCode, List<String> project, List<String> platform,
			List<String> dateRange) {
		super();
		this.trainer = trainer;
		this.branch = branch;
		this.batchCode = batchCode;
		this.project = project;
		this.platform = platform;
		this.dateRange = dateRange;
	}

	public List<String> getTrainer() {
		return trainer;
	}

	public void setTrainer(List<String> trainer) {
		this.trainer = trainer;
	}

	public List<String> getBranch() {
		return branch;
	}

	public void setBranch(List<String> branch) {
		this.branch = branch;
	}

	public List<String> getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(List<String> batchCode) {
		this.batchCode = batchCode;
	}

	public List<String> getProject() {
		return project;
	}

	public void setProject(List<String> project) {
		this.project = project;
	}

	public List<String> getPlatform() {
		return platform;
	}

	public void setPlatform(List<String> platform) {
		this.platform = platform;
	}

	public List<String> getdateRange() {
		return dateRange;
	}

	public void setdateRange(List<String> dateRange) {
		this.dateRange = dateRange;
	}

	@Override
	public String toString() {
		return "SearchFilter [trainer=" + trainer + ", branch=" + branch + ", batchCode=" + batchCode + ", project="
				+ project + ", platform=" + platform + ", dateRange=" + dateRange + "]";
	}
}









