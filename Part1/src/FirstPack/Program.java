package FirstPack;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
public class Program {
	public static void main(String[] args) {
		/*Scanner s = new Scanner(System.in);
		double price;
		double totalPrice;
		final double TAXES=17;
		System.out.println("Please enter the product's price: ");
		price=s.nextDouble();
		
		totalPrice=price+(price*TAXES/100);
		System.out.println("Total price including "+TAXES + "% Ttaxes is "+ totalPrice);*/
//-------------------------------------------------------------------
		/*STRING*/
		//Scanner s=new Scanner(System.in);
		//String firstName,lastName;
		//System.out.println("Enter your first name: ");
		//firstName=s.next();
		//System.out.println("Enter your last name: ");
		//lastName=s.next();/*s.nextLine()*/
		//System.out.println("Your first name: "+ firstName);
		//System.out.println("Your lsat name: "+ lastName);
//-------------------------------------------------------------------		
		/*BUFFER*/
		//Scanner s = new Scanner(System.in);
		//System.out.println("Enter number: ");
		//int n1,n2;
		//n1=s.nextInt();
		//System.out.println("Enter another number: ");
		//n2=s.nextInt();
		//System.out.println("n1 = "+n1+" n2 = "+n2);
		
		//Scanner s=new Scanner(System.in);
		//String firstName,lastName;
		//System.out.println("Enter your first name: ");
		//firstName=s.next();
		//System.out.println("Enter your last name: ");
		//lastName=s.nextLine();
		//System.out.println("Your first name: "+ firstName);
		//System.out.println("Your lsat name: "+ lastName);
//-------------------------------------------------------------------	
		/*GUI*/
		//JOptionPane.showMessageDialog(null, "Hello word");
		//JOptionPane.showMessageDialog(null, "Hello word","GUI",JOptionPane.WARNING_MESSAGE);
		//String name=JOptionPane.showInputDialog("Enter you name: ");
		//JOptionPane.showMessageDialog(null,"Hi " + name + "!");
		String temp=JOptionPane.showInputDialog("Enter you age: ");
		int age  = Integer.parseInt(temp);
		JOptionPane.showMessageDialog(null,"Next year you will be "+ age+1 +" year old");
		
		
	}
}
