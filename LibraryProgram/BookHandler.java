package Library;

import java.util.*;
import java.io.*;

import Library.Book.*;
import Library.fileManager.BookFileManager;

public class BookHandler {
	private Scanner sc;
	private List<Book> bookList;
	private Book find;
	private BookFileManager fm;

	private int currentIndex; //show list
	public void setIndex(int i) {
		if(currentIndex + i < 0 || currentIndex + i >= bookList.size()) return;
		currentIndex += i;
	}
	public int getBound() {
		if(currentIndex + 10 < bookList.size()) return currentIndex + 10;
		else return bookList.size();
	}

	public BookHandler() {
		fm = new BookFileManager("./Library/book_data.txt");
		sc = new Scanner(System.in);
		bookList = new ArrayList<Book>(); currentIndex = 0;
	}
	
	/* methods */
	public void write(boolean debug) { 
		try { fm.WriteFile(bookList, debug); }
		catch(IOException e) { System.out.println(e); }
	}
	public void getList(boolean print) {
		try { 
			bookList = fm.ReadFile();
			if(print) for(Book b : bookList)
				System.out.println(b.getClass() + "	" + b.getB_id() + "	" + b.getName());
		}
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
	
	public List<String> ShowList() {
		List<String> result = new ArrayList<String>();

		for(int i = currentIndex; i < getBound(); ++i) {
			bookList.get(i).ShowInfo();
			result.add(bookList.get(i).getB_id());
		}
		return result;
	}
	public List<String> ShowList(int index) {
		List<String> result = new ArrayList<String>();
		currentIndex = index;

		for(int i = currentIndex; i < getBound(); ++i) {
			bookList.get(i).ShowInfo();
			result.add(bookList.get(i).getB_id());
		}
		return result;
	}
	public List<String> ShowList(boolean b) {
		List<String> result = new ArrayList<String>();
		setIndex(b ? 10 : -10);

		for(int i = currentIndex; i < getBound(); ++i) {
			bookList.get(i).ShowInfo();
			result.add(bookList.get(i).getB_id());
		}
		return result;
	}
	public Book getBook(String id) {
		for(Book b : bookList) {
			if(b.getB_id().equals(id)) { find = b; return b; }
		}
		System.out.println("can't find book!");
		return null;
	}
	public Book Lend(String id) {
		Book result = getBook(id);
		return result != null && result.Lend() ? result : null;
	}
	public void ReturnBook(String b_id) {
		Book b = getBook(b_id);
		if(b != null) b.ReturnBook();
	}
	public void ShowInfo() {
		if(find != null) find.ShowInfo();
	}
}