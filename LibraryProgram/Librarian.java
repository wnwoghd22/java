package Library.Account;
import java.util.*;


public class Librarian extends Account {
	private String employeeId;

	public Librarian(){
		super();
		employeeId = "00000000";
	}
	public Librarian(String id, String pw, String e_id) {
		super(id, pw, 7, 5);
		employeeId = e_id;
	}
	/* for csv file converting */
	public Librarian(String[] args) {
		/* args order : class, [bookList], class, e_id, id, pw */
		super(args[2], args[3], 7, 5);
		employeeId = args[1];
		
		if(args.length == 5) return;
		String[] bListArgs = Arrays.copyOfRange(args, 1, args.length - 4);
		for(int i = 0; i < bListArgs.length; i += 9) {
			String[] sub = Arrays.copyOfRange(bListArgs, i, i + 9);
			bookList.add(new BorrowedBook(sub));
		}
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
