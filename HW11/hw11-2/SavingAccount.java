public class SavingAccount extends Account {
	private double interRate;
	private double feeRate;

	SavingAccount() {
		super();
		interRate = 0.035; feeRate = 0.01;
	}
	@Override
	public void Deposit(int amount) {
		amount = (int)(amount * (1 + interRate));
		super.Deposit(amount);
	}
	@Override
	public int Withdraw(int amount) {
		int addFee =  (int)(amount * (1 + feeRate));
		super.Withdraw(addFee);
		return amount;
	}
	@Override
	public void Transfer(Account a, int amount) {
		a.Deposit(Withdraw(amount));
	}
	@Override
	public void ShowInfo() {
		System.out.println("Saving : ");
		super.ShowInfo();
	}
	public void setInterRate(double r) { interRate = r; }
	public void setFeeRate(double r) { feeRate = r; }
}