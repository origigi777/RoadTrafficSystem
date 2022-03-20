package Board.pack;

/**
 * this class creates points for the program's graph
 */
public class Point {
	protected double axisx;
	protected double axisy;
	public static int counter = 0;
	protected int id;

	public Point() { // check if x and y are  correct  fix the time for what i want to wait 
		this.axisx = (float) ((Math.random() * (80 - 0)) + 0);
		this.axisy = (float) ((Math.random() * (60 - 0)) + 0);
		counter++;
		this.id = counter;
		if (this instanceof Junction) {
		
		System.out.println("Creating Junction "+id+" ("+String.format("%.2f", getAxisx())+","+String.format("%.2f", getAxisy())+")");
		} else {
			System.out.println("Creating Point ("+String.format("%.2f", getAxisx())+","+String.format("%.2f", getAxisy())+")");
		}
	}

	public Point(double axisx, double axisy) {
		this.axisx = axisx;
		this.axisy = axisy;
		counter++;
		this.id = counter;

		if (axisx <= 800 && axisx >= 0) {
			this.axisx = axisx;
		} else {
			this.axisx = ((Math.random() * (800 - 0)) + 0);
			System.out.println(axisx + " is illegal value for x and has been replaced with " + String.format("%.2f",getAxisx()));
		}

		if (axisy <= 600 && axisy >= 0) {
			this.axisy = axisy;
		} else {
			this.axisy = ((Math.random() * (800 - 0)) + 0);
			System.out.println(axisy + " is illegal value for y and has been replaced with " + String.format("%.2f", getAxisy()));
		}
		if (this instanceof Junction) {
			
			System.out.println("creating junction "+id+" at point"+" (" +String.format("%.2f", getAxisx())+ ","
					+String.format("%.2f", getAxisy()) + ")");
		} else {
			System.out.println("Creating Point ("+String.format("%.2f", getAxisx())+","+String.format("%.2f", getAxisy())+")");
		}

		
//getters and setters of the x and y after the check
	}

	public double getAxisx() {
		return axisx;
	}

	public void setAxisx(double axisx) {
		this.axisx = axisx;
	}

	public double getAxisy() {
		return axisy;
	}

	@Override
	public String toString() {
		return "Point [axisx=" +String.format("%.2f", getAxisx()) + ", axisy="  +String.format("%.2f", getAxisy()) + "]";
	}

	public void setAxisy(double axisy) {
		this.axisy = axisy;
	}

	public double calcDistance(Point p1) { // Calculation of distance
		return (float) Math.sqrt(
				(p1.axisy - this.axisy) * (p1.axisy - this.axisy) + (p1.axisx - this.axisx) * (p1.axisx - this.axisx));

	}


}
