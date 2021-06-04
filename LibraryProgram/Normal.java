package Library.Account;

public class Normal extends Account {
	public Normal() {
		super();
	}
	public Normal(String id, String pw) {
		super(id, pw, 3, 7);
	}
	/* for csv file converting */
	public Normal(String[] args) {
		/* args order : class, class, id, pw, [bookList] */
		super(args[2], args[3], 3, 7);
		/**
		 * bookList?
		 */
	}
	
	@Override
	public void ShowInfo() {
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}
	}
}