package Library.fileManager;

//import java.lang.reflect.Method;

import Library.Account.*;

public class AccountFileManager extends FileManager<Account> {
	public AccountFileManager(String _path) {
		super(_path);
	}

	@Override
	protected Account Convert(String _data) {
		Account result = null;
		String[] list = _data.split(",");

		if(list[0].equals("Library.Account.Normal")) result = new Normal(list);
		if(list[0].equals("Library.Account.Student")) result = new Student(list);
		if(list[0].equals("Library.Account.Professor")) result = new Professor(list);
		if(list[0].equals("Library.Account.Librarian")) result = new Librarian(list);
				
		return result;
	}
}