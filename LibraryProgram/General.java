package Library.Book;

public class General extends Book {
	private String description;	

	public General(String b_id, String name, int maxNum, int currentNum, String description) {
		super(b_id, name, maxNum, currentNum);
		this.description = description;
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
		if(currentNum+1<=MaxNum){
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
}