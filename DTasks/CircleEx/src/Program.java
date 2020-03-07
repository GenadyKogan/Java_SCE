
public class Program {
	public static void main(String[] args) {
		Point p=new Point(1,1);
		Circle c=new Circle(p,5);
		System.out.println("c is "+c.toString());
		p.setX(0);
		c.getCenter().setY(20);
	}
}
