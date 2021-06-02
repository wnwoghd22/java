package Library;

public class A {
	private String name;
	private int num;

	public A(String s, int n) {
		name = s;
		num = n;
	}
	public void Show() {
		System.out.println("test");
	}

	public String getName() { return name; }
	public int getNum() { return num; }
}