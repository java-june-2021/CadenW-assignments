package com.caden.beltReview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.beltReview.models.Thought;
import com.caden.beltReview.models.User;
import com.caden.beltReview.repositories.ThoughtRepository;

@Service
public class ThoughtService {
	@Autowired
	private ThoughtRepository tRepo;
	
	public List<Thought> allThoughts(){
		return this.tRepo.findAll();
	}
	public Thought getOneThought(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	public Thought createThought(Thought thought) {
		return this.tRepo.save(thought);
	}
	public void deleteThought(Long id) {
		this.tRepo.deleteById(id);
	}
	public void likeThought(User user, Thought thought) {
		List<User> usersWhoLiked = thought.getUsersWhoLiked();
		usersWhoLiked.add(user);
		this.tRepo.save(thought);
	}
	public void unlikeThought(User user, Thought thought) {
		List<User> usersWhoLiked = thought.getUsersWhoLiked();
		usersWhoLiked.remove(user);
		this.tRepo.save(thought);
	}
	

}
