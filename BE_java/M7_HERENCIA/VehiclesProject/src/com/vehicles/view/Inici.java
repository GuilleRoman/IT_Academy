package com.vehicles.view;

import java.text.ParseException;

import com.persones.application.PersonesController;
import com.vehicles.application.Utilitats;
import com.vehicles.application.VehicleController;

public class Inici {
	
	// Inicialitzo les classes controladores.
	public static VehicleController vController = new VehicleController();
	public static PersonesController pController = new PersonesController();
		
	/**
	 * main 
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		menuPrincipal();						
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public static void menuPrincipal() throws Exception {
		int opcio;
		
		//Menú principal vehicles
		do {
			System.out.println("CARWORKSHOP MANAGEMENT -- Menuú Principal --\n");		
			System.out.println("  1.- Gestió de vehicles");
			System.out.println("  2.- Gestió de persones");
			System.out.println("  3.- Mostrar el carWorkShop");			
			System.out.println("  0.- Sortir\n");
			System.out.print("Tria l'opció desitjada [0..2] : ");
			
			opcio = Utilitats.llegirSencer(0,3);
				
			switch(opcio) {
			
				case 0: // Sortir de l'aplicació
					
					System.out.println("Aplicació finalitzada");
					break;
					
				case 1:	// Gestió de vehicles
					menuVehicles();											
					break;
					
				case 2: //Gestió de Persones
					menuPersones();
					break;						
				case 3: // Mostrar tot el carWorkShop
					System.out.println("CARWORKSHOP");
					System.out.println("-- VEHICLES -----------------");
					System.out.println(vController.getCarWorkShop());
					
					System.out.println("-- TITULARS I CONDUCTORS-----");
					System.out.println(pController.persones.getAllPersones());
					
					break;
			}		
		}while(opcio!=0);	
	}
	
	
	/**
	 * MenuVehicles
	 * @throws Exception 
	 */
	public static void menuVehicles() throws Exception {
		int opcio;			 // opció menu principal
		String[] carDate;	// array dades cotxe (plate, brand, color)
		String[] bikeDate; // array dades cotxe (plate, brand, color)
		//Titular titular;
		//Conductor conductor;
		
		//Menú principal vehicles
			do {
				System.out.println("CARWORKSHOP MANAGEMENT -- Gestió de vehicles --\n");		
				System.out.println("  1.- Afegir cotxe");
				System.out.println("  2.- Afegir moto");
				System.out.println("  3.- Mostrar tots els vehicles del CarWorkShop ");			
				System.out.println("  0.- Sortir\n");
				System.out.print("Tria l'opció desitjada [0..3] : ");
				
				opcio = Utilitats.llegirSencer(0,3);
					
				switch(opcio) {
				
					case 0: // Sortir de l'aplicació
						
						System.out.println();
						break;
						
					case 1:	//Afegim Cotxe al carWorkShop
						
						// Demanar dades bàsiqes del vehicle
						carDate = vController.requestVehicleDate();	
						vController.addCar(carDate[0], carDate[1], carDate[2], pController.getPersones()); // Afegim el cotxe al carWorkShop	
						
						/**
						// Afegeixo conductors si escau
						System.out.println("Vols assignar conductors al vehicle?  (si/no) : ");		// Seleccionar un titular dels existens al repositori
						if(Utilitats.siNo()) {
							do {
								conductor = pController.crearConductor();
								System.out.println("Vols afegir més conductors?  (si/no) : ");								
							}while(Utilitats.siNo());							
						}
												
						// Afegeixo el cotxe al repositori
						*/					
						break;
						
					case 2: //Afegim moto al carWorkShop
						
						bikeDate = vController.requestVehicleDate();				 // Demanar dades bàsiqes del vehicle
						vController.addBike(bikeDate[0], bikeDate[1], bikeDate[2]);	// Afegir la Bike al carWorkShop
						break;
								
					case 3:	//mostrem tots els vehicles del carWorkShop	
						
						System.out.println (vController.getCarWorkShop());
						break;								
				}		
			}while(opcio!=0);	
	}
	
	
	/**
	 * 
	 * 
	 * @throws ParseException
	 */
	public static void menuPersones() throws ParseException {
	
	int opcio;
	
	
	//Menú principal vehicles
	do {
		System.out.println("CARWORKSHOP MANAGEMENT  -- Titulars, Conductors -- \n");		
		System.out.println("  1.- Crear Titular");
		System.out.println("  2.- Crear Conductor\n");	
		System.out.println("  3.- consultar Titulars");
		System.out.println("  4.- consultar Conductors\n");
		System.out.println("  5.- Afegir titulars de prova");
		System.out.println("  6.- Afegir Conductors de prova");
		System.out.println("  7.- Mostrar tots els conductors i titulars");
		System.out.println("  0.- Sortir\n");
		System.out.print("Tria l'opció desitjada [0..7] : ");
		
		opcio = Utilitats.llegirSencer(0,7);
			
		switch(opcio) {
		
			case 0: // Sortir de l'aplicació
								
				break;
				
			case 1:	// Crear Titular				
				pController.crearTitular();
				break;				
			case 2: //crear Conductor
				pController.crearConductor();
				break;
			case 3: //consultar titulars
				pController.mostrarTitulars();
				break;
			case 4: //consultar Conductors
				pController.mostrarConductors();
				break;
			case 5: //Afegir titulars de prova
				pController.crearTitularsProva();
				break;
			case 6: //Afegir conductors de prova
				pController.crearConductorsProva();
				break;
			case 7: // mostrar titulars i conductors
				pController.mostrarPersones();
				break;	
		}		
	}while(opcio!=0);	
  }
}