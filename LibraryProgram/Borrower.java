package Library.Account;

public interface Borrower {
	public boolean Borrow(String b_id, String name);
	public String ReturnBook(String b_id);
	public void ShowInfo();
	public void Extend(String b_id);
	public String[] ShowBookList();
}