package com.flinko.listner.dashboard.components;


public class DashboardComponents {

	private StudentsInfo studentsInfo;
	private ManualTestCasesInfo manualTestCases;
	private AutomationScriptsInfo automationScripts;
	private UserNotWrittenAny userNotWrittenAny;

	public DashboardComponents() {
	}

	public StudentsInfo getStudentsInfo() {
		return studentsInfo;
	}

	public void setStudentsInfo(StudentsInfo studentsInfo) {
		this.studentsInfo = studentsInfo;
	}

	public ManualTestCasesInfo getManualTestCases() {
		return manualTestCases;
	}

	public void setManualTestCases(ManualTestCasesInfo manualTestCases) {
		this.manualTestCases = manualTestCases;
	}

	public AutomationScriptsInfo getAutomationScripts() {
		return automationScripts;
	}

	public void setAutomationScripts(AutomationScriptsInfo automationScripts) {
		this.automationScripts = automationScripts;
	}

	public UserNotWrittenAny getUserNotWrittenAny() {
		return userNotWrittenAny;
	}

	public void setUserNotWrittenAny(UserNotWrittenAny userNotWrittenAny) {
		this.userNotWrittenAny = userNotWrittenAny;
	}

}
