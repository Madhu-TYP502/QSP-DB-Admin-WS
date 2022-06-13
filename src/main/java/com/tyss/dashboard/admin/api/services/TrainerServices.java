package com.tyss.dashboard.admin.api.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tyss.dashboard.admin.data.entities.UserEntity;

public interface TrainerServices {

	public ResponseEntity<List<UserEntity>> viewTrainersByBranch(String branchName);

	public ResponseEntity<UserEntity> viewTrainer(String trainerName);
}
