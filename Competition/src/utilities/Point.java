package utilities;

public class Point {

	public static final int MAX_X = 1000000;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 800;
	public static final int MIN_Y = 0;

	private double x;
	private double y;

	/**
	 * Default Ctor for a point sets x and y to be 0.
	 */
	public Point() {
		this(0, 0);
	}

	/**
	 * Ctor for a point
	 * @param x x position
	 * @param y y position
	 */
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}

	/**
	 * Copy Ctor
	 * @param other other instance
	 * @throws IllegalArgumentException if other instance is null
	 */
	public Point(Point other) throws IllegalArgumentException {
		ValidationUtils.assertNotNull(other);
		this.setX(other.x);
		this.setY(other.y);
	}

	//region Setters

	/**
	 * @param x the x position of the point
	 * @throws IllegalArgumentException if x is out of range [{@value MIN_X},{@value MAX_X}]
	 */
	private void setX(double x) throws IllegalArgumentException {
		//ValidationUtils.assertInRange(x,MIN_X,MAX_X);
		this.x = x;
	}
	/**
	 * @param y the y position of the point
	 * @throws IllegalArgumentException if y is out of range [{@value MIN_Y},{@value MAX_Y}]
	 */
	private void setY(double y) throws IllegalArgumentException {
		//ValidationUtils.assertInRange(y,MIN_Y,MAX_Y);
		this.y = y;
	}
	//endregion

	//region Getters

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
	//endregion

	/**
	 * offset from the current point
	 * @param xOffset offset at the x axis
	 * @param yOffset offset at the y axis
	 * @return a new clone of the current point with an x and y offset
	 */
	public Point offset(double xOffset, double yOffset){
		return new Point(this.x+xOffset, this.y+yOffset);
	}

	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}
