package com.tyss.dashboard.admin.data.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tyss.dashboard.admin.data.entities.BranchEntity;

@Repository
public interface BranchRepository extends MongoRepository<BranchEntity,String> {

	public List<BranchEntity> findAllByCity(String city);
}
