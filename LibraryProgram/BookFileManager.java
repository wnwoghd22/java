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

		if(list[0].equals("Library.Book.General")) result = new General(list);
		if(list[0].equals("Library.Book.Journal")) result = new Journal(list);
		if(list[0].equals("Library.Book.Ebook")) result = new Ebook(list);
				
		return result;
	}
}