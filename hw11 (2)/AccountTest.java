import java.util.*;

public class AccountTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		General a1 = new General();
	    Saving a2 = new Saving();
		int count = 0;
		int x,x1;
		double x2,x3;
		
		do{
			System.out.print("Account : General(1), Saving(2) : ");
				do{
					x = sc.nextInt();
					if(x==1){
						System.out.print("Deposit(1), Withdraw(2), Transfer(3) : ");
						do{
							x1 = sc.nextInt();
							if(x1==1){
								System.out.print("Amount : ");
								x2 = sc.nextDouble();
								a1.deposit(x2);
							}
							else if(x1==2){
								System.out.print("Amount : ");
								x2 = sc.nextDouble();
								a1.withdraw(x2);		
							}
							else if(x1==3){
								System.out.print("Amount to transfer: ");
								x2 = sc.nextDouble();
								x3 = a1.transfer(x2);
								a2.deposit(x3);		
							}
							System.out.println("General: ");
							System.out.println("Account : "+a1.getAccountNumber());
							System.out.println("Last transaction date : "+a1.date.toString());
							System.out.printf("Balance : %.0f\n", a1.getBalance());
							System.out.println();
							System.out.println("Saving: ");
							System.out.println("Account : "+a2.getAccountNumber());
							System.out.println("Last transaction date : "+a2.date.toString());
							System.out.printf("Balance : %.0f\n", a2.getBalance());
						}while(x1!=1 && x1!=2 && x1!=3);
					}
					else if(x==2){
						System.out.print("Deposit(1), Withdraw(2), Transfer(3), Interest Rate Change(4), Fee Rate Change(5) : ");
						do{
							x1 = sc.nextInt();
							if(x1==1){
								System.out.print("Amount : ");
								x2 = sc.nextDouble();
								a2.deposit(x2);
							}
							else if(x1==2){
								System.out.print("Amount : ");
								x2 = sc.nextDouble();
								a2.withdraw(x2);		
							}
							else if(x1==3){
								System.out.print("Amount to transfer: ");
								x2 = sc.nextDouble();
								x3 = a2.transfer(x2);
								a1.deposit(x3);		
							}
							else if(x1==4){
								System.out.print("Interest Rate : ");
								x2 = sc.nextDouble();
								a2.interestRateChange(x2);
							}
							else if(x1==5){
								System.out.print("Fee Rate : ");
								x2 = sc.nextDouble();
								a2.feeRateChange(x2);
							}
							System.out.println("General: ");
							System.out.println("Account : "+a1.getAccountNumber());
							System.out.println("Last transaction date : "+a1.date.toString());
							System.out.printf("Balance : .0f\n", a1.getBalance());
							System.out.println();
							System.out.println("Saving: ");
							System.out.println("Account : "+a2.getAccountNumber());
							System.out.println("Last transaction date : "+a2.date.toString());
							System.out.printf("Balance : .0f\n", a2.getBalance());
						}while(x!=1 && x!=2 && x!=3 && x!=4 && x!=5);
					}	
				}while(x!=1 && x!=2);
	
			count++;
		}while(count<15);
		
	}
}