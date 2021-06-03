public class Main{
	public static void main(String args[]) {
		TV tv = new TV();

			tv.ShowInfo();
			tv.turnOn();

			tv.ShowInfo();

			tv.channelUp();
			tv.ShowInfo();

			//System.out.println(tv.channel);

			java.util.Date date = new java.util.Date();
			System.out.println(date.toString());
		
	}
}