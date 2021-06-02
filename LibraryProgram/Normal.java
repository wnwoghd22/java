package Library.Account;

public class Normal extends Account {
	public Normal() {
		super();
	}
	
	@Override
	public void ShowInfo() {
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}
	}
}