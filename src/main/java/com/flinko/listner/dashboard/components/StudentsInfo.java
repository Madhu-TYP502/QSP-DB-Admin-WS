package com.flinko.listner.dashboard.components;

import java.util.List;

import com.flinko.listner.data.entity.FlinkoUserEntity;

public class StudentsInfo {

	private int totalStudents;
	private int flinkoRegistered;
	private int flinkoNotRegistered;
	private List<FlinkoUserEntity> studentSet;
	
	public StudentsInfo()
	{
		
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public int getFlinkoRegistered() {
		return flinkoRegistered;
	}

	public void setFlinkoRegistered(int flinkoRegistered) {
		this.flinkoRegistered = flinkoRegistered;
	}

	public int getFlinkoNotRegistered() {
		return flinkoNotRegistered;
	}

	public void setFlinkoNotRegistered(int flinkoNotRegistered) {
		this.flinkoNotRegistered = flinkoNotRegistered;
	}

	public List<FlinkoUserEntity> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(List<FlinkoUserEntity> studentSet) {
		this.studentSet = studentSet;
	}	

}
