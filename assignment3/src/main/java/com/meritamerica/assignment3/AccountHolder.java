package com.meritamerica.assignment3;


public class AccountHolder implements Comparable<AccountHolder> {

	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String ssn = "";
	
	private CheckingAccount[] checkingAccounts;
	private int numOfCheckingAccounts;
	private SavingsAccount[] savingsAccounts;
	private int numOfSavingsAccounts;
	private CDAccount[] cdAccounts;
	private int numOfCDAccounts;
	
	public AccountHolder() {}

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		// setting the attributes to the value from the constructor parameters
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.numOfCheckingAccounts = 0;
		this.checkingAccounts = new CheckingAccount[1];
		this.numOfSavingsAccounts = 0;
		this.savingsAccounts = new SavingsAccount[1];
		this.numOfCDAccounts = 0;
		this.cdAccounts = new CDAccount[1];
	}
	public AccountHolder(String firstName, String middleName, String lastName, String ssn, int numOfCheckingAccounts,
			CheckingAccount[] checkingAccounts, int numOfSavingsAccounts, SavingsAccount [] savingsAccounts,
			int numOfCDAccounts, CDAccount[] cdAccounts) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.numOfCheckingAccounts = numOfCheckingAccounts;
		this.checkingAccounts = new CheckingAccount[numOfCheckingAccounts];
		this.numOfSavingsAccounts = numOfSavingsAccounts;
		this.savingsAccounts = new SavingsAccount[numOfSavingsAccounts];
		this.numOfCDAccounts = numOfCDAccounts;
		this.cdAccounts = new CDAccount[numOfCDAccounts];
	}
	
	public CheckingAccount addCheckingAccount(double openingBalance, double interestRate) {
		CheckingAccount tempAccount = new CheckingAccount(openingBalance, interestRate);
		addCheckingAccount(tempAccount);
		return tempAccount;
	}
	public CheckingAccount addCheckingAccount(double openingBalance) {
		CheckingAccount tempAccount = new CheckingAccount(openingBalance);
		addCheckingAccount(tempAccount);
		return tempAccount;
	}
	
	public void addCheckingAccount(CheckingAccount checkingAccount) {
		if(getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() >= 250000) {
			System.out.println("Unable to create a new account, balance is too high.");
			
		}
		
		int currentArrayLimit = this.numOfCheckingAccounts;
		CheckingAccount[] temp = new CheckingAccount[currentArrayLimit + 1];
		
		for(int i=0; i<currentArrayLimit; i++) {
			temp[i] = this.checkingAccounts[i];
		}
		
		temp[currentArrayLimit] = checkingAccount;
		this.numOfCheckingAccounts ++;
		this.checkingAccounts = temp;
		
	}
	
	public SavingsAccount addSavingsAccount(double openingBalance, double interestRate) {
		SavingsAccount tempAccount = new SavingsAccount(openingBalance,  interestRate);
		 addSavingsAccount(tempAccount);
		 return tempAccount;
	}
	public SavingsAccount addSavingsAccount(double openingBalance) {
		SavingsAccount tempAccount = new SavingsAccount(openingBalance);
		addSavingsAccount(tempAccount);
		return tempAccount;
	}
	public void addSavingsAccount(SavingsAccount savingsAccount) {
		if(getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance() >= 250000 ) {
			System.out.println("Unable to create account. Balance too high.");
			
			
		}
		 int currentArrayLimit = this.numOfSavingsAccounts;
		 SavingsAccount[] temp = new SavingsAccount[currentArrayLimit + 1];
		 
		 for(int i = 0; i < currentArrayLimit; i++) {
			 temp[i] = this.savingsAccounts[i];
		 }
		 
		 temp[currentArrayLimit] = savingsAccount;
		 this.numOfSavingsAccounts++;
		 this.savingsAccounts = temp;
	}

	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		CDAccount tempAccount = new CDAccount(offering, openingBalance);
		 return addCDAccount(tempAccount);
		
	}
		
		public CDAccount addCDAccount(CDAccount cdAccount) {
			if(cdAccount == null) {
				System.out.println("Unable to find account.");
			}
		
		int currentArrayLimit = this.numOfCDAccounts;
		CDAccount [] temp = new CDAccount[currentArrayLimit + 1];
		
		for (int i = 0; i < currentArrayLimit; i++) {
			temp[i] = this.cdAccounts[i];
		}
		
		temp[currentArrayLimit] = cdAccount;
		this.numOfCDAccounts++;
		this.cdAccounts = temp;
		return cdAccount;
	}


	
	// create getters and setters for retrieving and updating the value of the
	// variables
	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String name) {
		this.firstName = name;

	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String midName) {
		this.middleName = midName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lstName) {
		this.lastName = lstName;
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String SSN) {
		this.ssn = SSN;

	}

	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}
	
	public SavingsAccount[] getSavingsAccounts() {
		return this.savingsAccounts;
	}
	
	public CDAccount[] getCDAccounts() {
		return this.cdAccounts;
	}

	public int getNumberOfCheckingAccounts() {
		return this.numOfCheckingAccounts;
	}
	
	public int getNumberOfSavingsAccounts() {
		return this.numOfSavingsAccounts;

	}
	
	public int getNumberOfCDAccounts() {
		return this.numOfCDAccounts;

	}
	
	public double getCheckingBalance() { // iterate over array of checking accounts to find the total sum of the accounts
		double sums = 0;
		
		for (int i = 0; i < this.numOfCheckingAccounts; i++) {
			sums += this.checkingAccounts[i].getBalance();
		}
		return sums;
	}
	
	public double getSavingsBalance() {
		double savAccSums = 0;
		
		for (int i = 0; i  < this.numOfSavingsAccounts; i++) {
			savAccSums += this.savingsAccounts[i].getBalance();
		}
		
		return savAccSums;
				
	}
	
	public double getCDAccountsBalance() {
		if(this.cdAccounts[0] == null) {
			return 0;
		}
		double cdAccSums = 0;
		
		for (int i = 0; i < this.cdAccounts.length; i++) {
			cdAccSums += this.cdAccounts[i].getBalance();
		}
		
		return cdAccSums;
		
	}
	
	public double getCDBalance() {
	return getCDAccountsBalance();
}
	
	public double getCombinedBalance() {
		double accountSums = getCheckingBalance();
		accountSums += getCDAccountsBalance();
		accountSums += getSavingsBalance();
		return accountSums;
	}

	@Override
	public String toString() {
		return ("Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\nSSN: " + this.ssn + "\n"
				+ checkingAccounts[0].toString() + "\n" + savingsAccounts[0].toString());

	}


	@Override
	public int compareTo(AccountHolder otherAccount) {
		int sum1 = (int) getCombinedBalance();
		int sum2 = (int)otherAccount.getCombinedBalance();
		return sum1 - sum2;
	}
	
	public String writeToString() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName).append(",").append(middleName).append(",")
		.append(lastName).append(",").append(ssn).append(",").append(checkingAccounts.length)
		.append(",");
		for (int i = 0; i < checkingAccounts.length; i++) {
			builder.append(checkingAccounts[i].writeToString()).append(",");
		}
		builder.append(savingsAccounts.length).append(",");
		for (int i = 0; i < savingsAccounts.length; i++) {
			builder.append(savingsAccounts[i].writeToString()).append(",");
		}
		builder.append(cdAccounts.length).append(",");
		for (int i = 0; i < cdAccounts.length; i++) {
			builder.append(cdAccounts[i].writeToString()).append(",");
		}
		
		return builder.toString();
	}
	public static AccountHolder readFromString(String accountData)throws Exception  {
		String [] lines = accountData.split(",");
		String firstName = lines[0];
		String middleName = lines[1];
		String lastName = lines[2];
		String ssn = lines[3];
		int x;
		int numOfCheckingAccounts = Integer.parseInt(lines[4]);
		CheckingAccount [] checkingAccounts = new CheckingAccount[numOfCheckingAccounts];
		for(int i = 0; i <numOfCheckingAccounts; i++) {
			x = 5;
			checkingAccounts[i] = CheckingAccount.readFromString(lines[x]);
			x++;
		}
		int numOfSavingsAccounts = Integer.parseInt(lines[5+numOfCheckingAccounts]);
		SavingsAccount[] savingsAccounts = new SavingsAccount[numOfSavingsAccounts];
		for (int i = 0; i > numOfSavingsAccounts; i++) {
			x = 6+numOfCheckingAccounts;
			savingsAccounts[i] = SavingsAccount.readFromString(lines[x]);
			x++;
		}
		int numOfCDAccounts = Integer.parseInt(lines[+numOfCheckingAccounts + numOfSavingsAccounts]);
		CDAccount [] cdAccounts = new CDAccount[numOfCDAccounts];
		for (int i = 0; i < numOfCDAccounts; i++) {
			x =  7 + numOfCheckingAccounts + numOfSavingsAccounts;
			cdAccounts[i] = CDAccount.readFromString(lines[x]);
			x++;
		}
		AccountHolder accountHolder = new AccountHolder(firstName, middleName, lastName, ssn, 
				numOfCheckingAccounts, checkingAccounts, numOfSavingsAccounts, savingsAccounts, numOfCDAccounts,
				cdAccounts);
		return accountHolder;
	}

	
}
