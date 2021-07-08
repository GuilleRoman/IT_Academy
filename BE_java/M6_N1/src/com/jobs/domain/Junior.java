package com.jobs.domain;

public class Junior extends Employee {
	
	
	// Constructor
	public Junior (String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);		
	}

	@Override
	public String toString() {
		return "Junior    [name : " + name + "  address : " + address + "  phone : "+ phone +"  salaryPerMonth : " + salaryPerMonth + "  totalPaid=" + totalPaid + "]";
	}
	
}
