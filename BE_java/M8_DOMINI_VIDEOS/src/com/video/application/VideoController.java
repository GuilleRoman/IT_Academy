package com.video.application;

import java.util.Date;

import com.video.domain.Usuari;
import com.video.domain.Video;
import com.video.repositori.UsuarisRepositori;

public class VideoController {
	
	protected UsuarisRepositori usuaris = new UsuarisRepositori();

	/**
	 * addUsuari
	 * 
	 * Crea un usuari i l'emmagatzema a l'arrayList d'usuaris
	 * 
	 * @param nom			String
	 * @param cognoms		String
	 * @param password		String
	 * @param dataActual	Date
	 */
	public void addUsuari(String nom, String cognoms, String password, Date dataActual) {
		Usuari usuari = new Usuari (nom, cognoms, password, dataActual);
		usuaris.afegirUsuari(usuari);		
	}
	
	public UsuarisRepositori getUsuarisRepositori() {
		return usuaris;
	}
	
	public void addVideo(int indexUsuari, Video video) {
		
		//Afegeixo la data de pujada al video.
		Date dataPujada = new Date();
		video.setDataPujada(dataPujada);
		
		//Afegeixo estat del video.
		video.setEstat(new Uploading(video));
		
		//Afegeixo el video a l'usuari seleccionat.
		usuaris.getLlistaUsuaris().get(indexUsuari).addVideo(video);
		
	}
	
	public Video newVideo(String url, String titol,String durada) {
		Video nouVideo = new Video(url, titol, durada);
		return nouVideo;
	}
	
	/**
	 * validarDurada (hores,minuts,segons)
	 * 
	 * Valida si una durada expressada en hh:mm:ss és correcta
	 * 
	 * @param 	hores	String	
	 * @param 	minuts	String
	 * @param 	segons	String
	 * 
	 * @return 	dataCorrecta 	Boolean
	 */
	public Boolean validarDurada(String hores, String minuts, String segons) {
		Boolean dataCorrecta=true;
		try {
			if(Integer.parseInt(hores)>23 || Integer.parseInt(hores)<0) {
				dataCorrecta = false;
			}else if(Integer.parseInt(minuts)>60 || Integer.parseInt(minuts)<0){
				dataCorrecta = false;
			}else if(Integer.parseInt(segons)>60 || Integer.parseInt(segons)<0) {
				dataCorrecta = false;
			}
		}catch (NumberFormatException nfe) {
			dataCorrecta = false;
		}
		 
		return dataCorrecta;		
	}

}
