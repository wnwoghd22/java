package Library.Book;

public class Journal extends Book {
	private String[] articles;	

	public Journal(String b_id, String name, int maxNum, int currentNum, String[] articles) {
		super(b_id, name, maxNum, currentNum);
		this.articles = articles;
	}

	@Override
	public void ShowInfo() {
		System.out.println("Book's ID : " + getB_id());
		System.out.println("Book's Name : " + getName());
		System.out.println("<Articles>");
		for(int i=0;i<articles.length;i++){
			System.out.println("Article" + (i+1) + " : " + articles[i]);
		}
		System.out.println();
	}
	@Override
	public boolean Lend(){
		if(currentNum<=maxNum){
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