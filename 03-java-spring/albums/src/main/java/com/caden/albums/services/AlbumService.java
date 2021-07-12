package com.caden.albums.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caden.albums.models.Album;
import com.caden.albums.repositories.AlbumRepository;

@Service 
public class AlbumService {
	private AlbumRepository aRepo;
	public AlbumService(AlbumRepository aRepo) {
		this.aRepo = aRepo;
	}
	//display all albums 
	public List<Album> allAlbums(){
		return this.aRepo.findAll();
	}
//	create
	public Album createAlbum(Album album) {
		return this.aRepo.save(album);
	}
	//read
	public Album getOneAlbum(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	//update 
	public Album updateAlbum(Album album) {
		return this.aRepo.save(album);
	}
	//delete
	public void deleteAlbum(Long id) {
		this.aRepo.deleteById(id);
	}

}
