package com.scm.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundExceptional;
import com.scm.repo.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public User saveUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getById(String id) {
		
		return userRepo.findById(id);
	}

	@Override
	public User updateUser(User user) {
		 User dbUser = userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundExceptional("User Not Found"));
		
		 dbUser.setName(user.getName());
		 dbUser.setEmail(user.getEmail());
		 dbUser.setPassword(user.getPassword());
		 
		 dbUser.setAbout(user.getAbout());
		 dbUser.setPhoneNumber(user.getPhoneNumber());
		 dbUser.setProfilePic(user.getProfilePic());
		 dbUser.setEnabled(user.isEnabled());
		 dbUser.setEmailVerified(user.isEmailVerified());
		 dbUser.setPhoneVerified(user.isPhoneVerified());
		 dbUser.setProvider(user.getProvider());
		 dbUser.setProviderUserId(user.getProviderUserId());
		 
		 
		  
		 
		 return userRepo.save(dbUser);
	}

	@Override
	public void deleteUser(String id) {
		 User dbUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundExceptional("User Not Found"));
			
		userRepo.delete(dbUser);
	}

	@Override
	public List<User> allUser() {
		
		return userRepo.findAll();
	}

	@Override
	public boolean isUserExist(String userId) {
		User user = userRepo.findById(userId).orElse(null);
		
		return user!=null ? true : false;
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		User userByEmail = userRepo.findByEmail(email).orElse(null);
		return userByEmail!=null ? true : false;
	}

}
