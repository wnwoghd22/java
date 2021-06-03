package geometric;

import java.util.Date;

public class GeometricObject {
	private String color;
	private boolean filled;
	private final Date dateCreated;

	public GeometricObject() { color = "white"; filled = false; dateCreated = new Date(); }
	public GeometricObject(String color, boolean filled) {
		this.color = color; this.filled = filled; dateCreated = new Date();
	}
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
	
	public boolean isFilled() { return filled; }
	public void setFilled(boolean filled) { this.filled = filled; }

	public Date getDateCreated() { return dateCreated; }

	public String toString() { return "color : " + color  + ", filled : " + filled + ", created date : " + dateCreated; }
	public void print() { System.out.println(toString()); } 

}