package Library;

import java.util.*;
import java.io.*;

import Library.Book.*;
import Library.fileManager.BookFileManager;

public class BookHandler {
	private Scanner sc;
	private List<Book> bookList;
	private BookFileManager fm;

	public BookHandler() {
		fm = new BookFileManager("./Library/book_data.txt");
		sc = new Scanner(System.in);
		bookList = new ArrayList<Book>();
	}
	
	/* methods */
	public void write() { 
		try { fm.WriteFile(bookList); }
		catch(IOException e) { System.out.println(e); }
	}
	public void getList() {
		try { bookList = fm.ReadFile(); }
		catch(IOException e) { System.out.println(e); }
	}

	public Book AddBook() {
		int type = 0, num;
		String b_id, name, description;
		do {
			System.out.print("Book type? 1 : General, 2 : Journal, 3 : Ebook > ");
			type = sc.nextInt();
		} while (type < 1 || type > 3);

		System.out.print("Book ID ? "); b_id = sc.next();
		System.out.print("Book Name ? "); name = sc.next();
		sc.nextLine(); //consume extra \n character
		
		switch(type) {
		case 1 : // General
			System.out.print("Book Description ? "); description = sc.nextLine();
			do { System.out.print("How many books ? "); num = sc.nextInt(); } while (num <= 0);
			bookList.add(new General(b_id, name, num, description));
			break;
		case 2 : // Journal
			int articleNum = 0;
			do { System.out.print("How many articles ? "); articleNum = sc.nextInt(); } while (articleNum <= 0);
			sc.nextLine(); //consume \n
			String[] articles = new String[articleNum];
			for(int i = 0; i < articleNum; ++i) {
				System.out.print("Article " + (i + 1) + " : ");
				articles[i] = sc.nextLine();
			}
			bookList.add(new Journal(b_id, name, articles));
			break;
		case 3 : // Ebook
			System.out.print("Book Description ? "); description = sc.nextLine();
			bookList.add(new Ebook(b_id, name, description));
			break;
		}

		return bookList.get(bookList.size() - 1);
	}
}