package com.persones.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.persones.project.Conductor;
import com.persones.project.Llicencia;
import com.persones.project.Persona;
import com.persones.project.Titular;
import com.vehicles.application.Utilitats;
import com.vehicles.persistence.PersonesRepositori;

public class PersonesController {
	
	PersonesRepositori persones = new PersonesRepositori();	
	
	// ----- CONDUCTORS --------------------------------------------------------------------
	
	public void crearConductor() {
		String nom;
		String cognoms;
		Date dataNaixement;
		Llicencia llic;
		
		// Demanem les dades del conductor
		System.out.println("Afegir nou Conductor  ");
		System.out.print("- Nom : ");
		nom = Utilitats.llegirString();
		
		System.out.print("- Cognoms : ");
		cognoms = Utilitats.llegirString();
		
		System.out.println("- Data naixement : ");
		dataNaixement = Utilitats.llegirData();
		
		llic = addLlicencia();
		
		// Creem el conductor i l'afegim a la llista de titulars
		Conductor conductor = new Conductor(nom, cognoms, dataNaixement, llic);
		persones.addPersona(conductor);
				
		System.out.println("--> El Conductor "+cognoms+","+nom+" ha estat creat correctament.");
		
	}
	
	public Llicencia addLlicencia() {
		String tipus;
		String nomComplet;
		Date dataCaducitat;
		
		System.out.print("Afegir llicència al conductor.");		
		
		System.out.print("- Tipus : ");
		tipus = Utilitats.llegirString();
		System.out.print("- Nom complet : ");
		nomComplet = Utilitats.llegirString();
		System.out.println("- Data de caducitat : ");
		dataCaducitat = Utilitats.llegirData();
				
		Llicencia llic = new Llicencia(tipus, nomComplet, dataCaducitat);
		
		return llic;		
	}
	
	
	
	/**
	 * crearConductorsProva
	 * @throws ParseException 
	 */
	public void crearConductorsProva() throws ParseException {
		Llicencia llic; 
		Conductor conductor; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		llic = new Llicencia("A", "Motos", sdf.parse("20/01/2025"));
		conductor = new Conductor("Sonia", "Marçal reich", sdf.parse("10/01/1969"), llic);
		persones.addPersona(conductor);
		
		llic = new Llicencia("A", "Motos", sdf.parse("20/01/2027"));
		conductor = new Conductor("Laia", "Esquirol cabrejat", sdf.parse("20/03/1977"), llic);
		persones.addPersona(conductor);
		
		llic = new Llicencia("B", "Cotxe i motos 125cc", sdf.parse("18/06/2023"));
		conductor = new Conductor("Carles", "Riera i Estruch", sdf.parse("10/01/1969"), llic);
		persones.addPersona(conductor);
		
		llic = new Llicencia("B", "Cotxe i motos 125cc", sdf.parse("20/01/2024"));
		conductor = new Conductor("Marina", "Subirats Totlomon", sdf.parse("20/03/1977"), llic);
		persones.addPersona(conductor);
		
		llic = new Llicencia("C", "Camions ", sdf.parse("18/06/2022"));
		conductor = new Conductor("Enric", "Parera calabuix", sdf.parse("10/01/1969"), llic);
		persones.addPersona(conductor);
		
		llic = new Llicencia("C", "Camions", sdf.parse("20/04/2026"));
		conductor = new Conductor("Rosaura", "Calmet rosich", sdf.parse("20/03/1977"), llic);		
		persones.addPersona(conductor);
		
		System.out.println("--> Atenció : fegits 6 nous conductors");
	}
	
	/**
	 * mostrarConductors
	 */
	public void mostrarConductors() {
		
		for(Persona pers : persones.getPersones()) {
			
			if(pers instanceof Conductor) {
				System.out.println(pers.toString());
			}							
		}
	}
	
	
	
	
	
	
	
	// ----- TITULAR ------------------------------------------------------------------------
	
	public void crearTitular() {
		String nom;
		String cognoms;
		Date dataNaixement;
		Boolean asseguranca;
		Boolean parking;
		
		// Demanem les dades del titular
		System.out.println("Afegir nou titular  ");
		System.out.print("- Nom : ");
		nom = Utilitats.llegirString();
		
		System.out.print("- Cognoms : ");
		cognoms = Utilitats.llegirString();
		
		System.out.println("- Data naixement : ");
		dataNaixement = Utilitats.llegirData();
		
		System.out.print(" - Té assegurança (si/no) :");
		asseguranca = Utilitats.siNo();
		
		System.out.print("- Té garate propi (si/no) :");
		parking = Utilitats.siNo();
		
		// Creem el titular i l'afegim a la llista de titulars
		Titular titular = new Titular(nom, cognoms, dataNaixement,asseguranca,parking);
		persones.addPersona(titular);
		
		System.out.println("--> El Titular "+cognoms+","+nom+" ha estat creat correctament.");
	}
		
	
	/**
	 * titularsProva
	 * 
	 * @param nom
	 * @param cognoms
	 * @param dataNaix
	 * @param asseguranca
	 * @param parking
	 * @throws ParseException 
	 * 
	 */
	public void crearTitularsProva() throws ParseException {
		
		Titular titular;
		Date data;
		String dataStr;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		dataStr = "20/01/1970";
		data = sdf.parse(dataStr);		
		titular = new Titular ("Rosa", "Lluc Salido", data, true, true );
		persones.addPersona(titular);
		
		dataStr = "17/11/1968";
		data = sdf.parse(dataStr);
		titular = new Titular ("Joan", "Dominguez samiier", data, true, false );
		persones.addPersona(titular);
		
		dataStr = "03/06/1975";
		data = sdf.parse(dataStr);
		titular = new Titular ("Maria", "Torribes gaig", data, true, true );
		persones.addPersona(titular);
		
		dataStr = "10/07/1971";
		data = sdf.parse(dataStr);
		titular = new Titular ("Laia", "Llac salelles", data, true, false );
		persones.addPersona(titular);
		
		System.out.println("--> Atenció : fegits 4 nous titulars ");
	}
	
	/**
	 * mostrarTitulars
	 */
	public void mostrarTitulars() {
		
		for(Persona pers : persones.getPersones()) {
			
			if(pers instanceof Titular) {
				System.out.println(pers.toString());
			}							
		}
	}
	
	public void mostrarPersones() {
		
		for(Persona pers : persones.getPersones()) {
			
			System.out.println(pers.toString());										
		}
	}
	
	public List<Persona> getPersones(){
		return persones.getPersones();
	}
	
	
}
