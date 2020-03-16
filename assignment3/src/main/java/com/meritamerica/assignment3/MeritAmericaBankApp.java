package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		//MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		SavingsAccount sv = new SavingsAccount(150.0, 15.0);
		System.out.println(sv.getInterestRate());
	}
}