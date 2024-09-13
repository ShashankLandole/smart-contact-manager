package com.scm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	//findout all the ways to write custoom method using query and all type
	
	Optional<User> findByEmail(String email);
}
