package Example;
import javax.swing.*;
import java.awt.*;
public class MyGridLayout {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyGridLayout");	
		//create GridLayout
		GridLayout myGridLayout = new GridLayout(3,2);
		//myGridLayout.setHgap(20);
		//myGridLayout.setVgap(20);
		frame.setLayout(myGridLayout);

		//add Buttons according to the GridLayout
		//1 2 
		//3 4
		//5 6
		frame.add(new JButton("1")); 
		frame.add(new JButton("2")); 
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(400,150);
        frame.setVisible(true);

	}

}
