package com.tyss.dashboard.admin.api.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.dashboard.admin.data.entities.UserEntity;
import com.tyss.dashboard.admin.model.DeleteUserRequestModel;
import com.tyss.dashboard.admin.model.UserDto;

import feign.FeignException;

@FeignClient(name = "users-ws", fallbackFactory = UsersConsumerFallbackFactory.class)
public interface UsersConsumer {

	@PostMapping("users/add/user")
	public ResponseEntity<String> createUser(@RequestBody UserDto addTrainerRequestModel);

	@PostMapping("users/update/user")
	public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity);

	@GetMapping("users/get/user")
	public ResponseEntity<UserEntity> viewUser(@RequestParam String phone);

	@GetMapping("users/get/all/users")
	public ResponseEntity<List<UserEntity>> viewAllUsers();
	
	@PostMapping("users/delete/user")
	public ResponseEntity<String> deleteUser(@RequestBody DeleteUserRequestModel deleteUserRequestModel);
}

@Component
class UsersConsumerFallbackFactory implements FallbackFactory<UsersConsumer> {

	@Override
	public UsersConsumer create(Throwable cause) {

		return new UsersConsumerFallback(cause);
	}

}

class UsersConsumerFallback implements UsersConsumer {
	
	Logger logger = LoggerFactory.getLogger(UsersConsumerFallback.class);


	private Throwable cause;

	public UsersConsumerFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public ResponseEntity<String> createUser(UserDto addTrainerRequestModel) {
		return ResponseEntity.status(((FeignException) cause).status())
				.body(formatErrorMessage(cause.getLocalizedMessage()));
	}

	@Override
	public ResponseEntity<String> updateUser(UserEntity userEntity) {
		return ResponseEntity.status(((FeignException) cause).status())
				.body(formatErrorMessage(cause.getLocalizedMessage()));
	}

	@Override
	public ResponseEntity<UserEntity> viewUser(String phone) {
		return ResponseEntity.status(((FeignException) cause).status()).body(null);
	}

	private String formatErrorMessage(String message) {
		return message.substring(message.indexOf("$") + 1, message.length() - 1);
	}

	@Override
	public ResponseEntity<List<UserEntity>> viewAllUsers() {
		return ResponseEntity.status(((FeignException) cause).status()).body(null);
	}

	@Override
	public ResponseEntity<String> deleteUser(DeleteUserRequestModel deleteUserRequestModel) {
		logger.info("INSIDE DELETE CONTROLLER FALLBACK");
		return ResponseEntity.status(((FeignException) cause).status()).body("Trainer with  EMAIL : "+deleteUserRequestModel.getEmail()+" and  PHONE : "+deleteUserRequestModel.getPassword()+" NOT FOUND");
	}

}
