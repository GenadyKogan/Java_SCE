import java.util.Scanner;
import java.text.DecimalFormat;
public class CircleAreaT1 {
	static final double PI = 3.141592653589793;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	public static void main(String[] args) {
		double radius, area;
		Scanner input =new Scanner(System.in);
		System.out.print("Please enter height: ");
		radius=input.nextInt();
		//System.out.println("Area = "+ df2.format(PI*Math.pow(radius, 2)));
//		System.out.format("Area = %.2f", PI*Math.pow(radius, 2));
		System.out.println("Area = "+ PI*Math.pow(radius, 2));
		input.close();
	}
}
