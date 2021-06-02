public class GObject {
	public String color;
	public java.util.Date date;
	public GObject() {
		color = "White";
		date = new java.util.Date();
	}
	public GObject(String c) {
		color = c;
		date = new java.util.Date();
	}
	public void cStatePrint() {
		System.out.println(" created on " + date + ", whose color is " + color);
	}
}