package com.tyss.dashboard.admin.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.dashboard.admin.data.entities.UserEntity;
import com.tyss.dashboard.admin.data.repositories.BatchRepository;
import com.tyss.dashboard.admin.data.repositories.UserRepository;

@Service
public class TrainerServiceImpl implements TrainerServices {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BatchRepository batchRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ResponseEntity<List<UserEntity>> viewTrainersByBranch(String branchName) {

		Query query = new Query();

		query.addCriteria(Criteria.where("branchesAssigned").is(branchName.toLowerCase()).and("role").is("trainer"));

		List<UserEntity> trainerList = mongoTemplate.find(query, UserEntity.class);

		return ResponseEntity.status(HttpStatus.FOUND).body(trainerList);
	}

	@Override
	public ResponseEntity<UserEntity> viewTrainer(String trainerName) {

		Query query = new Query();

		query.addCriteria(Criteria.where("name").is(trainerName.toLowerCase()).and("role").is("trainer"));

		UserEntity trainer = mongoTemplate.find(query, UserEntity.class).get(0);

		if (trainer != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(trainer);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trainer);
	}
}
