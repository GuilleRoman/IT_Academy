package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	
	// Defineixo que dues rodes les consideraré iguals quan
	// siguin del mateix diàmetre independenment de la marca. 
	@Override
	public boolean equals(Object obj) {
		Boolean eq;
		
		Wheel wheel=(Wheel)obj;
		
		if(diameter == wheel.diameter) {
			eq = true;
		} else {
			eq = false;
		}		
		
		return eq;
	}
	
	
	
	@Override
	public String toString() {
		return "\nWheel [brand : " + brand + ", diameter : " + diameter + "]";
	}
	
	
}
