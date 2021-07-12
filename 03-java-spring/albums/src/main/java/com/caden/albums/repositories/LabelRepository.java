package com.caden.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caden.albums.models.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
	

}
