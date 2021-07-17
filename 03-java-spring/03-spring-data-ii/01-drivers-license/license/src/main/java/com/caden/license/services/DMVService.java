package com.caden.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.license.models.License;
import com.caden.license.models.User;
import com.caden.license.repositories.LicenseRepository;
import com.caden.license.repositories.UserRepository;

@Service 
public class DMVService {
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private LicenseRepository lRepo;
	
	
	public User createUser(User user) {
		return this.uRepo.save(user);	
	}
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	public List<User> getUsersWithoutLicense(){
		return this.uRepo.findByLicenseIdIsNull();
	}
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	public int generateLicenseNumber() {
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l == null) {
			return 1;
		}
		int previousLicenseNumber = l.getNumber();
		previousLicenseNumber++;
		return (previousLicenseNumber);
	}

}
