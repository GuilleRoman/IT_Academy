package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;
		
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		this.description = "no cobra ";
		
	}

	
	@Override
	public void pay() {
		totalPaid = 0;		
	}


	@Override
	public String toString() {
		return "Volunteer [Name : "+name+" Address : "+address+" Phone : "+phone+" description=" + description +" totalP : "+ totalPaid +"]";				
	}

	
}
