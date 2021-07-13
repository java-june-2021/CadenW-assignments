package com.caden.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caden.languages.models.Language;
import com.caden.languages.repositories.LanguageRepository;

@Service 
public class LanguageService {
	private LanguageRepository lRepo;
	public LanguageService(LanguageRepository lRepo) {
		this.lRepo = lRepo;
	}
	public List<Language> allLanguages(){
		return this.lRepo.findAll();
	}
	public Language addLang(Language lang) {
		return this.lRepo.save(lang);
	}
	public Language getOneLang(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}

}
