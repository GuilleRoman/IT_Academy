package com.persones.project;

import java.util.Date;

public class Persona {
	protected String nom;
	protected String cognoms;
	protected Date dataNaixement;
	
	// --- CONSTRUCTORS ---
	public Persona(String nom,String cognoms,Date dataNaixement) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dataNaixement = dataNaixement;
	}
	
	public Persona(String nom,String cognoms) {
		this.nom = nom;
		this.cognoms = cognoms;
	}
	
	@Override
	public String toString() {
		return "Persona [ nom : "+nom+" cognoms : "+cognoms+" data Naixement : "+dataNaixement+" ]";
	}

	
	
}
