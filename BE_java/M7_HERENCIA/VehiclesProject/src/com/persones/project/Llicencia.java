package com.persones.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Llicencia {
	protected static int id_llicencia;
	protected String tipus;
	protected String nomComplet;
	protected Date dataCaducitat;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Llicencia(String tipus, String nomComplet, Date dataCaducitat) {
		id_llicencia++;
		this.tipus = tipus;
		this.nomComplet = nomComplet;
		this.dataCaducitat = dataCaducitat;
	}

	@Override
	public String toString() {
		return "Llicencia [tipus=" + tipus + ", nomComplet=" + nomComplet + ", dataCaducitat=" + sdf.format(dataCaducitat) + "]";
	}
	
	
}
