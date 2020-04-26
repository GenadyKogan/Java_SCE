package Example;
import java.awt.*;
import javax.swing.*;

public class MyBorderLayout {

	public static void main(String[] args) {
        JFrame frame = new JFrame("MyBorderLayout");	
		//create BorderLayout
		BorderLayout myBorderLayout = new BorderLayout(); 
		//Sets the horizontal gap between components 
		myBorderLayout.setHgap(20);
		//Sets the vertical gap between components 
		//myBorderLayout.setVgap(20); 
		//Sets the LayoutManager to the Layout
		frame.setLayout(myBorderLayout);
		
		//add Button to the NORTH
		frame.add(new JButton("North"),BorderLayout.NORTH);
		//add Button to the SOUTH
		frame.add(new JButton("South"),BorderLayout.SOUTH);
		//add Button to the EAST
		frame.add(new JButton("East"), BorderLayout.EAST);
		//add Button to the WEST
		frame.add(new JButton("West"), BorderLayout.WEST);
		//add Button to the CENTER
		frame.add(new JButton("Center"),BorderLayout.CENTER);
		frame.pack();
		// TODO Auto-generated method stub
		 frame.setVisible(true);
	}

}
