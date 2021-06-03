package Library.Account;

import java.util.*;

public abstract class Account implements Borrower {
	private String id;
	private String pw;
	protected List<BorrowedBook> bookList;
	public Account() {
		
	}
	public void ShowInfo(){
	System.out.println("ID : "+ id +"\n" + 
		"Available count of book : "+bookList.length+ "Borrowed List : " + bookList);
   	}
	public void Borrow(String b_id){
	}
	public String ReturnBook(String b_id){ 
		return b_id;
	}

	public String getId() { return id; }
	public String getPw() { return pw; }
}

/* Default Class BorrowedBook */
class BorrowedBook {
	String b_id;
	int extentionLimit;
	
	Calendar from = Calendar.getInstance();
	Calendar to = Calendar.getInstance();
	public BorrowedBook(String b_id) {
		this.b_id=b_id;
		extentionLimit = 2;
		
	}
    Calendar from = Calendar.getInstance();
    Calendar to = Calendar.getInstance();
    
    public void Extend(int d) {
	if(extentionLimit>0) {
		extentionLimit--;
		to.add(Calendar.DATE, d);
	}
}
    public void printState(){
        System.out.println("Book Id : "+b_id);
        System.out.println("lended from : "+from);
        System.out.println("Due of return : "+to);
        System.out.println("Left Extention : " +extentionLimit);
    }
}