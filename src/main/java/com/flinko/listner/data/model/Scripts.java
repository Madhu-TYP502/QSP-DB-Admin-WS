package com.flinko.listner.data.model;

public class Scripts {

	private String scriptId;

	private Integer manualTestCaseStepCount = 0;

	private Integer automationScriptsStepCount = 0;

	private Integer passCount = 0;

	private Integer failCount = 0;

	private String projectId;

	private String createBy;

	private String createDate;

	private String updatedDate;

	private String scriptType;

	private String platformType;

	private String action;

	public String getScriptId() {
		return scriptId;
	}

	public void setScriptId(String scriptId) {
		this.scriptId = scriptId;
	}

	public Integer getManualTestCaseStepCount() {
		return manualTestCaseStepCount;
	}

	public void setManualTestCaseStepCount(Integer manualTestCaseStepCount) {
		this.manualTestCaseStepCount = manualTestCaseStepCount;
	}

	public Integer getAutomationScriptsStepCount() {
		return automationScriptsStepCount;
	}

	public void setAutomationScriptsStepCount(Integer automationScriptsStepCount) {
		this.automationScriptsStepCount = automationScriptsStepCount;
	}

	public Integer getPassCount() {
		return passCount;
	}

	public void setPassCount(Integer passCount) {
		this.passCount = passCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getScriptType() {
		return scriptType;
	}

	public void setScriptType(String scriptType) {
		this.scriptType = scriptType;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	

}
