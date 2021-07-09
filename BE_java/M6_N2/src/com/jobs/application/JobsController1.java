package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Junior;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController1 {
	
	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController1(){
		
	}	
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createBossEmployee(String name, String address, String phone, int irpf, double salaryPerMonth) throws Exception{		
		try {
			if(salaryPerMonth<8000) {
				throw new RuntimeException("El sou ha de ser major a 8000 eur.");
			}else {				
				Employee boss = new Employee(name, address, phone,irpf, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
				repository.addMember(boss);
			}
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: el Boss "+name+" (sou :"+salaryPerMonth+" eur) no ha estat creat. ");
			System.out.println(rte.getMessage());
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createEmployee(String name, String address, String phone, int irpf, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone, irpf, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createManagerEmployee(String name, String address, String phone, int irpf,double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<3000 || salaryPerMonth>5000) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 3000 i 5000 eur.");
			}else {
				Employee boss = new Employee(name, address, phone, irpf, salaryPerMonth, PaymentFactory.createPaymentRateManager());
				repository.addMember(boss);
			}
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: l'empleat manager "+name+" (sou :"+salaryPerMonth+" eur. ) no ha estat creat. ");
			System.out.println(rte.getMessage());
		}		
	}

	/**
	 * 
	 * @param nom
	 * @param address
	 * @param phone
	 * @throws Exception
	 */
	public void createVolunteer(String nom, String address, String phone, double salary,double ajuda) throws Exception {		
		try {
			
			if(salary!=0) {  		//Els voluntaris no tenen sou				 
				throw new RuntimeException("Els voluntaris no cobren sou.");
			}else if(ajuda>300){	//L'ajuda gobernamental no pot superar els 300 eur.
				throw new RuntimeException("L'ajuda governamental no pot superar els 300 eur.");
			}else if(ajuda<0){		//L'ajuda gobernamental no pot ser negativa.
				throw new RuntimeException("L'ajuda governamental no pot superar els 300 eur.");			
			}else{		
				Volunteer voluntari = new Volunteer(nom,address,phone,salary,ajuda);
				repository.addMember(voluntari);
			}
			
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: el voluntari "+nom+" (sou :"+salary+" eur. ) no ha estat creat. ");			
			System.out.println(rte.getMessage());
		}		
	}
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createJunior(String name, String address, String phone,int irpf, double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<900 || salaryPerMonth>1600) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 900 i 1600 eur.");
			}else {
				Junior boss= new Junior(name, address, phone,irpf, salaryPerMonth, PaymentFactory.createPaymentRateJunior());
				repository.addMember(boss);
			}
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: l'empleat Junior "+name+" (sou :"+salaryPerMonth+" eur. ) no ha estat creat. ");
			System.out.println(rte.getMessage());
		}	
	}
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createMid(String name, String address, String phone,int irpf, double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<1800 || salaryPerMonth>2500) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 1800 i 2500 eur.");
			}else {
				Mid boss = new Mid (name, address, phone,irpf, salaryPerMonth, PaymentFactory.createPaymentRateMid());
				repository.addMember(boss);
			}
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: l'empleat Mid "+name+" (sou :"+salaryPerMonth+" eur. ) no ha estat creat. ");
			System.out.println(rte.getMessage());
		}	
	}
	
	/**
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param salaryPerMonth
	 * @throws Exception
	 */
	public void createSenior(String name, String address, String phone, int irpf, double salaryPerMonth) throws Exception{
		
		try {
			if(salaryPerMonth<2700 || salaryPerMonth>4000) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 2700 i 4000 eur.");
			}else {
				Senior boss= new Senior(name, address, phone, irpf, salaryPerMonth, PaymentFactory.createPaymentRateSenior());
				repository.addMember(boss);
			}
		}catch(RuntimeException rte) {
			System.out.print(" - ERROR: l'empleat Senior "+name+" (sou :"+salaryPerMonth+" eur. ) no ha estat creat. ");
			System.out.println(rte.getMessage());
		}	
	}
	
	/**
	 * 	
	 */
	public void payAllEmployeers() {
		List<AbsStaffMember> llistat = repository.getAllMembers();
		
		for(int i=0; i<llistat.size();i++) {			
			llistat.get(i).pay();			   
		}
	
	}
	
	/**
	 * 
	 * @return	String	employee list
	 */
	public String getAllEmployees() {
		String employees="";		
		List<AbsStaffMember> llistat = repository.getAllMembers();
		
		for(int i=0; i<llistat.size();i++) {			
			employees+=llistat.get(i).toString();						
		}
		
		return employees;
	}	
	
	
	/**
	 * bonus 10
	 * 
	 * Incrementa un 10 el sou de tots els treballadors.
	 * @throws Exception 
	 * 
	 */
	public void bonus10() throws Exception {
		
		Employee emp=null; 
		List<AbsStaffMember> llistat = repository.getAllMembers();
		
		// Recorrem el List empleat a empleat
		for(int i=0; i<llistat.size();i++) {
			
			  // Si no és un voluntari, que no cobren res	
			  if(!(llistat.get(i) instanceof com.jobs.domain.Volunteer)) {
				  
				  //Determinem la categoria laboral del treballador i fem un casting de tipus
				  switch (llistat.get(i).getClass().getName()) {
				  	
				  	case "com.jobs.domain.Employee":		//casting a Empleat
				  		 emp = (Employee)llistat.get(i);
				  		 break;
				  
				  	case "com.jobs.domain.Junior":			//casting a Junior
				  		 emp = (Junior)llistat.get(i);
				  		 break;
				  	
				  	case "com.jobs.domain.Mid":				//casting a Mid
				  		 emp = (Mid)llistat.get(i);
				  		 break;
				  	
				  	case "com.jobs.domain.Senior":			//casting a Senior
				  		 emp = (Senior)llistat.get(i);
				  		 break;
					
				  	default: 
				  		 throw new Exception ("La classe amb index "+i+" no és un objecte d'empleat");
				  
				  }
				  
				  // Obtenim el salari brut mensual i l'augmentem un 10%.				  
				  double salary = emp.getSalaryPerMonth();
				  salary +=salary*0.10;
				  
				  //Actualitzem el nou salari que inclou el bonus del 10%.
				  emp.setSalaryPerMonth(salary);
				  
				  // Actualitzem la resta de conceptes salarials.
				  emp.pay();
				  
				  //Mostrem les noves dades actualitzades.
				  System.out.println(llistat.get(i).toString());
			  }
		}
		
	}
	
	
	
}
