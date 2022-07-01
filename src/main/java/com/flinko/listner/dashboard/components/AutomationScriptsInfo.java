package com.flinko.listner.dashboard.components;

import java.util.List;

import com.flinko.listner.data.entity.FlinkoUserEntity;

public class AutomationScriptsInfo {

	private int totalStudentsWritten;
	private int totalStudentNotsWritten;
	private double avgStepsperScript;
	private double avgStcripts;
	private List<FlinkoUserEntity> automationScriptsWrittenUsers;

	public int getTotalStudentsWritten() {
		return totalStudentsWritten;
	}

	public void setTotalStudentsWritten(int totalStudentsWritten) {
		this.totalStudentsWritten = totalStudentsWritten;
	}

	public int getTotalStudentNotsWritten() {
		return totalStudentNotsWritten;
	}

	public void setTotalStudentNotWritten(int totalStudentNotsWritten) {
		this.totalStudentNotsWritten = totalStudentNotsWritten;
	}

	public double getAvgStepsperScript() {
		return avgStepsperScript;
	}

	public void setAvgStepsperScript(double avgStepsperScript) {
		this.avgStepsperScript = avgStepsperScript;
	}

	public double getAvgStcripts() {
		return avgStcripts;
	}

	public void setAvgStcripts(double avgStcripts) {
		this.avgStcripts = avgStcripts;
	}

	public List<FlinkoUserEntity> getAutomationScriptsWrittenUsers() {
		return automationScriptsWrittenUsers;
	}

	public void setAutomationScriptsWrittenUsers(List<FlinkoUserEntity> automationScriptsWrittenUsers) {
		this.automationScriptsWrittenUsers = automationScriptsWrittenUsers;
	}

}
