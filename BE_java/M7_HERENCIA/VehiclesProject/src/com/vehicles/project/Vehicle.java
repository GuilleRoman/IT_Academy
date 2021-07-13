package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

import com.persones.project.Conductor;
import com.persones.project.Persona;
import com.persones.project.Titular;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected Titular titular;
	protected List<Persona> conductors = new ArrayList<Persona>();
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	
	public Vehicle(String plate, String brand, String color) {
		super();
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public Vehicle(String plate, String brand, String color, Titular titular) {
		super();
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		this.titular = titular;
	}
	
	public Vehicle(String plate, String brand, String color, Titular titular, List<Persona> conductors) {
		super();
		this.plate = plate;
		this.brand = brand;
		this.color = color;
		this.titular = titular;
		this.conductors = conductors;
	}

	// toString, Getters and Setters ----------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Vehicle [plate=" + plate + ", brand=" + brand + ", color=" + color + "\n, wheels=" + wheels + "]\n Titular :"+
				titular.toString()+" conductors : "+conductors.toString();
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	
	public void addConductor(Conductor conductor) {
		conductors.add(conductor);
	}
	
	
}
