package com .vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addWheels(Wheel frontWheels, Wheel backWheels) throws Exception {
		this.wheels.add(frontWheels);
		this.wheels.add(backWheels);
	}

	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", titular=" + titular
				+ ", conductors=" + conductors + ", wheels=" + wheels + "]";
	}
	
	
	
	
}
