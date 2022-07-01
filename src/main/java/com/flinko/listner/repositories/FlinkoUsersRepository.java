package com.flinko.listner.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flinko.listner.data.entity.FlinkoUserEntity;

@Repository("FlinkoUsersRepository")
public interface FlinkoUsersRepository extends MongoRepository<FlinkoUserEntity, String> {
	
	@Query(value = "{isRegistered: ?0}", count = true)
	public long countRegisteredUsers(String isRegistered);
	
	@Query(value = "{isRegistered: ?0}", count = false)
	public long countNotRegisteredUsers(String isRegistered);

}
