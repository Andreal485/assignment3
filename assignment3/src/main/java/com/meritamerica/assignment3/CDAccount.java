package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {
	public CDAccount(double balance, double interestRate, Date startDate) {
		super(balance, interestRate, startDate);
		// TODO Auto-generated constructor stub
	}


	public CDAccount(double balance, double interestRate) {
		super(balance, interestRate);
		// TODO Auto-generated constructor stub
	}
	
	public CDAccount(CDOffering offering, double balance) {
		super(balance, offering.getInterestRate());
		this.term = offering.getTerm();
		
	}
	public double futureValue(){
		double interestRate = getInterestRate();
		double balance = getBalance();
        futureValue = balance * (Math.pow( (1+ interestRate), term));
        return futureValue;

    }


	public CDAccount(long accountNumber, double balance, double interestRate, Date startDate) {
		super(accountNumber, balance, interestRate, startDate);
	
	}
	public CDAccount(long accountNumber, double balance, double interestRate, Date startDate, int term) {
		super(accountNumber, balance, interestRate, startDate);
		this.term = term;
	
	}


	public CDAccount(long accountNumber, double balance, CDOffering offering, Date startDate) {
		super(accountNumber, balance, offering.getInterestRate(), startDate);
		this.term = offering.getTerm();
	}

	//attributes of this class which include a CD offering
	//the term and interest rate are determined by the cd offering so it is necessary to this class
	private long accountNumber;
	private double futureValue;
	private double balance;
	private double interestRate;
	private int term;
	CDOffering offering;
	Date startDate = new Date();
	


	public int getTerm() {
		return term;
	}

	public Date getStartDate() {

		return  startDate;
	}
	@Override
	 public String writeToString() {
	    	StringBuilder accountData = new StringBuilder();
	    	SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy");
	    	accountData.append(balance).append(",").append(interestRate).append(",").
	    	append(accountNumber).append(",").append(simple.format(startDate)).append(",").append(term);
	    	return accountData.toString();
	    }
	    
	    public static CDAccount readFromString(String accountData) throws ParseException, NumberFormatException{
			String [] lines = accountData.split(",");
			 double balance = Double.parseDouble(lines[1]);
			 double interestRate = Double.parseDouble(lines[2]);
			 long accountNumber = Long.parseLong(lines[0]);
			 Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(lines[3]);
			 int term = Integer.parseInt(lines[4]);
			 CDOffering offering = new CDOffering(term, interestRate);
			 CDAccount cdAccount = new CDAccount(accountNumber, balance,offering , startDate );
			 return cdAccount;
	    }	
	    @Override
	     public boolean withdraw(double amount) {
	        return false;
		}
	     @Override
	     public boolean deposit(double amount) {
	    	 return false;
	     }
}
