package com.video.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.video.application.Aturat;
import com.video.application.Estats;
import com.video.application.Status;

public class Video {
	public enum status {ATURAT, REPODUINT_SE, PAUSAT};
	
	private String url;
	private String titol;
	private Date dataPujada;
	private Estats estat;
	private Status estatus;
	private String duradaVideo;
	private String tempsActual="00:00:00";
	private List <Tag> tags = new ArrayList<Tag>();
	
	public Video (String url, String titol) {
		this.url = url;
		this.titol = titol;	
		this.estatus = new Aturat(this);
	}
	
	
	public Video (String url, String titol, String duradaVideo) {
		this.url = url;
		this.titol = titol;		
		this.duradaVideo =duradaVideo;
		this.estatus = new Aturat(this);
	}				

	public Status getEstatus() {
		return estatus;
	}


	public void setEstatus(Status estatus) {
		this.estatus = estatus;
	}


	public String getDuradaVideo() {
		return duradaVideo;
	}


	public void setDuradaVideo(String duradaVideo) {
		this.duradaVideo = duradaVideo;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setDataPujada(Date data) {
		this.dataPujada =  data;
	}
			
	public Estats getEstat() {
		return estat;
	}


	public void setEstat(Estats estat) {
		this.estat = estat;
	}


	public Date getDataPujada() {
		return dataPujada;
	}
	
	public String getTempsActual() {
		return tempsActual;
	}


	public void setTempsActual(String tempsActual) {
		this.tempsActual = tempsActual;
	}


	@Override
	public String toString() {
		return "- url : " + url + ", titol : " + titol +" Estat : "+estat.getEstat()+"\n   - tags=" + tags + "]";
	}
	
}
