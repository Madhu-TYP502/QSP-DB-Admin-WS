package com.tyss.dashboard.admin.api.services;

import org.springframework.http.ResponseEntity;

import com.tyss.dashboard.admin.data.entities.UserEntity;

public interface UserManagementServices<T> {

	public ResponseEntity<UserEntity> viewUser(String userName);

	public ResponseEntity<String> deleteUser(UserEntity userEntity);

	public ResponseEntity<String> addUser(UserEntity userEntity);

	public ResponseEntity<String> editUser(UserEntity userEntity);

}
