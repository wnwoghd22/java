package Library.Book;

public abstract class Book {
	private String b_id;
	protected String name;
	protected int maxNum;
	protected int currentNum;

	public Book(String b_id, String name, int maxNum) {
		this.b_id = b_id; this.name = name;
		this.maxNum = maxNum; this.currentNum = 0;
	}
	
	public abstract void ShowInfo();
	public abstract boolean Lend();
	public abstract void ReturnBook();

	public String getB_id() { return b_id; }
	public String getName() { return name; }
	public int getMaxNum() { return maxNum; }
	public int getCurrentNum() { return currentNum; }
}