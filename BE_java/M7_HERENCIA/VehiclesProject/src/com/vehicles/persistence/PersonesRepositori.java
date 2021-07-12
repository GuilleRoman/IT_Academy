package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.persones.project.Persona;

public class PersonesRepositori {

	List<Persona> persones = new ArrayList<Persona>();
	
	/**
	 * Constructor
	 */
	public PersonesRepositori(){
		
	}
	
	/**
	 * addPersona
	 * 
	 * Afegir una persona a l'arrayList
	 *  
	 * @param person
	 */
	public void addPersona(Persona person) {
		persones.add(person);
	}
	
	/**
	 * getPersones
	 * 
	 * Retorna la Col·lecció de persones
	 * 
	 */
	public List<Persona> getPersones() {
		return persones;
	}
	
	
	/**
	 * getAllPersones
	 * 
	 * Retorna un String amb totes les persones
	 * 
	 * @return	llistaPersones	String
	 */
	public String getAllPersones() {
		String llistaPersones ="";

		for(Persona pers : persones) {
			llistaPersones += pers.toString();			
		}
		
		return llistaPersones;
	}
	
}
