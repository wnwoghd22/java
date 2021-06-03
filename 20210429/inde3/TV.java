public class TV {
	private int channel = 1;
	private int volumeLevel = 1;
	private boolean on = false;

	public TV() {}
	public void turnOn() { on = true; }
	public void turnOff() { on = false; }
	public void setChannel(int c) { if(on && c >= 1 && c <= 120) channel = c; }
	public void channelUp() { if(on && channel < 120) ++channel; } 
	public void channelDown() { if(on && channel > 1) --channel; } 
	public void setVolume(int v) { if(on && v >= 1 && v <= 7) volumeLevel = v; }
	public void volumeUp() { if(on && volumeLevel < 7) ++volumeLevel; } 
	public void volumeDown() { if(on && volumeLevel > 1) --volumeLevel; }
	public void ShowInfo() {
		System.out.println(on ?
			("channel : " + channel + ", volume : " + volumeLevel) :
			"Off");
	} 
}