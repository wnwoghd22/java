import java.util.Scanner;

public class Test{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		SavingAccount saving = new SavingAccount();
		Account[] list = new Account[] {
			new GeneralAccount(),
			saving
		};
		boolean flag; int input1, input2;
		for(int i = 0; i < 15; ++i) {
			System.out.print("Account : General(1), Saving(2) : ");
			input1 = sc.nextInt();
			switch (input1) {
			case 1 : //general
				System.out.print("Deposit(1), Withdraw(2), Transfer(3) : ");
				break;
			case 2 : //saving
				System.out.print("Deposit(1), Withdraw(2), Transfer(3), Interest Rate Change(4), Fee Rate Change(5) : ");
				break;
			default :
				break;
			}
			input2 = sc.nextInt(); int amount;
			switch(input2) {
			case 1 : //deposit
				System.out.print("Amount : ");
				amount = sc.nextInt();
				list[input1 - 1].Deposit(amount);
				break;
			case 2 : //withdraw
				System.out.print("Amount : ");
				amount = sc.nextInt();
				list[input1 - 1].Withdraw(amount);
				break;
			case 3 : //transfer
				System.out.print("Amount to transfer : ");
				amount = sc.nextInt();
				System.out.print("Account to transfer : ");
				String to = sc.next();
				Account target = null;
				for(int j = 0; j < list.length; ++j) {
					if(list[j].getNum().equals(to)) {
						target = list[j];
						break;
					}
				}
				if(target != null) list[input1 - 1].Transfer(target, amount);
				else System.out.println("No such account!");
				break;
			case 4 : //interest rate
				if(input1 == 1) break;
				System.out.print("Interest Rate : ");
				saving.setInterRate(sc.nextDouble() / 100);
				break;
			case 5 : //fee rate
				if(input1 == 1) break;
				System.out.print("Fee Rate : ");
				saving.setFeeRate(sc.nextDouble() / 100);
				break;
			}
			System.out.println("\nCurrent Account Status\n");
			for(int j = 0; j < list.length; ++j) {
				list[j].ShowInfo();
				System.out.println("");
			}
		}
	}
}