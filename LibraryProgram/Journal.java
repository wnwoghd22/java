package Library.Book;

import java.util.*;

public class Journal extends Book {
	private String[] articles;	

	public Journal(String b_id, String name, String[] articles) {
		super(b_id, name, 1);
		this.articles = articles;
	}
	/* for csv converting */
	public Journal(String[] args) {
		/* args order : class, [articles], id, class, cur, max , name */
		super(args[args.length - 5], args[args.length - 1], 1);
		currentNum = Integer.parseInt(args[args.length - 3]);
		this.articles = Arrays.copyOfRange(args, 1,  args.length - 5);
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

	public String getArticleString() {
		String result = "";
		for(int i = 0; i < articles.length; ++i) {
			result += articles[i];
			if(i != articles.length - 1) result += ",";
		}
		return result;
	}
}