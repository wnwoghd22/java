package Library.fileManager;

//import java.lang.reflect.Method;

import Library.Book.*;

public class BookFileManager extends FileManager<Book> {
	public BookFileManager(String _path) {
		super(_path);
	}

	@Override
	protected Book Convert(String _data) {
		Book result = null;
		String[] list = _data.split(",");

		/* result = new Book(list); */
				
		return result;
	}
}