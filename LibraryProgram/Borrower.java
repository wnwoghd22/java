package Library.Account;

public interface Borrower {
	public void Borrow();
	public String ReturnBook(String b_id);
	public void ShowInfo();
}