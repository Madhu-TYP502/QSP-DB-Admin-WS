package com.tyss.dashboard.admin.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import com.tyss.dashboard.admin.data.entities.UserEntity;

@FeignClient(name = "admin-service")
public interface AdminClient {
	List<UserEntity> findByTrainerName(String trainerName	);
}
