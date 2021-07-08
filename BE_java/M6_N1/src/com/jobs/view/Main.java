package com.jobs.view;

import com.jobs.application.JobsController;
import com.jobs.application.JobsController1;

public class Main {

	
	
	private static JobsController controller = new JobsController();
	private static JobsController1 controller1 = new JobsController1();
	
	public static void main(String[] args) throws Exception {
		
		// Nivell 1
		controller.createBossEmployee("Pepe Boss", "Direcci贸n molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Direcci贸n molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Direcci贸n molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Direcci贸n molona 4", "614266666");
		controller.createManagerEmployee("Pedro ManagerEmployee", "Direcci贸n molona 2", "665226666", 80.0);
				
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("Nivell 1 \nEMPLOYEES: \n" + allEmployees + " \n");
		
		
		//Nivell 2	
		System.out.println("Nivell 2 \n");
		
		//Boss >8000 eur
		controller1.createBossEmployee("Pere Boss", "Direcci贸n molona", "666666666", 7100.0);//error per baix
		controller1.createBossEmployee("Pere Boss", "Direcci贸n molona", "666666666", 8100.0);
		
		//Voluntari no cobra
		controller1.createVolunteer("Josep Volunteer", "Direcci贸n molona 4", "614266666",900.25);//error voluntari amb sou
		controller1.createVolunteer("Josep Volunteer", "Direcci贸n molona 4", "614266666",0);
		
		//Junior 900-1600 eur.
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 1800);// error per dalt
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 800);// error per baix
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 1300);
		
		//Mid  1800-2500 eur.
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 2550);// error per dalt
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 1700);// error per baix
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 1920);
		
		//Senior 2700-4000 eur.
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 4001);//error per dalt
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 2600);//error per baix
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 3600);
		
		//Manager 3000-5000 eur.
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 5020.0);//error per dalt
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 2970.0);//error per baix
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 3000.0);
		
		
		controller1.payAllEmployeers();
		
		String allEmployees1=controller1.getAllEmployees();
		
		System.out.println("EMPLOYEES: \n" + allEmployees1+ " \n");	
		
	}
}
