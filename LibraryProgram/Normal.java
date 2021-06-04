package Library.Account;

import java.util.*;

public class Normal extends Account {
	public Normal() {
		super();
	}
	public Normal(String id, String pw) {
		super(id, pw, 7, 3);
	}
	/* for csv file converting */
	public Normal(String[] args) {
		/* args order : class, [bookList], class, id, pw */
		super(args[args.length - 2], args[args.length - 1], 7, 3);
		
		if(args.length == 5) return;
		String[] bListArgs = Arrays.copyOfRange(args, 1, args.length - 3);
		for(int i = 0; i < bListArgs.length; i += 9) {
			String[] sub = Arrays.copyOfRange(bListArgs, i, i + 9);
			bookList.add(new BorrowedBook(sub));
		}
	}
	
	@Override
	public void ShowInfo() {
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}
	}
}