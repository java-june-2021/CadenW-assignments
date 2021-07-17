package com.caden.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caden.license.models.User;

@Repository 
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	List<User> findByLicenseIdIsNull();

}
