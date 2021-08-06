package com.caden.beltReview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caden.beltReview.models.Comment;
import com.caden.beltReview.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cRepo;
	
	public List<Comment> allComments(){
		return this.cRepo.findAll();
	}
	public Comment getOneComment(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public Comment createComment(Comment comment) {
		return this.cRepo.save(comment);
	}
	public void deleteComment(Long id) {
		this.cRepo.deleteById(id);
	}
}
