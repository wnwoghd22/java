package Library;

import java.util.Scanner;

import Library.Account.*;
import Library.fileManager.AccountFileManager;

public class AccountHandler {
	private Scanner sc;
	private Borrower borrower;
	private Account[] accountList;
	private AccountFileManager fm;
	public AccountHandler() {
		borrower = null;
		sc = new Scanner(System.in);
		fm = new AccountFileManager("./Library/data.txt");
	}
	
	/* methods */
	public void write() { fm.WriteFile(); }
	public void Login(String id, String pw) {

	}
	private static void CreateAccount() {
		String id, pw; int choice = 0;

		System.out.print("Account Type? 1 : General, 2 : Student, 3 : Professor, 4 : Librarian > ");
		choice = sc.nextInt();

		System.out.print("ID? : "); id = sc.next();
		do {
			System.out.print("Password? : ");
			pw = sc.next();
		} while(!checkIfValidPw(pw));

		switch(choice) {
		case 1 : //Normal
			break;
		}
	}
	private static boolean checkIfValidPw(String pw) {
		if(pw.length() < 8) {
			System.out.println("Too short! Password should be equal or longer than 8.");
			return false;
		}
		boolean hasDigit = false, hasAB = false;
		for(int i = 0; i< pw.length(); ++i) {
			char c = pw.charAt(i);
			if(c >= '0' && c <= '9') hasDigit = true;
			if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') hasAB = true;
		}
		if(!hasDigit) { 
			System.out.println("No number!");
			return false;
		}
		if(!hasAB) { 
			System.out.println("No alphabets!");
			return false;
		}
		return true;
	}


}