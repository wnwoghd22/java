public class Account{
	private String accNum;
	private int balance;
	private java.time.LocalDate last;

	private static String GenNum(int n) {
		String result = "";
		for(int i = 0; i < n; ++i)
			result += (int)(Math.random() * 10);
		return result;
	}
	Account() {
		accNum = GenNum(6);
		balance = 0;
		last = java.time.LocalDate.now();
	}
	
	public void Deposit(int amount) { 
		if(amount == 0) return;
		last = java.time.LocalDate.now();
		balance += amount;
	}
	public int Withdraw(int amount) {
		if(amount > balance) {
			System.out.println("Have tried withdraw Over balance\n");
			return 0;
		}
		last = java.time.LocalDate.now();
		balance -= amount;
		return amount;
	}
	public String getNum() { return accNum; }
	public void Transfer(Account a, int amount) {
		a.Deposit(Withdraw(amount));
	}

	public void ShowInfo() {
		java.text.DecimalFormat formatter = new java.text.DecimalFormat("###,###");
		System.out.println("Account : " + accNum);
		System.out.printf("Last transaction date : %4d/%2d/%2d\n", last.getYear(), last.getMonthValue(), last.getDayOfMonth());
		System.out.println("Balance : " + formatter.format(balance));
	}
}