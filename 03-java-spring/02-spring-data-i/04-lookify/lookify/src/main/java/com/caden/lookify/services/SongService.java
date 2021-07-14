package com.caden.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caden.lookify.models.Song;
import com.caden.lookify.repositories.SongRepository;

@Service 
public class SongService {
	private SongRepository sRepo;
	public SongService(SongRepository sRepo) {
		this.sRepo = sRepo;
	}
	public List<Song> allSongs(){
		return this.sRepo.findAll();
	}
	public Song createSong(Song song) {
		return this.sRepo.save(song);
	}
	public Song getOneSong(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public Song update(Song song) {
		return this.sRepo.save(song);
	}
	public void delete(Long id) {
		this.sRepo.deleteById(id);
	}
	public List<Song> searchArtist(String artist){
		return sRepo.searchByArtist(artist);
	}
	public List<Song> topTen(){
		return sRepo.findTopTenByRating();
	}
}
