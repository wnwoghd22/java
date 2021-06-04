package Library;

import java.io.*;
import java.util.*;
import Library.fileManager.*;

public class Library {
	private static AccountHandler aH;
	private static BookHandler bH;
	private static void writeFile() { aH.write(); bH.write(); }

	private static Scanner sc;

	public static void main(String args[]) {
		
		sc = new Scanner(System.in);
		int input = 0; boolean flag = false;

		aH = new AccountHandler();
		bH = new BookHandler();

		aH.getList();
		bH.getList();

		while(true) {
			System.out.print("menu 1 : log in, 2 : create account, 0 : exit > ");
			input = sc.nextInt();
			switch(input) {
				case 1 : login(); break;
				case 2 : aH.CreateAccount(); break;
				case 0 : flag = true;
			}
			if(flag) break;
			
			if(aH.loggedIn()) do; while (UserLoop());
		}
		writeFile();
	}

	private static void login() {
		String id, pw;
		System.out.print("Log-in\nID : ");
		id = sc.next();
		System.out.print("Password : ");
		pw = sc.next();
		aH.Login(id, pw);
	}
	private static boolean UserLoop() {
		boolean result = false;
		System.out.print("choice ? : show info (1), book list (2), exit (0) >");

		int choice = 0;
		do {
			choice = sc.nextInt();
		} while(choice < 0 || choice > 7);

		switch(choice) {
		case 1 : // show info
			aH.ShowInfo();
			break;
		case 2 : //ShowList
			ShowBookList();
			break;
		case 0 : // exit loop
			return false;
		}
		return true;
	}
	private static void ShowBookList() {
		List<String> list = bH.ShowList(0);
		
		int choice = 0;
		do  {
			System.out.print("View book Detail (1 ~ " + list.size() +
			"), Next 10 books (11), Previous 10 books (12), return to menu (0) >");
			choice = sc.nextInt();

			if(choice == 11) { list = bH.ShowList(false); continue; }
			if(choice == 12) { list = bH.ShowList(true); continue; }
			if(choice == 0) break;
			
			if(choice >= 1 && choice <= list.size()) {
				String b_id = bH.getBook(list.get(choice - 1)).getB_id();
				bH.ShowInfo();
				do {
					System.out.print("Borrow (1), Back to List (2), return to menu (0) : ");
					choice = sc.nextInt();
				} while ( choice < 0 || choice > 2);
				if(choice == 2) { list = bH.ShowList(); continue; }
				if(choice == 0) continue;
				if(choice == 1) { //borrow
					aH.Borrow(bH.Lend(b_id));
					break;
				}
			}
		} while(true);
	}
	
	private static void TestIO() {

		aH = new AccountHandler();
		bH = new BookHandler();

		aH.getList();
		bH.getList();

		aH.CreateAccount();

		bH.AddBook();

		writeFile();
	}
}