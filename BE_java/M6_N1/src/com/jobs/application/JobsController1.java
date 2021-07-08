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
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		try {
			if(salaryPerMonth<8000) {
				throw new RuntimeException("El sou ha de ser major a 8000 eur.");
			}else {
				Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
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
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
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
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<3000 || salaryPerMonth>5000) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 3000 i 5000 eur.");
			}else {
				Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
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
	public void createVolunteer(String nom, String address, String phone, double salary) throws Exception {		
		try {
			if(salary>0) {
				throw new RuntimeException("Els voluntaris no cobren sou ");
			}else {		
				Volunteer voluntari = new Volunteer(nom,address,phone,salary);
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
	public void createJunior(String name, String address, String phone, double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<900 || salaryPerMonth>1600) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 900 i 1600 eur.");
			}else {
				Junior boss= new Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
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
	public void createMid(String name, String address, String phone, double salaryPerMonth) throws Exception{
		try {
			if(salaryPerMonth<1800 || salaryPerMonth>2500) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 900 i 1600 eur.");
			}else {
				Mid boss = new Mid (name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMid());
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
	public void createSenior(String name, String address, String phone, double salaryPerMonth) throws Exception{
		
		try {
			if(salaryPerMonth<2700 || salaryPerMonth>4000) {
				throw new RuntimeException("El seu sou ha d'estar comprès entre 2700 i 4000 eur.");
			}else {
				Senior boss= new Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
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
			   employees+=llistat.get(i).toString()+"\n";			   
		}
		
		return employees;
	}	
}
