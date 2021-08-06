package com.caden.beltReview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caden.beltReview.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment> findAll();

}
