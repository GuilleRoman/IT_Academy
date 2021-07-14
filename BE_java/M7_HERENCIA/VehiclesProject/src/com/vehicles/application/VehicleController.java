package com.vehicles.application;

import java.util.ArrayList;

import java.util.List;

import com.persones.project.Conductor;
import com.persones.project.Persona;
import com.persones.project.Titular;
import com.vehicles.persistence.VehicleRepositori;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;


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
		Conductor conductor;
		
		Bike bike = new Bike(plate, brand, color);
		
		//afegim la  roda davantera i traseres.
		System.out.println("Roda davantera :  ");
		frontWheel = wheelDate();
		System.out.println("Roda trasera :  ");
		rearWheel = wheelDate();
		bike.addWheels(frontWheel, rearWheel);
		
		bike.setTitular(seleccionarTitular());	// Afegeixo el titular al vehicle
		
		//Afegeixo conductors al vehicle
		do {
			conductor = seleccionarConductor();
			if(conductor.getLlicencia().getTipus()!="A"){ 
				System.out.println("ATENCI� : Aquest conductor no t� llic�ncia per conduir una moto ");
			}else {
				bike.addConductor(conductor); //Afegeixo el conductor al vehicle.
			}
			
			System.out.print("Vols inserir un altre conductor? (si/no)");			
		}while(Utilitats.siNo());
		
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
	public void addCar(String plate, String brand, String color, List<Persona> persons) throws Exception {
		Conductor conductor;		
		List<Wheel> wheelsFront;
		List<Wheel> wheelsRear;
			
		Car newCar = new Car(plate, brand,color);			
		
		//afegim les dues rodes davanteres i traseres.
		System.out.println("Rodes davanteres :  ");
		wheelsFront = addCarWheels();
		
		System.out.println("Rodes traseres     :  ");
		wheelsRear = addCarWheels();
				
		newCar.addWheels(wheelsFront, wheelsRear); //Afegeixo les rodes al vehicle
		
		newCar.setTitular(seleccionarTitular());	// Afegeixo el titular al vehicle
		
		//Afegeixo conductors al vehicle
		do {
			// Determino si la llic�ncia permet conduir un cotxe
			conductor = seleccionarConductor();
			if(conductor.getLlicencia().getTipus()!="A"){ 
				newCar.addConductor(conductor); //Afegeixo el conductor al vehicle.
			}else {
				System.out.println("ATENCI� : Aquest conductor no t� llic�ncia per conduir un cotxe");
			}
			
			System.out.print("Vols inserir un altre conductor? (si/no)");			
		}while(Utilitats.siNo());		
						
		//Afegeixo el cotxe al carWorkShop
		carWorkShop.addVehicle(newCar);
		System.out.println("El cotxe "+newCar.getPlate()+" ha estat afegit al CarWorkShop");
				
	}
	
	/**
	 * SeleccionarConductor
	 *  
	 * @param  Conductor
	 * @return conductor
	 */
	public Conductor seleccionarConductor() {
		Conductor conductor;
		int id_titular;
				
		List<Persona> persons = com.vehicles.view.Inici.pController.getPersones();
		
		System.out.print("Vols assignar conductors existents al vehicle?  (si/no) : ");		// Seleccionar un titular dels existens al repositori		
		if(Utilitats.siNo()) {					
			for(int i=0; i<persons.size();i++) {						
				if(persons.get(i) instanceof Conductor) {
					System.out.println("id :"+i+"  -"+persons.get(i).toString());					
				}							
			}
					
			do {
				System.out.print("Selecciona el id del conductor que vols escollir :");
				id_titular = Utilitats.llegirSencer(0, persons.size());
			}while(!(persons.get(id_titular) instanceof Conductor));
					
				conductor =(Conductor) persons.get(id_titular);
		}else {
			// Creo nou conductor i l'afegeixo al repositori.
			conductor = com.vehicles.view.Inici.pController.crearConductor();
			com.vehicles.view.Inici.pController.getPersones().add(conductor);
		}
			
		return conductor;	
	}
	
	/**
	 * seleccionaTitular
	 * 
	 * Selecciona un titular de la llista de titulars existents o
	 * crear un de nou.
	 * 
	 * @return
	 */
	public Titular seleccionarTitular() {
		Titular titular = null;		
		int id_titular;
		
		
		List<Persona> persons = com.vehicles.view.Inici.pController.getPersones();
		
		// Afegeixo titular al vehicle
		System.out.print("Vols assignar un titular existent al vehicle?  (si/no) : ");		// Seleccionar un titular dels existens al repositori
		if(Utilitats.siNo()) {
					
			for(int i=0; i<persons.size();i++) {
						
				if(persons.get(i) instanceof Titular) {
					System.out.println("id :"+i+"  -"+persons.get(i).toString());						
				}							
			}
					
			do {
				System.out.print("Selecciona el id de titular que vols escollir :");
				id_titular = Utilitats.llegirSencer(0, persons.size());
			}while(!(persons.get(id_titular) instanceof Titular));
			
			titular =(Titular) persons.get(id_titular);
								
		}else {
			//Creo un nou titular i l'afegeixo al repositori de persones.
			titular = com.vehicles.view.Inici.pController.crearTitular();
			com.vehicles.view.Inici.pController.getPersones().add(titular);
		}
		
		System.out.print(".Titular assigant al vehicle correctament")
		return titular;
	}
	
	/**
	 * addCarWheels
	 * 
	 * @return	Wheels 	List<Weel>
	 */
	public List<Wheel> addCarWheels() {
				
		Wheel wheelRight;
		Wheel wheelLeft; 
		
		List <Wheel> wheels = new ArrayList<Wheel>();
		
		
		//demanem marca i di�mete de les rodes 
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
	 * demanar dades b�siques del vehicle
	 *  
	 * @return  carDate		String[3] plate,brand,color
	 */
	public String[] requestVehicleDate() {
		String[] carDate = new String[3];
		
		//demanem les dades b�siques del vehicle
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
		
		System.out.print("Matr�cula del vehicle : ");
		
		// Determinem si la matr�cula t� un format correcte
		do {
			plate = Utilitats.llegirString().toUpperCase();		 //demanem la matr�cula
			
			if(!plate.matches("^[0-9]{4}[A-Z]{3}$")) {	//Determinem si el format �s correcte
				iterar=true;
				System.out.println("El format de la matr�cula ha de ser 4 d�gits i 3 lletres.");
				System.out.println("Torna a introduir la matr�cula");
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
