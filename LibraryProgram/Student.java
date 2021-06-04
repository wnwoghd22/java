package Library.Account;

import java.util.*;

public class Student extends Account {
	private String studentId;
	private String major;

	public Student() {
		super();
		studentId = "00000000"; major = "default";
	}
	public Student(String id, String pw, String s_id, String major) {
		super(id, pw, 14, 5);
		studentId = s_id; this.major = major;
	}
	/* for csv file converting */
	public Student(String[] args) {
		/* args order : class, [bookList], class, id, major, pw, s_id */
		super(args[args.length - 4], args[args.length - 2], 14, 5);
		studentId =args[args.length - 1]; this.major = args[args.length - 3];
		
		if(args.length == 7) return;
		String[] bListArgs = Arrays.copyOfRange(args, 1, args.length - 5);
		for(int i = 0; i < bListArgs.length; i += 9) {
			String[] sub = Arrays.copyOfRange(bListArgs, i, i + 9);
			bookList.add(new BorrowedBook(sub));
		}
	}
    	
	@Override
	public void ShowInfo() {
		System.out.println(studentId);
		System.out.println(major);
		System.out.println(getId());
		for(BorrowedBook b : bookList) {
			b.printState();
		}    
	}

	public String getStudentId() { return studentId; }
	public String getMajor() { return major; }
}
