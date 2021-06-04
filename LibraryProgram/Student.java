package Library.Account;
public class Student extends Account {
	private String studentId;
	private String major;

	public Student() {
		super();
		studentId = "00000000"; major = "default";
	}
	public Student(String id, String pw, String s_id, String major) {
		super(id, pw, 5, 14);
		studentId = s_id; this.major = major;
	}
	/* for csv file converting */
	public Student(String[] args) {
		super(args[3], args[4], 5, 14);
		studentId =args[1]; this.major = args[2];
		/**
		 * bookList?
		 */
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
