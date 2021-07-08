package com.caden.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caden.albums.models.Album;
import com.caden.albums.services.AlbumService;

@RestController
public class HomeController {
	@Autowired
	private AlbumService aService;
	
	@GetMapping("/")
	public List<Album> allAlbums(){
		return this.aService.allAlbums();
	}
	@GetMapping("/{id}")
	public Album getOneAlbum(@PathVariable("id") long id) {
		return this.aService.getOneAlbum(id);
	}
	@PostMapping("/create")
	public Album createAlbum(Album album) {
		return this.aService.createAlbum(album);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteAlbum(@PathVariable("id") long id) {
		this.aService.deleteAlbum(id);
	}

}
