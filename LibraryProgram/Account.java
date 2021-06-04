package Library.Account;

import java.util.*;

public abstract class Account implements Borrower {
	private String id;
	private String pw;
	private int duration, borrowLimit;
	protected List<BorrowedBook> bookList;
	public Account() {
		id = "defaultUser"; pw = "user1234";
		bookList = new ArrayList<BorrowedBook>(); duration = 7; borrowLimit = 3;
	}
	public Account(String _id, String _pw, int duration, int limit) {
		id = _id; pw = _pw;
		bookList = new ArrayList<BorrowedBook>();
		this.duration = duration; borrowLimit = limit;
	}
	@Override
	public boolean Borrow(String b_id, String name) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).b_id.equals(b_id)) {
				System.out.println("Already Borrowed " + b_id + ", " + name);
				return false;
			}
		}
		if(bookList.size() < borrowLimit) {
			bookList.add(new BorrowedBook(b_id, name, duration));
			return true;	
		}
		else {
			System.out.println("You can't borrowed more books!");
			return false;
		}
	}	
	@Override
	public String ReturnBook(String b_id) {
		BorrowedBook result = null;
		for(int i = 0; i < bookList.size(); ++i) {
			if(bookList.get(i).b_id.equals(b_id)) {
				result = bookList.remove(i);
				break;
			}
		}
		return result.b_id;
	}
	@Override
	public void Extend(String b_id) {
		for(int i = 0; i < bookList.size(); ++i) {
			if(bookList.get(i).b_id.equals(b_id)) {
				bookList.get(i).Extend();
			}
		}
	}

	public String getId() { return id; }
	public String getPw() { return pw; }
	public String getBookList() {
		String result = "";
		for(int i = 0; i < bookList.size(); ++i) {
			result += bookList.get(i).getString();
			if(i != bookList.size() - 1) result += ",";
		}
		return result;
	}
}

/* Default Class BorrowedBook */
class BorrowedBook {
	String b_id, name;
	int extensionLimit;
	Calendar from, to;

	BorrowedBook(String b_id, String name, int d) {
		this.b_id=b_id; this.name = name;
		extensionLimit = 2;
	
    		from = Calendar.getInstance();
    		to = Calendar.getInstance(); to.add(Calendar.DATE, d);
	}
    
	void Extend() {
		if(extensionLimit>0) {
		extensionLimit--;
		to.add(Calendar.DATE, 7);
	}
}
	void printState() {
		System.out.println("Book Id : "+b_id);
		System.out.println("lended from : "+from);
		System.out.println("Due of return : "+to);
		System.out.println("Left Extension : " +extensionLimit);
	}
	String getString() {
		String result = b_id + "," + name + "," + extensionLimit + ",";
		result += from.get(Calendar.YEAR) + "," + from.get(Calendar.MONTH) + "," + from.get(Calendar.DATE) + ",";
		result += to.get(Calendar.YEAR) + "," + to.get(Calendar.MONTH) + "," + to.get(Calendar.DATE);
		return result;
	}
}