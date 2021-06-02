package Library.Account;

public abstract class Account implements Borrower {
	private String id;
	private String pw;
	protected BorrowedBook[] bookList;
	public Account() {
		
	}
	public String getId() { return id; }
	public String getPw() { return pw; }
}

/* Default Class BorrowedBook */
class BorrowedBook {

	void printState() {

	}
}