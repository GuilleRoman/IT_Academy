package com.jobs.view;


import com.jobs.application.JobsController1;

public class Main {

	
	private static JobsController1 controller1 = new JobsController1();
	
	public static void main(String[] args) throws Exception {		
		
		System.out.println("Nivell 3 \n");
		
		//Boss >8000 eur   IRPF: 35%		
		controller1.createBossEmployee("Pere Boss", "Direcci贸n molona", "666666666", 32, 7100.0);	//error
		controller1.createBossEmployee("Pere Boss", "Direcci贸n molona", "666666666", 32, 8100.0);		
				
		//Junior 900-1600 eur.   IRPF: 2%
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 2, 300.0);	//error
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 2, 1604.0);	//error
		controller1.createJunior("Joan Junior", "Adre鏰 Junior", "987654321", 2, 1300.0);
		
		//Mid  1800-2500 eur.    IRPF: 15%
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 15, 1720.0);	//error
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 15, 2520.0);	//error
		controller1.createMid("Natalia Mid", "Adre鏰 Mid", "123456789", 15, 1920.0);
		
		//Senior 2700-4000 eur.   IRPF: 24%
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 24, 2600.0);	//error
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 24, 4020.0);	//error
		controller1.createSenior("Anna Senior", "Adre鏰 Senior", "123456789", 24, 3600.0);
		
		//Manager 3000-5000 eur.   IRPF: 26%
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 26, 2900.0);	//error
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 26, 5001.0);	//error
		controller1.createManagerEmployee("Pep Manager", "Direcci贸n molona 2", "665226666", 26, 3000.0);
		
		//Voluntari no cobra    IRPF: 0%
		controller1.createVolunteer("Josep Volunteer", "Direcci贸n molona 4", "614266666",0,320);	// error en l'ajuda
		controller1.createVolunteer("Josep Volunteer", "Direcci贸n molona 4", "614266666",10,320);	// error en l'ajuda i el sou
		controller1.createVolunteer("Carme Volunteer", "Direcci贸n molona 4", "614266666",0,220);
		
		
		//Apliquem els canvis en el sou
		controller1.payAllEmployeers();
		
		//Recollim els empleats i voluntaris
		String allEmployees1=controller1.getAllEmployees();
		
		//Mostrem els empleats i voluntaris
		System.out.println("EMPLOYEES: \n" + allEmployees1+ " \n");	
		
		//Apliquem el bonus del 10 % per a tots els treballadors			
		System.out.println("EXECUTEM EL BONUS DEL 10%");
		controller1.bonus10();
		
		
	}
}
