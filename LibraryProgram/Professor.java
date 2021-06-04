package Library.Account;

import java.util.*;

public class Professor extends Account{
	private String employeeId;

	public Professor() {
		super();
		employeeId = "00000000";
	}
	public Professor(String id, String pw, String e_id) {
		super(id, pw, 14, 10);
		employeeId = e_id;
	}
	/* for csv file converting */
	public Professor(String[] args) {
		/* args order : class, [bookList], class, e_id, id, pw */
		super(args[args.length - 2], args[args.length - 1], 14, 10);
		employeeId = args[args.length - 3];
		
		if(args.length == 6) return;
		String[] bListArgs = Arrays.copyOfRange(args, 1, args.length - 4);
		for(int i = 0; i < bListArgs.length; i += 9) {
			String[] sub = Arrays.copyOfRange(bListArgs, i, i + 9);
			bookList.add(new BorrowedBook(sub));
		}
	}

	@Override
	public void ShowInfo(){
		System.out.println(employeeId);
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}
	}
	public String getEmployeeId() { return employeeId; }
}
