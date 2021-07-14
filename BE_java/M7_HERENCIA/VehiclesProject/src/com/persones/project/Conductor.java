package com.persones.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conductor extends Persona {
	protected Llicencia llicencia;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Conductor(String nom, String cognoms, Date dataNaixement,Llicencia llic) {
		super(nom, cognoms, dataNaixement);
		this.llicencia = llic;
	}

	@Override
	public String toString() {
		return "Conductor [ nom : "+nom+" cognoms : "+cognoms+" data naixement : "+sdf.format(dataNaixement)+
				"\n  -"+llicencia.toString() + "]";
	}
	
	public Llicencia getLlicencia() {
		return llicencia;
	}
}
