package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

	User saveUser(User user);
	Optional<User> getById(String id);
	User updateUser(User user);
	void deleteUser(String id);
	List<User> allUser();
	boolean isUserExist(String userId);
	boolean isUserExistByEmail(String email); //email is our username
	
	
}
