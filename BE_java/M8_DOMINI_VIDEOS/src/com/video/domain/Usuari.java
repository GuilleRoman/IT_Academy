package com.video.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuari {
	private String nom;
	private String cognoms;
	private String password;
	private Date dataRegistre;
	private List<Video> videos = new ArrayList<Video>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Usuari (String nom, String cognoms, String password, Date dataRegistre) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.password = password;
		this.dataRegistre = dataRegistre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistre() {
		return dataRegistre;
	}
	
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public void addVideo(Video video) {
		videos.add(video);
	}
	public void setDataRegistre(Date dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	@Override
	public String toString() {
		return nom +" ,"+cognoms +" ["+ password +"]"+" -"+sdf.format(dataRegistre) +" -";
	}	
	
	public String nomToString() {
		return nom+", "+cognoms;
	}
}
