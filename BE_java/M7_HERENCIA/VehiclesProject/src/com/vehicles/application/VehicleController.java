package com.vehicles.application;

import java.util.ArrayList;

import java.util.List;

import com.persones.application.PersonesController;
import com.persones.project.Persona;
import com.persones.project.Titular;
import com.vehicles.persistence.VehicleRepositori;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;
import com.vehicles.view.*;


public class VehicleController {
	
	protected VehicleRepositori carWorkShop = new VehicleRepositori(); //Creo un nou repositori
		
	/**
	 * getCarWorkShop
	 * Retorna tots els vehicles del carWorkShop
	 * 
	 * 
	 * @return	String
	 */
	public String getCarWorkShop() {
		
		return carWorkShop.getAllVehicles();
	}
	
	/**
	 * 
	 * 
	 * @param plate
	 * @param llistaTitulars
	 * @return
	 */
	public Titular assignarTitular(String plate, List<Persona> llistaTitulars) {
		int id_titular;
			
		// Si hi han titulars,  mostro els titulars que tenim 
		if(llistaTitulars.size()>0) {
			for(int i=0; i<llistaTitulars.size();i++) {
				if(llistaTitulars.get(i) instanceof Titular) {
					System.out.println ("id "+i+" "+llistaTitulars.get(i).toString());
				}
			}
			
			do {
				System.out.print("Selecciona el id de titular que vols escollir :");
				id_titular = Utilitats.llegirSencer(0, llistaTitulars.size());
			}while(!(llistaTitulars.get(id_titular) instanceof Titular));
		}else {
			System.out.println("No hi han titulars disponibles, has de crear un de nou");
			return null;
		}
		
		return (Titular) llistaTitulars.get(id_titular);
	}
	
	/**
	 * addBike
	 * 
	 * @param plate	String
	 * @param brand	String
	 * @param color	String
	 * 
	 * @throws Exception
	 */
	public void addBike(String plate, String brand, String color) throws Exception {
		Wheel frontWheel;
		Wheel rearWheel;
		
		Bike bike = new Bike(plate, brand, color);
		
		//afegim la  roda davantera i traseres.
		System.out.println("Roda davantera :  ");
		frontWheel = wheelDate();
		System.out.println("Roda trasera :  ");
		rearWheel = wheelDate();
		bike.addWheels(frontWheel, rearWheel);
		
		// afegim la Bike al CarWorkShop
		carWorkShop.addVehicle(bike);
		System.out.println("La motocicleta "+bike.getPlate()+" ha estat afegit al CarWorkShop");
	}
		
	/**
	 * addCar
	 * 
	 * afegir Cotxe al carWorkShop 
	 * @throws Exception 
	 */
	public void addCar(String plate, String brand, String color, Titular titular) throws Exception {
		List<Wheel> wheelsFront;
		List<Wheel> wheelsRear;
		
		Car newCar = new Car(plate, brand,color,titular);			
		
		//afegim les dues rodes davanteres i traseres.
		System.out.println("Rodes davanteres :  ");
		wheelsFront = addCarWheels();
		
		System.out.println("Rodes traseres     :  ");
		wheelsRear = addCarWheels();
		
		newCar.addWheels(wheelsFront, wheelsRear);
		carWorkShop.addVehicle(newCar);
		System.out.println("El cotxe "+newCar.getPlate()+" ha estat afegit al CarWorkShop");
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Wheel> addCarWheels() {
				
		Wheel wheelRight;
		Wheel wheelLeft; 
		
		List <Wheel> wheels = new ArrayList<Wheel>();
		
		
		//demanem marca i diàmete de les rodes 
		System.out.print("- Roda dreta : ");
		wheelRight = wheelDate();
		
		System.out.print("- Roda esquerra : ");
		wheelLeft = wheelDate();
		
		//Afegim les rodes a la llista de rodes 
		wheels.add(wheelRight);
		wheels.add(wheelLeft);
		
		return wheels;
	}
	
	
	/**
	 * wheelDate
	 * Assigna les propietat brand, diametre a un obj Wheel
	 * 
	 * @return	wheel	Wheel
	 */
	public Wheel wheelDate() {
		String brand;
		double diameter;
		
		System.out.print("Marca : ");
		brand = Utilitats.llegirString();
		
		System.out.print("diametre : ");
		diameter = Utilitats.llegirReal(0.4, 4,true); // min, max, positiu true (>0)
		
		Wheel wheel = new Wheel(brand, diameter);
		
		return wheel;		
	}
	
	
	/**
	 * requestCarDate
	 * demanar dades bàsiques del vehicle
	 *  
	 * @return  carDate		String[3] plate,brand,color
	 */
	public String[] requestVehicleDate() {
		String[] carDate = new String[3];
		
		//demanem les dades bàsiques del vehicle
		String plate = requestPlate();
		String brand = requestBrand();
		String color = requestColor();
		
		//Assignem les dades i les retornem.
		carDate[0] = plate;
		carDate[1] = brand;
		carDate[2] = color;
		
		return carDate;
	}
	
		
	/**
	 * requestPlate
	 * 
	 * @return	plate	String
	 */
	public String requestPlate() {
		Boolean iterar = true;
		String plate;
		
		System.out.print("Matrícula del vehicle : ");
		
		// Determinem si la matrícula té un format correcte
		do {
			plate = Utilitats.llegirString().toUpperCase();		 //demanem la matrícula
			
			if(!plate.matches("^[0-9]{4}[A-Z]{3}$")) {	//Determinem si el format és correcte
				iterar=true;
				System.out.println("El format de la matrícula ha de ser 4 dígits i 3 lletres.");
				System.out.println("Torna a introduir la matrícula");
			}else {
				iterar=false;
			}
			
		}while(iterar);
		
		return plate;
	}
	
	/**
	 * requestBrand
	 * 
	 * @return	brand	String
	 */
	public String requestBrand() {
		System.out.print("Marca del vehicle : ");
		String brand = Utilitats.llegirString();
		
		return brand.toUpperCase();
	}
	
	
	/**
	 * requestColor
	 *  
	 * @return	color 	String
	 */
	public String requestColor() {
		System.out.print("Color del vehicle : ");
		String color = Utilitats.llegirString();
				
		
		return color.toUpperCase();
	}
}
