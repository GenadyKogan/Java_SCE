import java.util.Scanner;

public class Program {
	public enum Dessert{IceCream,Cake,Cooki};
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Dessert d=Dessert.IceCream;
//		System.out.println(d.ordinal()+" --> "+ d.name());
//		System.out.println("All values: ");
		Dessert[] allDesserts=Dessert.values();
//		for(int i=0;i<allDesserts.length;i++) {
//			System.out.println(allDesserts[i].ordinal()+" --> "+allDesserts[i].name());
//		}
//		System.out.println("What is your favorite dessert? ");
//		Dessert ans=Dessert.valueOf(s.next());
//		System.out.println("Your favorite dessert is "+ans+"("+ans.ordinal()+")");
		Food myFovariteFood=new Food(Food.Dessert.Cake,Food.JunkFood.Pizza);
		System.out.println("My favorite food is: "+myFovariteFood.toString());
	}

}
