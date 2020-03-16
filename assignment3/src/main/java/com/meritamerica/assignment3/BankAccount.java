package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount  {
	private double balance = 0;
	private double interestRate = 0;
	private Date startDate = null;
	private long accountNumber = 0;
	private double futureValue = 0;
	

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public Date getOpenedOn() {
		return startDate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public BankAccount(double balance) {
		this.balance = balance;
	}

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public BankAccount(double balance, double interestRate, Date startDate ) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.startDate = startDate; 
	}
	public BankAccount(long accountNumber, double balance, 
			double interestRate, Date startDate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.startDate = startDate;	
	}
	
	public double futureValue(int term){
        futureValue  = balance * (Math.pow( (1+ .0001), term));
        return futureValue;

    }
	
	public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Unable to process transaction.");
            return false;

        } else {
            balance -= amount;
            System.out.println("The transaction was a success! Your new balance is:" + balance);
            return true;
        }
        
	}
	//allows for an amount to  be deposited into the account, as long as amount is not negative
	
    public boolean deposit(double amount){
        if (amount <= 0) {
            System.out.println("Unable to process transaction.");
            return false;

        } else {
            balance += amount;
            System.out.println("The transaction was a success! Your new balance is:" + balance);
            return true;
	
        }
    }
    
    
    public static BankAccount readFromString(String accountData) throws ParseException, NumberFormatException{
    			String [] lines = accountData.split(",");
    			 double balance = Double.parseDouble(lines[0]);
    			 double interestRate = Double.parseDouble(lines[1]);
    			 long accountNumber = Long.parseLong(lines[2]);
    			 Date startDate = new SimpleDateFormat("dd/mm/yyyy").parse(lines[3]);
    			 BankAccount bankAccount = new BankAccount(accountNumber, balance, interestRate, startDate);
    			 return bankAccount;
    			
    }
				
			
    public String writeToString() {
    	StringBuilder accountData = new StringBuilder();
    	SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
    	accountData.append(balance).append(",").append(interestRate).append(",").
    	append(accountNumber).append(",").append(simple.format(startDate));
    	return accountData.toString();
    }
    
    
}
    

