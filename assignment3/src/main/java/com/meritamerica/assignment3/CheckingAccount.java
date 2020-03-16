package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(double balance, double interestRate, Date startDate) {
		super(balance, interestRate, startDate);
		
	}
	public CheckingAccount(long accountNumber, double balance, double interestRate, Date startDate) {
		super(accountNumber, balance, interestRate, startDate);
		
	}
	public CheckingAccount(double balance, double interestRate) {
		super(balance, interestRate);
		
	}
	public CheckingAccount(double balance) {
		super(balance);
	}
	public static CheckingAccount readFromString(String accountData) throws ParseException, NumberFormatException{
		String [] lines = accountData.split(",");
		 double balance = Double.parseDouble(lines[1]);
		 double interestRate = Double.parseDouble(lines[2]);
		 long accountNumber= Long.parseLong(lines[0]);
		 Date date = new SimpleDateFormat("dd/MM/yyyy").parse(lines[3]);
		 CheckingAccount checkingAccount = new CheckingAccount(accountNumber, balance, interestRate, date);
		 return checkingAccount;
		
}
	public Date getOpenedOn() {
		return super.getOpenedOn();
	}
	public double getBalance() {
		return super.getBalance();
	}
	public double getInterestRate() {
		return super.getInterestRate();
	}
	public long getAccountNumber() {
		return super.getAccountNumber();
	}
	@Override
    public String writeToString() {
    	StringBuilder accountData = new StringBuilder();
    	SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
    	accountData.append(super.getBalance()).append(",").append(super.getInterestRate()).append(",").
    	append(super.getAccountNumber()).append(",").append(simple.format(super.getOpenedOn()));
    	return accountData.toString();
    }
    
	
}
