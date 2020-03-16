package com.meritamerica.assignment3;

public class MeritBank {
	private static AccountHolder[] accountHolders = new AccountHolder[100];
	private static int accountHolderIndex = 0;
	private static CDOffering[] cdOfferings = new CDOffering[100];
	private static long nextAccountNumber = 1234567;
	
//	
//	public MeritBank() {
//		this.accountHolders = new AccountHolder[100];
//		this.cdOfferings = new CDOffering[100];
//	
//		this.nextAccountNumber = 1234567;
//		
//	}
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		accountHolders[accountHolderIndex] = accountHolder;
		accountHolderIndex++;
		
	}
	
	public static AccountHolder[] getAccountHolders() { //returns the array of accountHolders
		return  accountHolders;	
	}
	
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		if(cdOfferings == null) {
			return null;
		}
		
		double bestValue = 0;
		int bestIndex = -1;
		
		for (int i = 0; i < cdOfferings.length; i++) {
			if(cdOfferings[i].getInterestRate() > bestValue) {
				bestValue = cdOfferings[i].getInterestRate();
				bestIndex = i;
			}
		}
		
		return cdOfferings[bestIndex];		
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		if(cdOfferings == null) {
			return null;
		}
		CDOffering best = getBestCDOffering(depositAmount);
		
		double secondBestValue = 0;
		int secondBestIndex = -1;		
		
		for (int i = 0; i < cdOfferings.length; i ++) {
			if(cdOfferings[i].getInterestRate() > secondBestValue && !best.equals(cdOfferings[i])) {
				secondBestValue = cdOfferings[i].getInterestRate();
				secondBestIndex = i;
			}
		}
		
		return cdOfferings[secondBestIndex];
		
	} 
	
	public static void clearCDOfferings() {
		cdOfferings = null;     //to clear 
		
	}
	
	public static void setCDOfferings(CDOffering[] offerings) {
		int cdOfferingArraySize = offerings.length;
		cdOfferings = new CDOffering[cdOfferingArraySize];
		for (int i = 0; i < cdOfferingArraySize; i++) {
			cdOfferings[i] = offerings[i];
		}
	}
	
	public static long getNextAccountNumber() {
		nextAccountNumber++;
		return nextAccountNumber;
		
	}
	
	public static double totalBalances() {
		double sum = 0;
		
		for(AccountHolder acctHolder : accountHolders) {
			if(acctHolder == null) {
				break;
			}
			
			
			for(CheckingAccount chkAccountBalance : acctHolder.getCheckingAccounts()) {
				sum += chkAccountBalance.getBalance();
			}
			
			for(SavingsAccount savAccountBalance : acctHolder.getSavingsAccounts()) {
				sum += savAccountBalance.getBalance();
			}
			
			for(CDAccount account : acctHolder.getCDAccounts()) { 
				try {
				sum += account.getBalance();
				} catch (NullPointerException e) {
					System.out.println("Handled null pointer.");
				}
			}
			
		}
	
		return sum;
}
	
	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureValue = presentValue * (Math.pow(1 + presentValue, term));
		return futureValue;
		
	}
}