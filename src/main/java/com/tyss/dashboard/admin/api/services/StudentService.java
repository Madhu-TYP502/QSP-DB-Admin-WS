package com.tyss.dashboard.admin.api.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tyss.dashboard.admin.data.entities.StudentEntity;

public interface StudentService<T> {

	public ResponseEntity<String> uploadStudents(List<StudentEntity> studentList);

	public ResponseEntity<List<StudentEntity>>  viewStudentsByBatchCode(String batchCode);

	public ResponseEntity<List<StudentEntity>> viewStudentsByBranch(String branch);

	public ResponseEntity<List<StudentEntity>> viewStudentsByBranchAndBatchCode(String branch, String batchCode);
	
	public ResponseEntity<List<StudentEntity>> viewAllStudents();
}
