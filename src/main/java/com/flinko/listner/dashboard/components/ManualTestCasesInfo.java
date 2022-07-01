package com.flinko.listner.dashboard.components;

import java.util.List;
import java.util.Set;

import com.flinko.listner.data.entity.FlinkoUserEntity;

public class ManualTestCasesInfo {

	private int totalStudentsWritten;
	private int totalStudentNotsWritten;
	private double avgTestCases;
	private double avgStepsPerTestCase;
	private List<FlinkoUserEntity> manualTestCasesWrittenUsers;
	
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

	public double getAvgTestCases() {
		return avgTestCases;
	}

	public void setAvgTestCases(double avgTestCases) {
		this.avgTestCases = avgTestCases;
	}

	public double getAvgStepsPerTestCase() {
		return avgStepsPerTestCase;
	}

	public void setAvgStepsPerTestCase(double avgStepsPerTestCase) {
		this.avgStepsPerTestCase = avgStepsPerTestCase;
	}

	public List<FlinkoUserEntity> getManualTestCasesWrittenUsers() {
		return manualTestCasesWrittenUsers;
	}

	public void setManualTestCasesWrittenUsers(List<FlinkoUserEntity> manualTestCasesWrittenUsers) {
		this.manualTestCasesWrittenUsers = manualTestCasesWrittenUsers;
	}

}
