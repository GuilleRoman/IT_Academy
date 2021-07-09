package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;
	protected double ajutGovern; //ajut gobernamental de màxim 300 eur.
		
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		this.description = "no cobra ";
		this.ajutGovern = 0;	
	}

	public Volunteer(String name, String address, String phone,double salary,double ajuda) throws Exception {
		super(name, address, phone);
		this.description = "no cobra ";
		this.totalPaid = salary;
		this.ajutGovern = ajuda;		
	}	
	
	@Override
	public void pay() {
		totalPaid =0;		
	}


	
	public String toString() {
		return "Volunteer [Name : "+name+" Address : "+address+" Phone : "+phone+" description : " + description +
				"ajuda governamental : "+ajutGovern+" totalPaid : "+ totalPaid +"]\n";				
	}

	
}
