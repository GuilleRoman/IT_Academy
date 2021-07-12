package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vehicles.project.Vehicle;

public class VehicleRepositori {
	
	// crea la llista que contrindrà el parc de vehicles.
	private List<Vehicle> parcVehicles = new ArrayList<Vehicle>();
	
	/**
	 * Constructor
	 */
	public VehicleRepositori() {
		
	}
	
	/**
	 * Afegir vehicle al parc de vehicles
	 * 
	 * @param vehicle	Vehicle
	 */
	public void addVehicle(Vehicle vehicle) {
		parcVehicles.add(vehicle);
	}
	
	
	/**
	 * getParcVehicles
	 * 
	 * @return	parcVehiles		List<Vehicle>
	 */
	public List<Vehicle> getParcVehicles(){
		return parcVehicles;
	}
	
	/**
	 * getAllVehicles
	 * 
	 * @return	missatge	String
	 */
	public String getAllVehicles() {
		String missatge="";
		
		System.out.println("Relació de vehicles del CarWorkShop: ");
		
		Iterator<Vehicle> it=parcVehicles.iterator();
		
		while(it.hasNext()) {
			missatge+=it.next().toString()+"\n";
		}
		
		// Si la col.lecció no té elements, ho indiquem via missatge.
		if(missatge.equals("")) {
			missatge="No hi ha vehicles al repositori";
		}
		
		return missatge;
	}	
	
}
