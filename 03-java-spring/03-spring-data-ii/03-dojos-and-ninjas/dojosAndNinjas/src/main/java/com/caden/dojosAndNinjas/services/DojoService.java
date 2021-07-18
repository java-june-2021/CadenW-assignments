package com.caden.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.dojosAndNinjas.models.Dojo;
import com.caden.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	public List<Dojo> allDojos(){
		return this.dRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	public Dojo updateDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	public void deleteDojo(Long id) {
		this.dRepo.deleteById(id);
	}

}
