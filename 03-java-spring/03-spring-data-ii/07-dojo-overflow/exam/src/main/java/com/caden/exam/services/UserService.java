package com.caden.exam.services;


import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.exam.models.User;
import com.caden.exam.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
	public User findOneUser(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	public User regUser(User user) {
		// generate hash 
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// set the newly hashed password to user password field 
		user.setPassword(hash);
		//save the password to the database 
		return this.uRepo.save(user);
	}
	
	public boolean loginUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user==null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
		
	}
}