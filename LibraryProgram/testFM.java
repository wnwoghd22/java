package Library.fileManager;
import Library.A;

public class testFM extends FileManager<A> {
	public testFM(String s) {
		super(s);
	}
	@Override
	protected A Convert(String _data) {
		A result = null;
		String[] list = _data.split(",");
		for(String s : list) System.out.println(s);

		result = new A(list[1], Integer.parseInt(list[2]));
				
		return result;
	}
}