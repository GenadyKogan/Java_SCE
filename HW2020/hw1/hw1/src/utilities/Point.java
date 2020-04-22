package utilities;

/**
 * A representation of a cartesian point
 */
public class Point {

	public static final int MAX_X = 1000000;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 800;
	public static final int MIN_Y = 0;

	private double x;
	private double y;

	/**
	 * Ctor for a point
	 * @param x x position
	 * @param y y position
	 */
	public Point(double x, double y) {
		if(x<MIN_X||x>MAX_X) {
			this.x=Math.random()*MAX_X;
			System.out.print("The value "+x+" is illegal for X, therefore has been replaced with "+this.x+"\n");
		}
		if(y<MIN_Y||y>MAX_Y) {
			this.y=Math.random()*MAX_Y;
			System.out.print("The value "+y+" is illegal for Y, therefore has been replaced with "+this.y+"\n");
		}
			else{
			setX(x);
			setY(y);
		}
		System.out.print("Point (" + getX()+","+getY()+") has been created\n");
	}

	/**
	 * Copy Ctor
	 * @param other other instance
	 */
	public Point(Point other){
		this.setX(other.x);
		this.setY(other.y);
	}

	//region Setters

	/**
	 * @param x the x position of the point
	 */
	boolean setX(double x) {
		if(x<MIN_X||x>MAX_X) {
			System.out.print("The value "+x+" is illegal for X\n");
			return false;
		}
		else {
			this.x = x;
			return true;
		}
		
	}
	/**
	 * @param y the y position of the point
	 */
	boolean setY(double y) {
		if(y<MIN_Y||y>MAX_Y) {
			System.out.print("The value "+y+" is illegal for Y\n");
			return false;
		}
		else {
		this.y = y;
		return true;
		}
	}


	/**
	 * @return the x value of the point
	 */
	public double getX() {
		return x;
	}

	/**
	  * @return the y value of the point
	 */
	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")\n";
	}
	public boolean equals(Object other) {
		boolean ans=false;
		if(other instanceof Point) {
			ans=( getX() ==((Point)other).getX() &&  getY() ==((Point)other).getY());
			return ans;
		}
		return false;
		
	}


	
}
