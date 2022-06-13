package com.tyss.dashboard.admin.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.dashboard.admin.data.entities.StudentEntity;
import com.tyss.dashboard.admin.data.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService<Object> {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public ResponseEntity<String> uploadStudents(List<StudentEntity> studentList) {
		try {
			studentRepository.saveAll(studentList);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student data successfully uploaded!!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace().toString());
		}
	}

	@Override
	public ResponseEntity<List<StudentEntity>> viewStudentsByBatchCode(String batchCode) {
		List<StudentEntity> studentList = studentRepository.findByBatchCode(batchCode);
		if (studentList != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(studentList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentList);
	}

	@Override
	public ResponseEntity<List<StudentEntity>> viewStudentsByBranch(String branch) {
		List<StudentEntity> studentList = studentRepository.findByBranch(branch);
		if (studentList != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(studentList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentList);
	}

	@Override
	public ResponseEntity<List<StudentEntity>> viewStudentsByBranchAndBatchCode(String branch, String batchCode) {
		List<StudentEntity> studentList = studentRepository.findByBranchAndBatchCode(branch, batchCode);
		if (studentList != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(studentList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentList);
	}

	@Override
	public ResponseEntity<List<StudentEntity>> viewAllStudents() {

		List<StudentEntity> studentEntities = studentRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(studentEntities);
	}

}
