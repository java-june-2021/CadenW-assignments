package com.caden.dojosAndNinjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.dojosAndNinjas.models.Ninja;
import com.caden.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public Ninja create(Ninja ninja) {
		return this.nRepo.save(ninja);
	}

}
