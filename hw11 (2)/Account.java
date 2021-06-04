public abstract class Account{
	private String accountNumber = "";
	int k;
	int length = 0;
	double balance = 0;
	java.util.Date date;

	public Account(){
		do{
			k = (int)(Math.random()*10);
			accountNumber += k;
		}while(length<6);
	}
	abstract void deposit(double money);
	abstract void withdraw(double money);
	abstract double transfer(double money);
	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
}
class General extends Account{
	private String accountNumber = "";
	double balance = 0;
	java.util.Date date;
	General(){
		accountNumber = super.getAccountNumber();
	}
	public void deposit(double money){
		balance += money;
		date = new java.util.Date();
	}
	public void withdraw(double money){
		if(balance-money<0) 
			System.out.println("You cannot withdraw money.");
		else
			balance -= money;
		date = new java.util.Date();
	}
	public double transfer(double money){
		if(balance-money<0) 
			System.out.println("You cannot transfer money.");
		else
			balance -= money;
		date = new java.util.Date();
		return money;
	}	
}
class Saving extends Account{
	private String accountNumber = "";
	double balance = 0;
	double rate1 = 0.035;
	double rate2 = 0.01;
	java.util.Date date;

	Saving(){
		accountNumber = super.getAccountNumber();
	}
	public void deposit(double money){
		balance += money*(1+rate1);
		date = new java.util.Date();
	}
	public void withdraw(double money){
		if(balance-money<0) 
			System.out.println("You cannot withdraw money.");
		else
			balance -= money*(1+rate2);
		date = new java.util.Date();
	}
	public double transfer(double money){
		if(balance-money<0) 
			System.out.println("You cannot transfer money.");
		else
			balance -= money*(1+rate2);
		date = new java.util.Date();
		return money;
	}
	public void interestRateChange(double rate){
		rate1 = rate;
		date = new java.util.Date();
	}
	public void feeRateChange(double rate){
		rate2 = rate;
		date = new java.util.Date();
	}
}