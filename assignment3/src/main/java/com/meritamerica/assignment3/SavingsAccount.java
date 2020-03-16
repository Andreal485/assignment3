package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends BankAccount {
	private Date startDate = new Date();

	public SavingsAccount(double balance, double interestRate, Date startDate) {
		super(balance, interestRate, startDate);
		
	}

	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);
	
	}

	public SavingsAccount(long accountNumber, double balance, double interestRate, Date startDate) {
		super(accountNumber, balance, interestRate, startDate);
		} 
	
	public SavingsAccount(double balance) {
		super(balance);
	}
    public static SavingsAccount readFromString(String accountData) throws ParseException, NumberFormatException{
		String [] lines = accountData.split(",");
		 double balance = Double.parseDouble(lines[1]);
		 double interestRate = Double.parseDouble(lines[2]);
		 long accountNumber = Long.parseLong(lines[0]);
		 Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(lines[3]);
		 SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance, interestRate, startDate);
		 return savingsAccount;
		
}
		
	
    public String writeToString() {
    	StringBuilder accountData = new StringBuilder();
    	SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
    	accountData.append(getBalance()).append(",").append(getInterestRate()).append(",").
    	append(getAccountNumber()).append(",").append(simple.format(startDate));
    	return accountData.toString();
}
    public double futureValue(int years) {
    	double balance = getBalance();
    	
    	return balance * Math.pow(1 + 0.01, 3);
    }



}
