package com.caden.albums.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, max=100)
	private String bandName;
	@NotBlank
	private String albumName;
	@Min(1900)
	private int releaseYear;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	//Connecting the two models (album and label)
	@OneToOne(mappedBy="album", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Label label;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//One to many relationship between album and songs 
	@OneToMany(mappedBy="album", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Song> songs;
	
	//Setting up many to many relationship between users and albums they can like
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name="album_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> likers;
	public List<Song> getSongs() {
		return songs;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<User> getLikers() {
		return likers;
	}



	public void setLikers(List<User> likers) {
		this.likers = likers;
	}



	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}



	public Label getLabel() {
		return label;
	}



	public void setLabel(Label label) {
		this.label = label;
	}



	public Album() {
	}
	
	
	
	public Album(String bandName, String albumName, int releaseYear) {
		this.bandName = bandName;
		this.albumName = albumName;
		this.releaseYear = releaseYear;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	

}
