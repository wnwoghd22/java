package Library;

import java.io.*;
import java.util.*;
import Library.fileManager.*;

public class Library {
	private static AccountHandler aH;
	private static BookHandler bH;
	private static void writeFile() { aH.write(debug); bH.write(debug); }

	/* declared for avoid repetitve object constructing */
	private static Scanner sc;
	
	/*
	 * adminMode : if args has keyword "-admin", main stream changes into administrator mode.
	 * in this mode, only librarian account can add or delete book.
	 * debug : only for developers, if true, print some variables and file I/O results on console.
	 */
	private static boolean adminMode, debug;

	public static void main(String args[]) {

		/* if args contains only "help" */
		if(args.length == 1 && args[0].equals("help")) {
			Help(); return;
		}

		boolean printAlist = false, printBlist = false;
		adminMode = false; debug = false;

		for(String s : args) { // args check
			if(s.equals("-al")) { printAlist = true; continue; }
			if(s.equals("-bl")) { printBlist = true; continue; }
			if(s.equals("-admin")) { adminMode = true; continue; }
			if(s.equals("-debug")) { 
				debug = true; printAlist = true; printBlist = true;
				continue;
			}
		}

		aH = new AccountHandler();
		bH = new BookHandler();

		aH.getList(printAlist);
		bH.getList(printBlist);

		sc = new Scanner(System.in);

		if(!adminMode) MainLoop();
		else AdminLoop(); // if got -admin argument, it goes into admin mode.
		
		writeFile();
	}
	private static void MainLoop() {
		int input = 0; boolean flag = false;

		while(true) {
			do { //input range check, doesn't check if got NaN value
				System.out.print("menu 1 : log in, 2 : create account, 0 : exit > ");
				input = sc.nextInt();
			} while (input < 0 || input > 2); 
			switch(input) {
				case 1 : login(); break;
				case 2 : aH.CreateAccount(); break;
				case 0 : 
					aH.logout();
					flag = true;
			}
			if(flag) break;
			
			if(aH.loggedIn()) do; while (UserLoop()); /* infinite loop while UserLoop returns false */
		}
	}
	private static void AdminLoop() {
		int input = 0; boolean flag = false;

		while(true) {
			do { //input range check, doesn't check if got NaN value
				System.out.print("menu 1 : log in, 0 : exit > ");
				input = sc.nextInt();
			} while (input < 0 || input > 1);
			switch(input) {
				case 1 : login(); break;
				case 0 : flag = true;
			}
			if(flag) break;
			
			if(aH.loggedIn()) do; while (AuthorLoop()); /* infinite loop while AuthorLoop returns false */
		}
		return;
	}
	
	/*
	 * get values from standard IO, and then throw these to Login method of AccountHandler.
	 * if admin mode is true, it checks if account is instanceof Librarian
	 */
	private static void login() {
		String id, pw;
		System.out.print("Log-in\nID : ");
		id = sc.next();
		System.out.print("Password : ");
		pw = sc.next();
		aH.Login(id, pw, adminMode);
	}

	/*
	 * called in condition part of do while() loop
	 * if user choose to exit, then it returns false and loop ends.
	 */
	private static boolean UserLoop() {
		boolean result = false;
		System.out.print("choice ? : show info (1), book list (2), return book (3), exit (0) >");

		int choice = 0;
		do {
			choice = sc.nextInt();
		} while(choice < 0 || choice > 3); //doesn't check if it's NaN

		switch(choice) {
		case 1 : // show info
			aH.ShowInfo();
			break;
		case 2 : //ShowList
			ShowBookList();
			break;
		case 3 : //return book
			ReturnBook();
			break;
		case 0 : // exit loop
			return false;
		}
		System.out.println("------------------------------------------------");

		return true;
	}
	private static void ShowBookList() {
		List<String> list = bH.ShowList(0); //get bookList of user.
		
		int choice = 0;
		do  {
			System.out.print("View book Detail (1 ~ " + list.size() +
			"), Next 10 books (11), Previous 10 books (12), return to menu (0) >");
			choice = sc.nextInt();

			if(choice == 11) { list = bH.ShowList(false); continue; } //previous page
			if(choice == 12) { list = bH.ShowList(true); continue; } //next page
			if(choice == 0) break;
			
			if(choice >= 1 && choice <= list.size()) { //choose one of books
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
	private static void ReturnBook() {
		String[] list = aH.getBookList();
		if(debug) for(String s : list) System.out.println(s);
		if(list == null) return;

		int choice = 0; 
		while (true) {
			do {
				System.out.print("Return Book (1 ~ " + list.length + "), exit(0) > ");
				choice = sc.nextInt();
			} while (choice < 0 || choice > list.length);
 
			if(choice == 0) break;

			bH.ReturnBook(aH.ReturnBook(list[choice - 1]));

			if((list = aH.getBookList()) == null) break;

			System.out.println("------------------------------------------------");
		}
	}
	private static void Help() {
		try {
			sc = new Scanner(new File("./Library/help.txt"));
			while(sc.hasNextLine()) System.out.println(sc.nextLine());
		} catch(Exception e) {
			System.out.println(e);
		}
	}	

	private static boolean AuthorLoop() {
		boolean result = false;
		System.out.print("choice ? : add book(1), delete book(2), exit (0) > ");

		int choice = 0;
		do {
			choice = sc.nextInt();
		} while(choice < 0 || choice > 2);

		switch(choice) {
		case 1 : // add book
			bH.AddBook();
			break;
		case 2 : //delete book
			bH.DeleteBook();
			break;
		case 3 : //return book
			break;
		case 0 : // exit loop
			return false;
		}
		System.out.println("------------------------------------------------");

		return true;
	}
}