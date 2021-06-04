package Library.Book;

public class General extends Book {
	private String description;	

	public General(String b_id, String name, int maxNum, String description) {
		super(b_id, name, maxNum);
		this.description = description;
	}
	/* for csv converting */
	public General(String[] args) {
		/* args order : (class, b_id, class, cur, des, max, name) */
		super(args[1], args[6], Integer.parseInt(args[5]));
		currentNum = Integer.parseInt(args[3]);
		description = args[4];
	}

	@Override
	public void ShowInfo() {
		System.out.println("Book's ID : " + getB_id());
		System.out.println("Book's Name : " + getName());
		System.out.println("Description : " + description);
		System.out.println();
	}
	@Override
	public boolean Lend(){
		if(currentNum+1<=maxNum){
			currentNum++;
			return true;
		}
		else return false;	
	}
	@Override
	public void ReturnBook(){
		if(currentNum-- > 0) currentNum--;
		else currentNum = 0;
	}
	public String getDescription() { return description; }
}