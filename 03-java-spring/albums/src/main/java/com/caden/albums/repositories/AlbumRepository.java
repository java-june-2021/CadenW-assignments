package com.caden.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caden.albums.models.Album;

@Repository 
public interface AlbumRepository extends CrudRepository<Album, Long>{
	List<Album> findAll();   //this is the same as SELECT * FROM albums in mySQL
}
