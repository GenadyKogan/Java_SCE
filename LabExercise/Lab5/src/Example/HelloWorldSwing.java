package Example;
import javax.swing.*;
 
public class HelloWorldSwing { 
public static void main(String[] args) { 
	JFrame frame = new JFrame("HelloWorldSwing"); 
	final JLabel label = new JLabel("Hello World"); 

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(label); 
	//frame.add(label);
	frame.pack();
	//frame.setSize(500,100);
	frame.setVisible(true); 
	}
 }
