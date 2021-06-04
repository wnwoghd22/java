package Library.Account;

public class Librarian extends Account {
	private String employeeId;

	public Librarian(){
		super();
		employeeId = "00000000";
	}
	public Librarian(String id, String pw, String e_id) {
		super(id, pw, 5, 7);
		employeeId = e_id;
	}
	/* for csv file converting */
	public Librarian(String[] args) {
		super(args[2], args[3], 5, 7);
		employeeId = args[1];
		/**
		 * bookList?
		 */
	}

	@Override
	public void ShowInfo() {
		System.out.println(employeeId);
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}
	}

	public String getEmployeeId() { return employeeId; }

    /*public Book AddBook(){
        for(int i=0; bookList[i].equals(b_id)==false; i++){
            count = i;
        }
        bookList[count+1] = new BorrowedBook(b_id);  
    }
    public Book DeletBook(){
        for(int i=0; i<=bookList.length; i++){
            if(bookList[i].equals(b_id)){
                bookList[i]= new BorrowedBook("");
            }
        }
    }*/
    
    
    
    
}
