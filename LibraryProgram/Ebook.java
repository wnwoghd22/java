package Library.Book;

public class Ebook extends Book {
	private String description;	

	public Ebook(String b_id, String name, String description) {
		super(b_id, name, 0);
		this.description = description;
	}
	/* for csv  converting */
	public Ebook(String[] args) {
	/* args order : class, id, class, cur, des, max, name */
		super(args[1], args[6], 0);
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
		currentNum++;
		return true;
	}
	@Override
	public void ReturnBook(){
		if(currentNum > 0) --currentNum;
		else currentNum = 0;
	}
	public String getDescription() { return description; }
}