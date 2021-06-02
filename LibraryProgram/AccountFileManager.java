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

				
		return result;
	}
}