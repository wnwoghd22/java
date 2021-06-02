package Library;

import java.io.*;
import java.util.*;
import Library.fileManager.*;

public class Library {
	private static AccountHandler aH;
	private static BookHandler bH;
	private static writeFile() { aH.write(); bH.write(); }

	private static Scanner sc;

	public static void main(String args[]) {
		
		//Test();

		sc = new Scanner(System.in);
		int input = 0;

		aH = new AccountHandler();
		bH = new BookHandler();

		while(true) {
			System.out.println("menu");
			input = sc.nextInt();
			switch(input) {
				case 1 : login(); break;
				case 2 : aH.CreateAccount(); break;
			}
			
		}

		if(aH.loggedIn()) do {
			
		}	
	}

	private static void login() {
		String id, pw;
		System.out.print("Log-in\nID : ");
		id = sc.next();
		System.out.print("Password : ");
		pw = sc.next();
		aH.Login(id, pw);
	}
	private boolean UserLoop() {
		boolean result = false;
		int choice = 0;
		do {

		} while(choice >= 0 && choice <= 
		 sc.nextInt();
		switch(choice) {
		case 1 : // show info
			aH.ShowInfo();
			break;
		}
	}
	private static void Test() {
		System.out.println("execute");
		List<A> list = new ArrayList<A>();
		list.add(new A("a", 1));
		list.add(new A("b", 2));

		for(int i = 0; i < 2; ++i) System.out.println(list.get(i));

		testFM fm = new testFM("./Library/test.txt");
		try{
			fm.WriteFile(list);
		}
		catch(IOException e) {
			System.out.println(e);
		}

		List<A> list2 = null;
		try{
			list2 = fm.ReadFile();
		}
		catch(IOException e) {
			System.out.println(e);
		}
		for(int i = 0; i < 2; ++i)
			System.out.println("name : " + list.get(i).getName() + ", num : " + list.get(i).getNum());
	}
}