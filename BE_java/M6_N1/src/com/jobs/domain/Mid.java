package com.jobs.domain;

public class Mid extends Employee{
	
	public Mid(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
	}

	
	@Override
	public String toString() {
		return "Mid       [name : " + name + "  address : " + address + "  phone : "+ phone +"  salaryPerMonth : " + salaryPerMonth + "  totalPaid=" + totalPaid + "]";
	}
	
}
 