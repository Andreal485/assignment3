package com.meritamerica.assignment3;

public class CDOffering {
	//attributes of this class are the interest rate and term
	private int term;
	private double interestRate;
	//constructor for this class taking in an int for the terms in years and a double amount for
	//the interest rate
	public CDOffering(int term, double interestRate) {
		
		this.term = term;
		this.interestRate = interestRate;
	}
	//the getters for our two attributes
	public int getTerm() {
		return term;
	}

	public double getInterestRate() {
		return interestRate;
	}
	public String writeToString() {
		StringBuilder builder = new StringBuilder();
		builder.append(term).append(",").append(interestRate);
		return builder.toString();
	}
	public static CDOffering readFromString(String accountData) {
		String [] lines = accountData.split(",");
		int term = Integer.parseInt(lines[0]);
		double interestRate = Double.parseDouble(lines[1]);
		CDOffering offering = new CDOffering(term, interestRate);
		return offering;
		
	}

}
