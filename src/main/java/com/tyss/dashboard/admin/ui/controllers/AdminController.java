package com.tyss.dashboard.admin.ui.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dashboard.admin.api.services.BatchServicesImpl;
import com.tyss.dashboard.admin.api.services.BranchServicesImpl;
import com.tyss.dashboard.admin.api.services.StudentServiceImpl;
import com.tyss.dashboard.admin.api.services.TrainerServiceImpl;
import com.tyss.dashboard.admin.api.services.UserManagementServiceImpl;
import com.tyss.dashboard.admin.data.entities.BatchEntity;
import com.tyss.dashboard.admin.data.entities.BranchEntity;
import com.tyss.dashboard.admin.data.entities.StudentEntity;
import com.tyss.dashboard.admin.data.entities.UserEntity;
import com.tyss.dashboard.admin.model.BatchDto;
import com.tyss.dashboard.admin.model.BranchDto;
import com.tyss.dashboard.admin.model.UserDto;

@RestController
@RequestMapping("admin/")
public class AdminController {

	@Autowired
	BatchServicesImpl batchServicesImpl;

	@Autowired
	UserManagementServiceImpl userManagementServiceImpl;

	@Autowired
	BranchServicesImpl branchServicesImpl;

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@Autowired
	TrainerServiceImpl trainerServiceImpl;

	ModelMapper mapper;

	{
		mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	@GetMapping("status")
	public String status() {

		return "working";
	}

	@PostMapping("create/user")
	public ResponseEntity<String> createUser(@RequestBody UserDto addTrainerRequestModel) {

		return userManagementServiceImpl.addUser(mapper.map(addTrainerRequestModel, UserEntity.class));
	}

	@PostMapping("update/user")
	public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity) {

		return userManagementServiceImpl.editUser(userEntity);
	}

	@GetMapping("view/user")
	public ResponseEntity<UserEntity> viewUser(@RequestParam String phone) {

		return userManagementServiceImpl.viewUser(phone);
	}

	@GetMapping("view/trainer")
	public ResponseEntity<UserEntity> viewTrainer(@RequestParam String phone) {

		return trainerServiceImpl.viewTrainer(phone);
	}

	@GetMapping("view/trainers/branch")
	public ResponseEntity<List<UserEntity>> viewTrainersByBranch(@RequestParam String branchName) {

		return trainerServiceImpl.viewTrainersByBranch(branchName);
	}

	@DeleteMapping("delete/user")
	public ResponseEntity<String> deleteTrainer(@RequestBody UserEntity trainer) {

		return userManagementServiceImpl.deleteUser(trainer);
	}

	@PostMapping("create/batch")
	public ResponseEntity<String> createBatch(@RequestBody BatchDto batchDto) {

		return batchServicesImpl.createBatch(mapper.map(batchDto, BatchEntity.class));
	}

	@GetMapping("view/batch")
	public ResponseEntity<BatchEntity> viewBatch(@RequestParam String batchCode) {

		return batchServicesImpl.viewBatch(batchCode);
	}

	@GetMapping("view/trainer/batch")
	public ResponseEntity<List<BatchEntity>> viewBatchByTrainer(@RequestParam String trainerID) {

		return batchServicesImpl.viewBatchByTrainer(trainerID);
	}

	@PostMapping("update/batch")
	public ResponseEntity<String> updateBatch(@RequestBody BatchEntity batch) {

		return batchServicesImpl.updateBatch(batch);
	}

	@DeleteMapping("delete/batch")
	public ResponseEntity<String> deleteBatch(@RequestBody BatchEntity batch) {

		return batchServicesImpl.deleteBatch(batch);
	}

	@PostMapping("create/branch")
	public ResponseEntity<String> createBatch(@RequestBody BranchDto branchDto) {
		return branchServicesImpl.addBranch(mapper.map(branchDto, BranchEntity.class));
	}

	@GetMapping("view/branch")
	public ResponseEntity<BranchEntity> viewBranch(@RequestParam String branchName, String city, String type) {

		return branchServicesImpl.viewBranch(branchName, city, type);
	}

	@GetMapping("view/all/branches")
	public ResponseEntity<List<BranchEntity>> viewAllBranch() {

		return branchServicesImpl.viewAllBranches();
	}

	@GetMapping("view/city/branches/")
	public ResponseEntity<List<BranchEntity>> viewAllBranchByCity(@RequestParam String city) {

		return branchServicesImpl.viewBranchesByCity(city);
	}

	@DeleteMapping("delete/branch")
	public ResponseEntity<String> deleteBranch(@RequestBody BranchDto branchDto) {

		return branchServicesImpl.deleteBranch(branchDto);
	}

	@PostMapping("upload/students")
	public ResponseEntity<String> uploadStudents(@RequestBody List<StudentEntity> studentList) {

		return studentServiceImpl.uploadStudents(studentList);
	}

	@GetMapping("view/all/students")
	public ResponseEntity<List<StudentEntity>> viewAllStudents() {

		return studentServiceImpl.viewAllStudents();
	}
	@GetMapping("view/branch/students")
	public ResponseEntity<List<StudentEntity>> viewStudentsByBranch(@RequestParam String branch) {

		return studentServiceImpl.viewStudentsByBranch(branch);
	}

	@GetMapping("view/batchcode/students")
	public ResponseEntity<List<StudentEntity>> viewStudentsByBatchCode(@RequestParam String batchCode) {

		return studentServiceImpl.viewStudentsByBatchCode(batchCode);
	}

	@GetMapping("view/branch/batch/students")
	public ResponseEntity<List<StudentEntity>> viewStudentsByBranchAndBatchCode(@RequestParam String branch,
			String batchCode) {

		return studentServiceImpl.viewStudentsByBranchAndBatchCode(branch, batchCode);
	}

}
