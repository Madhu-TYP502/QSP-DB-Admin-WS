package com.flinko.listner.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flinko.listner.dashboard.components.DashboardComponents;
import com.flinko.listner.data.model.SearchFilter;
import com.flinko.listner.repositories.FlinkoUsersRepository;
import com.flinko.listner.services.TrainerProjectNewImpl;

@RestController
@RequestMapping("/flinko")
public class FlinkoController {

	@Autowired
	FlinkoUsersRepository flinkoUsersRepository;

	@Autowired
	TrainerProjectNewImpl trainerProjectNewImpl;

	@GetMapping("/get/all/")
	public ResponseEntity<DashboardComponents> getAllUsers(@RequestBody SearchFilter searchFilter)
			throws ParseException {

		return trainerProjectNewImpl.getDashboardData(searchFilter);
	}

	@GetMapping("/status")
	public ResponseEntity<String> checkStatus() {

		return ResponseEntity.ok("WORKING PERFECTLY...");
	}

}
