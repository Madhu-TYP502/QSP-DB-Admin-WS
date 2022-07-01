package com.flinko.listner.services;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;

import com.flinko.listner.dashboard.components.DashboardComponents;
import com.flinko.listner.data.model.SearchFilter;

public interface TrainerProjectionServices {

	public ResponseEntity<DashboardComponents> getDashboardData(SearchFilter searchFilter) throws ParseException;
	
}
