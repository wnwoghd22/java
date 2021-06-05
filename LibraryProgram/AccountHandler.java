package Library;

import java.util.*;
import java.io.*;

import Library.Account.*;
import Library.Book.*;
import Library.fileManager.AccountFileManager;

public class AccountHandler {
	private Scanner sc;
	private Borrower borrower;
	private List<Account> accountList;
	private AccountFileManager fm;

	public AccountHandler() {
		borrower = null;
		sc = new Scanner(System.in);
		fm = new AccountFileManager("./Library/account_data.txt");
		accountList = new ArrayList<Account>();
	}
	
	/* methods */
	public void write(boolean debug) {
		try { fm.WriteFile(accountList, debug); }
		catch(IOException e) { System.out.println(e); }
	}
	public void getList(boolean print) {
		try {
			accountList = fm.ReadFile();
			if(print) for(Account a : accountList)
				System.out.println(a.getClass() + "	" + a.getId());
		}
		catch(IOException e) { System.out.println(e); }
	}

	public void Login(String id, String pw) {
		for(int i = 0; i < accountList.size(); ++i) {
			if(accountList.get(i).getId().equals(id)) {
				if(checkIfValidPw(pw) && accountList.get(i).getPw().equals(pw)) {
					System.out.println("Log in Complete!");
					borrower = accountList.get(i);
				}
				return;
			}
		}
		System.out.println("No such account!");
	}
	public void CreateAccount() {
		String id, pw; int choice = 0;

		System.out.print("Account Type? 1 : General, 2 : Student, 3 : Professor, 4 : Librarian > ");
		choice = sc.nextInt();

		do { System.out.print("ID? : "); id = sc.next(); } while(checkIfIdExist(id));
		do { System.out.print("Password? : "); pw = sc.next(); } while(!checkIfValidPw(pw));

		switch(choice) {
		case 1 : //Normal
			accountList.add(new Normal(id, pw));
			break;
		case 2 : //Student
			String s_id, major;
			System.out.print("Student ID? : "); s_id = sc.next();
			System.out.print("Major? : "); major = sc.next();
			accountList.add(new Student(id, pw, s_id, major));
			break;
		case 3 : //Professor
			String p_id;
			System.out.print("Employee ID? : "); p_id = sc.next();
			accountList.add(new Professor(id, pw, p_id));
			break;
		case 4 : //Librarian
			String l_id;
			System.out.print("Employee ID? : "); l_id = sc.next();
			accountList.add(new Librarian(id, pw, l_id));
			break;
		}
	}
	private boolean checkIfIdExist(String id) {
		for(int i = 0; i < accountList.size(); ++i)
			if(accountList.get(i).getId().equals(id)) {
				System.out.println("ID already exist!");
				return true;
			}
		return false;
	}
	private boolean checkIfValidPw(String pw) {
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
	public boolean loggedIn() { return borrower != null; }
	public void ShowInfo() { borrower.ShowInfo(); }

	public void Borrow(Book b) {
		if(b != null) borrower.Borrow(b.getB_id(), b.getName());
	}
}