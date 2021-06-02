package Library;

import java.util.*;

import Library.Book.*;
import Library.fileManager.BookFileManager;

public class BookHandler {
	private List<Book> bookList;
	private BookFileManager fm;
	public BookHandler() {
		fm = new BookFileManager("./Library/book_data.txt");
	}
	
	/* methods */
	public void write() { fm.WriteFile(bookList); }
}