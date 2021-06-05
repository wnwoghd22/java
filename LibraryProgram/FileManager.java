package Library.fileManager;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

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

		Method[] methods = c.getMethods();
		List<Method> getters = new ArrayList<Method>();
		for(Method m : methods) if(isGetter(m)) getters.add(m);
		
		Collections.sort(getters, new Comparator<Method>() {
			@Override
			public int compare(Method m1, Method m2) {
				return m1.getName().compareTo(m2.getName());
			}
		});
		for(Method m : getters) {
			try { result += "," + m.invoke(_data); }
			catch (InvocationTargetException e) { 
				e.getTargetException().printStackTrace(); //getTargetException
			}
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
				T temp = Convert(data);
				if(temp != null) list.add(temp);
			}
		}	
		return list;	
	}
	public void WriteFile(List<T> contents, boolean debug) throws IOException {
		String data = "";
		for(T element : contents) data += getString(element) + "\n";
		if(debug) System.out.print(data);

		FileWriter fw = new FileWriter(path);
		fw.write(data);
		fw.flush();
		fw.close();
		if(debug) System.out.println("Save");
	}
}