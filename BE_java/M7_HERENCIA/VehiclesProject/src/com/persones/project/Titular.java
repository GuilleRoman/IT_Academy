package com.persones.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Titular extends Persona {
	
	Boolean asseguranca;
	Boolean parkingPropi;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//--- CONSTUCTORS ------
	public Titular(String nom, String cognoms,Boolean asseguranca, Boolean parkingPropi) {
		super(nom, cognoms);
		this.asseguranca = asseguranca;
		this.parkingPropi = parkingPropi;	
	}
	
	public Titular(String nom, String cognoms, Date dataNaixement, Boolean asseguranca, Boolean parkingPropi) {
		super(nom, cognoms, dataNaixement);
		this.asseguranca = asseguranca;
		this.parkingPropi = parkingPropi;	
	}

	@Override
	public String toString() {
		return "Titular [ nom : " + nom +" cognoms : "+cognoms+" data naixement : "+sdf.format(dataNaixement)+
				"\n asseguranca=" + asseguranca + ", parkingPropi=" + parkingPropi +  "]\n";
	}
	
	
	
	
}
