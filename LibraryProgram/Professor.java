package Library.Account;

public class Professor extends Account{
	private String employeeId;

	public Professor() {
		super();
		employeeId = "00000000";
	}
	public Professor(String id, String pw, String e_id) {
		super(id, pw, 10, 14);
		employeeId = e_id;
	}
	/* for csv file converting */
	public Professor(String[] args) {
		super(args[2], args[3], 10, 14);
		employeeId = args[1];
		/**
		 * bookList?
		 */
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
