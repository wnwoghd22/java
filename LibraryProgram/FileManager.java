package Library.fileManager;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.Method;

public abstract class FileManager<T> {
	private final String path;

	public FileManager(String _path) {
		path = _path;
	}

	private boolean isGetter(Method m) {
		boolean result = true;
		if(!m.getName().startsWith("get")) result = false;
		if(m.getParameterTypes().length != 0) result = false;
		if(void.class.equals(m.getReturnType())) result = false;
		return result;
	}

	protected abstract T Convert(String _data);
	private String getString(T _data) {
		Class c = _data.getClass();
		String result = c.getName();

		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods) if(isGetter(m)) {
			try { result += "," + m.invoke(_data); }
			catch(Exception e) {
				System.out.println(m.getName() + e);
				continue;
			}
		}

		return result;
	}

	public List<T> ReadFile() throws IOException {
		List<T> list  = new ArrayList<T>();
		File file = new File(path);
		if(file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String data = null;
			while( (data = reader.readLine()) != null ) {
				list.add(Convert(data));
			}
		}	
		return list;	
	}
	public void WriteFile(List<T> contents) throws IOException {
		String data = "";
		for(T element : contents) data += getString(element) + "\n";

		FileWriter fw = new FileWriter(path);
		fw.write(data);
		fw.flush();
		fw.close();
		System.out.println("Save");
	}
}