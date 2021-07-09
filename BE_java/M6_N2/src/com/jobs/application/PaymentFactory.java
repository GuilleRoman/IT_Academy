package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	/**
	 * 
	 * @return
	 */
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	/**
	 * 
	 * @return
	 */
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth-(salaryPerMonth*0.15); 
			}
		};
	}
	
	/**
	 * 
	 * @return
	 */
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.10; 
			}
		};
	}
	
	/**
	 * createPaymentRateJunior
	 * 
	 * 
	 * @return	@return	IPaymentRate	salaryPerMonth*0.15
	 */
	public static IPaymentRate createPaymentRateJunior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth-(salaryPerMonth*0.15); 
			}
		};
	}
	
	/**
	 * createPaymentRateMid
	 * 
	 * 
	 * @return	IPaymentRate	salaryPerMonth*0.10
	 */
	public static IPaymentRate createPaymentRateMid(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth-(salaryPerMonth*0.10); 
			}
		};
	}
	
	/**
	 * createPaymentRateSenior
	 * 
	 * 
	 * @return	IPaymentRate	salaryPerMonth*0.05
	 */
	public static IPaymentRate createPaymentRateSenior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth-(salaryPerMonth*0.05); 
			}
		};
	}
	
}
