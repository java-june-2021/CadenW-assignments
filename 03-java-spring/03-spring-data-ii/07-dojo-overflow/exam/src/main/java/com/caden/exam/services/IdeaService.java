package com.caden.exam.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.exam.models.Idea;
import com.caden.exam.models.User;
import com.caden.exam.repositories.IdeaRepository;

@Service 
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	
	public List<Idea> allIdeas(){
		return this.iRepo.findAll();
	}
	
	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	public Idea getOneIdea(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	public Idea updateIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	public void deleteIdea(Long id) {
		this.iRepo.deleteById(id);
	}
	public void addLike(Idea idea, User user) {
		List<User> currentLikes = idea.getLikers();
		currentLikes.add(user);
		this.iRepo.save(idea);
	}
	public void removeLike(Idea idea, User user) {
		List<User> currentLikes = idea.getLikers();
		currentLikes.remove(user);
		this.iRepo.save(idea);
	}

}
