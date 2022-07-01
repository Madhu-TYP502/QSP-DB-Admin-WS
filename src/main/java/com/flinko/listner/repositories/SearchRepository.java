package com.flinko.listner.repositories;

import java.util.List;

import com.flinko.listner.data.entity.FlinkoUserEntity;

public interface SearchRepository {
	
	public List<FlinkoUserEntity> findAll(String query);

}
