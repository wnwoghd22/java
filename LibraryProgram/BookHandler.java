package Library;

import Library.Book.*;
import Library.fileManager.BookFileManager;

public class BookHandler {
	private Book[] bookList;
	private BookFileManager fm;
	public BookHandler() {
		fm = new BookFileManager("./Library/data.txt");
	}
	
	/* methods */
	public void write() { fm.WriteFile(); }
}