package com.tyss.dashboard.admin.api.services;

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
public class UserManagementServiceImpl implements UserManagementServices<Object> {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BatchRepository batchRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ResponseEntity<String> addUser(UserEntity userEntity) {

		if (mongoTemplate
				.find(new Query().addCriteria(Criteria.where("email").is(userEntity.getEmail())), UserEntity.class)
				.size() == 0
				&& (mongoTemplate.find(new Query().addCriteria(Criteria.where("phone").is(userEntity.getPhone())),
						UserEntity.class).size() == 0)) {

			userEntity.setName(userEntity.getName().toLowerCase());
			userEntity.setEmail(userEntity.getEmail().toLowerCase());
			userEntity.setId(userEntity.getPhone());
			userEntity.setStatus("PENDING");

			userRepository.save(userEntity);

			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userEntity.getRole() + " added susccesfully!!");

		}
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(("Trainer with the given email or mobile number already exists!!!"));
	}

	@Override
	public ResponseEntity<String> editUser(UserEntity userEntity) {

		if (userRepository.existsByPhone(userEntity.getPhone())) {

			userEntity.setId(userEntity.getPhone());
			userRepository.save(userEntity);

			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(userEntity.getRole() + " data updated susccesfully!!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(userEntity.getRole() + " with the given phone number do not exists!!!");
	}

	@Override
	public ResponseEntity<String> deleteUser(UserEntity userEntity) {

		if (userRepository.existsByEmail(userEntity.getEmail())) {
			userRepository.delete(userEntity);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Trainer data deleted susccesfully!!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trainer with the given email do not exists!!!");
	}

	@Override
	public ResponseEntity<UserEntity> viewUser(String phone) {

		UserEntity user = userRepository.findByPhone(phone);

		if (user != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(user);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
	}
}
	
