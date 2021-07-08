package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);		
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(boss);			
	}

	public void createVolunteer(String nom, String address, String phone) throws Exception {
		Volunteer voluntari = new Volunteer(nom,address,phone);
		repository.addMember(voluntari);
	}
		
	public void payAllEmployeers() {
		List<AbsStaffMember> llistat = repository.getAllMembers();
		
		for(int i=0; i<llistat.size();i++) {			
			llistat.get(i).pay();			   
		}
	
	}

	public String getAllEmployees() {
		String employees="";		
		List<AbsStaffMember> llistat = repository.getAllMembers();
		
		for(int i=0; i<llistat.size();i++) {			
			   employees+=llistat.get(i).toString()+"\n";			   
		}
		
		return employees;
	}

	
	
	
	
}
