package com.jobs.domain;

import java.text.NumberFormat;

public class Employee extends AbsStaffMember {
	
	
	protected double salaryPerMonth;	 //
	protected int irpf; 					//propietat % d'impostos a repercutir 
	protected IPaymentRate paymentRate;
	

	public Employee(String name, String address, String phone,int irpf, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
		
		this.irpf = irpf; // Assignem el percentage d'impostos a imputar
		this.salaryPerMonth = salaryPerMonth;
		this.paymentRate = paymentRate;
	}
	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

	// ---- GETTERS, SETTERS, TOSTRING --------
	
	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	
	
	public int getIrpf() {
		return irpf;
	}

	public void setIrpf(int irpf) {
		this.irpf = irpf;
	}
	
	
	@Override
	public String toString() {
		
		//Establim el format de moneda   (Directament de la masterclass de globalització).
		NumberFormat nfdCurrency = NumberFormat.getCurrencyInstance(); 
		
		// Calculem el sou 
		double souMesNet=totalPaid-(totalPaid*irpf/100);
		
		return "Employee [name: " + name + ", address: "+ address + ", phone: " +phone +
				"\n - salaryPerMonth: " + salaryPerMonth + " irpf=" +irpf+" %"+
				"\n - souMesBrut: " + nfdCurrency.format(totalPaid) +" souMesNet :"+nfdCurrency.format(souMesNet)+
				"\n - souAnyBrut: "+nfdCurrency.format(totalPaid*14)+" souAnyNet :"+nfdCurrency.format(souMesNet*14)+" ]\n\n";
	}	
	
}
